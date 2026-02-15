/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 12865                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/12865                          #+#        #+#      #+#    */
/*   Solved: 2026/02/15 15:48:37 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import javax.lang.model.type.ArrayType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static int n;
    static int k;
    static int[][] item;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        item = new int[n][2];
        int[] dp = new int[k+1];
        for(int i=0; i<n; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
            int w = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());
            for(int j=k; j>=w; j--){
                dp[j] = Math.max(dp[j-w]+v ,dp[j]);
            }
        }
        System.out.println(dp[k]);

    }

}