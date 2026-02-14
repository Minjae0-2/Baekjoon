/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 9465                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/9465                           #+#        #+#      #+#    */
/*   Solved: 2026/02/14 19:57:47 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int l = 0; l < t; l++) {
        n = Integer.parseInt(br.readLine());
        int[][] sticker = new int[2][n];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    sticker[i][j] =Integer.parseInt(st.nextToken());
                }
            }
            int[][] d = new int[2][n];
            d[0][0] = sticker[0][0];
            d[1][0] = sticker[1][0];
            if(n>1) {
                d[0][1] = d[1][0] + sticker[0][1];
                d[1][1] = d[0][0] + sticker[1][1];
            }
            for(int i=2; i<n; i++){
                d[0][i] = Math.max(d[1][i-1],d[1][i-2]) +sticker[0][i];
                d[1][i] = Math.max(d[0][i-1],d[0][i-2]) +sticker[1][i];
            }

            sb.append(Math.max(d[0][n-1],d[1][n-1])).append('\n');
        }
        System.out.print(sb);
    }
}