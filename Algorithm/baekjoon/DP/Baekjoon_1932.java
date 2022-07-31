package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1932 {
    static int N;

    static int[][] arr;
    static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        DP = new int[N][N];

        for(int i = 1; i <= 5; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < i; j++)
                arr[i-1][j] = Integer.parseInt(st.nextToken());
        }

        solve(0, 0);
        System.out.println(DP[0][0]);
    }


    public static int solve(int level, int index) {
        if(level == N-1)
            return DP[level][index] = arr[level][index];

        return DP[level][index] = Math.max(solve(level + 1, index), solve(level + 1, index + 1)) + arr[level][index];
    }
}
