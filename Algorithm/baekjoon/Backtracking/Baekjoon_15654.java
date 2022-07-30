package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_15654 {
    static int n, m;
    static int[] arr;
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
                boolean flag = true;
                for(int j : arr) {
                    if(j == input[i])
                        flag = false;
                }

                if(flag) {
                    arr[d] = input[i];
                    dfs(d+1);
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
        input = new Integer[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)  input[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(input);

        dfs(0);

        System.out.println(sb.toString());
    }
}
