package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_15666 {
    static int N, M;
    static int[] nums, candidate;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        candidate = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        dfs(0, 0);

        System.out.println(sb.toString());
    }

    public static void dfs(int depth, int start) {
        if(depth == M) {
            for(int i : candidate)
                sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        int before = -1;
        for(int i = start; i < N; i++) {
            if(before != nums[i]) {
                candidate[depth] = nums[i];
                before = nums[i];
                dfs(depth+1, i);
            }
        }
    }
}
