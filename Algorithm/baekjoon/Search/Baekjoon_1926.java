package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1926 {
    static class pos{
        int x;
        int y;
        pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int picture_num = 0;
    static int picture_max = Integer.MIN_VALUE;
    static int height = 0;
    static int width = 0;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[][] map;

    static Queue<pos> q = new LinkedList<>();

    public static int dfs(int x, int y, int level) {
        for(int i = 0; i < 4; i++) {
            int digit_x = x + dx[i];
            int digit_y = y + dy[i];

            if(digit_x < 0 || digit_y < 0 || digit_x >= height || digit_y >= width || map[digit_x][digit_y] == 0)
                continue;

            map[digit_x][digit_y] = 0;
            level = dfs(digit_x, digit_y, level + 1);
        }

        return level;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        map = new int[height][width];

        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1)
                    q.offer(new pos(i, j));
            }
        }

        if (q.size() != 0) {
            while (!q.isEmpty()) {
                pos tmp = q.poll();

                if (map[tmp.x][tmp.y] == 0)
                    continue;

                picture_num++;
                map[tmp.x][tmp.y] = 0;
                int size = dfs(tmp.x, tmp.y, 1);
                picture_max = Math.max(size, picture_max);
            }

            System.out.println(picture_num + "\n" + picture_max);
        }
        else {
            System.out.println(0 + "\n" + 0);
        }
    }
}
