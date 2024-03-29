import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] rgb = new int[N][3];
        String[] tmp;
        for(int i=0; i<N; i++) {
            tmp = br.readLine().split(" ");
            rgb[i][0] = Integer.parseInt(tmp[0]);
            rgb[i][1] = Integer.parseInt(tmp[1]);
            rgb[i][2] = Integer.parseInt(tmp[2]);
        }

        // 이전 같은 색 빼고 비교 + 현재 값
        int[][] dp = new int[N][3];
        for(int i=0; i<3; i++) dp[0][i] = rgb[0][i];
        for(int i=1; i<N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + rgb[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + rgb[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + rgb[i][2];
        }
        int result = Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));
        System.out.println(result);
    }
}