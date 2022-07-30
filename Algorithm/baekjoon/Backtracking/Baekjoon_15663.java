package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_15663 {
    static int n, m;
    static int[] arr;
    static boolean[] chk;
    static Integer[] input;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        input = new Integer[n];
        chk = new boolean[n];
        arr = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)  input[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(input);

        dfs(0);
        System.out.println(sb.toString());
    }

    public static void dfs(int d) {
        if(d == m) {
            for(int i : arr)
                sb.append(i + " ");
            sb.append("\n");
        }

        else {
            int before = -1;
            for(int i = 0; i < n; i++) {

                if(!chk[i] && before != input[i]) {
                    chk[i] = true;
                    arr[d] = input[i];
                    before = input[i];
                    dfs(d + 1);
                    chk[i] = false;
                }
            }
        }
    }
}
