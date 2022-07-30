package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_15655 {
    static int n, m;
    static int[] arr;
    static int[] chk;
    static Integer[] input;

    static StringBuilder sb = new StringBuilder();

    public static void dfs(int d) {
        if(d == m) {
            for(int i : arr)
                sb.append(i + " ");
            sb.append("\n");
        }
        else {
            for(int i = 0; i < n; i++) {
                if(chk[i] == 1) continue;
                boolean flag = true;

                for(int tmp : arr) {
                    if(input[i] <= tmp)
                        flag = false;
                }

                if(flag) {
                    arr[d] = input[i];
                    chk[i] = 1;
                    dfs(d+1);
                    chk[i] = 0;
                    arr[d] = 0;
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
        chk = new int[n];
        input = new Integer[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)  input[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(input);

        dfs(0);

        System.out.println(sb.toString());
    }
}
