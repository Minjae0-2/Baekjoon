/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1932                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1932                           #+#        #+#      #+#    */
/*   Solved: 2026/02/14 00:43:42 by lawpea38      ###          ###   ##.kr    */
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
        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<=i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        for(int i=1; i<n; i++){
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
        }
        for(int i=2; i<n; i++ ){
            for(int j=1; j<i; j++) {
                dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j-1]) +triangle[i][j];
            }
        }
        int max = 0;
        for(int j=0; j<n; j++){
            max = Math.max(dp[n-1][j],max);
        }
        System.out.println(max);
    }
}