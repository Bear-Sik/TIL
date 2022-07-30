package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_15649 {
    static int[] arr;
    static int[] chk;

    static int n, m;

    public static void combi(int l) {
        if(l == m) {
            for(int i : arr)
                System.out.print(i + " ");
            System.out.println();
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(chk[i] == 0) {
                arr[l] = i;
                chk[i] = 1;
                combi(l + 1);
                chk[i] = 0;
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

        combi(0);
    }
}
