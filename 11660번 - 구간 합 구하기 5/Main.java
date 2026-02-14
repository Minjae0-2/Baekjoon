/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11660                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11660                          #+#        #+#      #+#    */
/*   Solved: 2026/02/14 21:49:01 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] num = new int[n+1][n+1];
        int[][] toSum = new int[m][4];
        for(int i=1; i<=n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            for (int j=1; j<=n; j++) {
                num[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        for(int i=0; i<m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<4; j++) {
                toSum[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        // DP
        int[][] dp = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1] + num[i][j];
            }
        }
        for(int i=0; i<m; i++){
            int x1 = toSum[i][0];
            int y1 = toSum[i][1];
            int x2 = toSum[i][2];
            int y2 = toSum[i][3];
            int res;
            res = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1-1][y1-1];

            sb.append(res).append('\n');
        }
        System.out.print(sb);

    }
}