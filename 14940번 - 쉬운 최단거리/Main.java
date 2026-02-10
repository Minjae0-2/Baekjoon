/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 14940                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/14940                          #+#        #+#      #+#    */
/*   Solved: 2026/02/08 01:19:08 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static final int[] addr = {+1,0,-1,0};
    static final int[] addc = {0,-1,0,+1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int sr =0;
        int sc =0;

        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(str[j]);
                if(arr[i][j] == 2){
                    sr = i;
                    sc = j;
                }
            }
        }

        // dfs
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] dist = new int[n][m];
        for(int i=0; i<n; i++){
           for(int j=0; j<m; j++){
               if(arr[i][j] == 0){
                   dist[i][j]=0;
               }else{
                   dist[i][j] = -1;
               }
           }
        }
        queue.add(new int[]{sr,sc});
        dist[sr][sc] = 0;

        while(!queue.isEmpty()){
            int[] ca = queue.poll();
            int cr = ca[0];
            int cc = ca[1];
            for (int i=0; i<4; i++){
                int nr = cr+addr[i];
                int nc = cc+addc[i];
                if(nr<0 || nr>=n || nc<0 ||nc>=m ||arr[nr][nc]==0||dist[nr][nc]!=-1) continue;
                dist[nr][nc] = dist[cr][cc]+1;
                queue.add(new int[]{nr,nc});
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0;j<m; j++){
                sb.append(dist[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}