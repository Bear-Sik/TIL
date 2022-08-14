package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Integer[] indv_arr = new Integer[m];
        Integer[] pack_arr = new Integer[m];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            pack_arr[i] = Integer.parseInt(st.nextToken());
            indv_arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(indv_arr);
        Arrays.sort(pack_arr);

        int answer = 0;
        int tmp = 0;
        int tmp_n = n;


        if(n >= 6)  {
            tmp += (pack_arr[0] * (tmp_n / 6));
            tmp_n = tmp_n - 6 * (tmp_n / 6);
        }

        if(indv_arr[0] * tmp_n > pack_arr[0]) tmp += pack_arr[0];
        else tmp += indv_arr[0] * tmp_n;


        answer = tmp > indv_arr[0] * n ? indv_arr[0] * n : tmp;

        System.out.println(answer);
    }
}
