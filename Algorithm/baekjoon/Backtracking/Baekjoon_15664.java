package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_15664 {
    static int N, M;
    static Integer[] nums;
    static int[] candidate;
    static boolean[] chk;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new Integer[N];
        chk = new boolean[N];
        candidate = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)  nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums);

        dfs(0, 0);

        System.out.println(sb.toString());
    }

    public static void dfs(int d, int s) {
        if(d == M) {
            for(int i : candidate)
                sb.append(i + " ");
            sb.append("\n");
            return;
        }

        int before = -1;
        for(int i = s; i < N; i++) {
            if(!chk[i] && before != nums[i]) {
                chk[i] = true;
                before = nums[i];
                candidate[d] = nums[i];
                dfs(d + 1, i);
                chk[i] = false;
            }
        }
    }
}
