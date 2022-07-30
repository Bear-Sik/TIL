package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_15650 {
    static int n, m;
    static int[] arr;
    static int[] chk;

    public static void dfs(int l) {
        if(l == m) {
            for(int i : arr)
                System.out.print(i + " ");
            System.out.println();
        }
        else {
            for(int i = 1; i <= n; i++) {
                boolean flag = true;
                if(l >= 1) {
                    for(int j : arr) {
                        if(j > i)  flag = false;
                    }
                }
                if(chk[i] == 0 && flag) {
                    arr[l] = i;
                    chk[i] = 1;
                    dfs(l + 1);
                    chk[i] = 0;
                    arr[l] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        chk = new int[n + 1];

        dfs(0);
    }
}
