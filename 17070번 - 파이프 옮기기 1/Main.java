/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 17070                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/17070                          #+#        #+#      #+#    */
/*   Solved: 2026/02/16 20:44:14 by lawpea38      ###          ###   ##.kr    */
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
        int[][] house = new int[n][n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][][] dp = new int[n][n][3];
        dp[0][1][0]=1;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i==0 && j==1) continue;
                if (house[i][j]!=1) {
                    if(j>=1) {
                        dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
                    }
                    if(i>=1){
                        dp[i][j][1] = dp[i-1][j][1] + dp[i - 1][j][2];
                    }
                }
                if (i >= 1 && j >= 1 && house[i][j]!=1 && house[i-1][j]!=1 && house[i][j-1]!=1) {
                    dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
                }
            }
        }
        System.out.println(dp[n-1][n-1][0]+dp[n-1][n-1][1]+dp[n-1][n-1][2]);

    }
}