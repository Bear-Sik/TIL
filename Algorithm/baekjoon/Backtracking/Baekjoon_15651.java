package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_15651 {
    static int n, m;
    static int[] arr;

    public static void dfs(int l) {
        if(l == m) {
            for(int i : arr)
                System.out.print(i + " ");
            System.out.println();
        }
        else {
            for(int i = 1; i <= n; i++) {
                arr[l] = i;
                dfs(l + 1);
                arr[l] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        dfs(0);
    }
}
