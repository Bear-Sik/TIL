package dp;

import java.util.Scanner;

public class Baekjoon_1309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];

        arr[0] = 1;
        arr[1] = 3;

        for(int i = 2; i < n + 1; i++) {
            arr[i] = arr[i-1] * 2 + arr[i-2];
        }

        System.out.println(arr[n]);
    }

}
