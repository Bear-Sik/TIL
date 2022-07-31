package dp;

import java.io.IOException;
import java.util.Scanner;

public class Baekjoon_2579 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];
        int[] DP = new int[N];

        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();


        DP[0] = arr[0];

        if(N == 1) {
            System.out.println(DP[0]);
            return ;
        }

        if(N == 2) {
            System.out.println(arr[1] + arr[0]);
            return ;
        }

        DP[1] = arr[1] + arr[0];
        DP[2] = arr[2] + Math.max(arr[0], arr[1]);

        for(int i = 3; i < N; i++)
            DP[i] = Math.max((DP[i-2] + arr[i]), (DP[i-3] + arr[i-1] + arr[i]));

        System.out.println(DP[N-1]);
    }
}
