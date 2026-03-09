/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11404                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11404                          #+#        #+#      #+#    */
/*   Solved: 2026/02/26 16:07:22 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static final int INF = 20000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] floid = new int[n+1][n+1];
       for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++) {
                if(i==j) floid[i][j] = 0;
                else floid[i][j] = INF;
            }
       }
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            floid[from][to] = Math.min(floid[from][to],cost);
        }
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++) {
                    floid[i][j] = Math.min(floid[i][k] + floid[k][j], floid[i][j]);
                }
            }
        }
        for(int i=1; i<=n;i++){
            for(int j=1; j<=n;j++) {
                if(floid[i][j]<INF) {
                    sb.append(floid[i][j]).append(' ');
                }else{
                    sb.append(0).append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
        }
    }

