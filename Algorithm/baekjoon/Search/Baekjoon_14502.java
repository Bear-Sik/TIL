package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
    int x;
    int y;

    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class b_14502 {
    static int N, M;
    static int answer = Integer.MIN_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static int[][] copied_map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        copied_map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(answer);
    }

    // 벽 세우기
    public static void dfs(int depth) {
        if(depth == 3) {
            bfs();
            return ;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    // 바이러스 전이
    public static void bfs() {
        copied_map = copy_map();
        Queue<Pos> tmp_q = find_virus();

        while(!tmp_q.isEmpty()) {
            Pos tmp = tmp_q.poll();
            for(int i = 0; i < 4; i++) {
                int next_x = tmp.x + dx[i];
                int next_y = tmp.y + dy[i];

                if(next_x >= 0 && next_y >= 0 && next_x < N && next_y < M && copied_map[next_x][next_y] == 0) {
                    tmp_q.offer(new Pos(next_x, next_y));
                    copied_map[next_x][next_y] = 2;
                }
            }
        }

        int virus_cnt = count_safe();

        if(answer < virus_cnt)
            answer = virus_cnt;
    }

    // map 깊은 복사를 위해 사용
    public static int[][] copy_map() {
        int[][] arr = new int[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                arr[i][j] = map[i][j];
            }
        }

        return arr;
    }

    // 바이러스 위치 검색하여 큐로 반환
    public static Queue<Pos> find_virus() {
        Queue<Pos> tmp = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++){
                if(copied_map[i][j] == 2) {
                    tmp.offer(new Pos(i, j));
                }
            }
        }

        return tmp;
    }

    // 안전지역 카운트
    public static int count_safe() {
        int cnt = 0;
        for(int[] i : copied_map) {
            for(int j : i) {
                if(j == 0)
                    cnt++;
            }
        }

        return cnt;
    }
}
