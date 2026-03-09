/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 9251                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/9251                           #+#        #+#      #+#    */
/*   Solved: 2026/02/22 15:18:19 by lawpea38      ###          ###   ##.kr    */
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
        char[] arr1 = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();
        int n = arr1.length;
        int m = arr2.length;
        int[][] dp = new int[n+1][m+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++) {
                if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
