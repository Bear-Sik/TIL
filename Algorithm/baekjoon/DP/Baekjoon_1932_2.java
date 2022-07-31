package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1932_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];
        int[][] DP = new int[N][N];

        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j <= i; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        DP[0][0] = arr[0][0];

        for(int i = 1; i < N; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0)
                    DP[i][j] = DP[i-1][0] + arr[i][j];
                else if(j == i)
                    DP[i][j] = DP[i-1][j-1] + arr[i][j];
                else
                    DP[i][j] = Math.max(DP[i-1][j-1], DP[i-1][j]) + arr[i][j];
            }
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++)
            if(DP[N-1][i] > max)
                max = DP[N-1][i];

        System.out.println(max);
    }
}
