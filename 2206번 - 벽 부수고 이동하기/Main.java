/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2206                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2206                           #+#        #+#      #+#    */
/*   Solved: 2026/03/11 20:03:34 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import javax.lang.model.type.ArrayType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static int[] addR = {0,+1,0,-1};
    static int[] addC = {+1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        Queue<Node> queue = new ArrayDeque<>();
        int[][][] dist = new int[2][n][m];

        queue.add(new Node(0,0,false));
        dist[0][0][0] = 1;
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            int cr = cur.r;
            int cc = cur.c;
            boolean isBroken = cur.isBroken;
            int bIdx = isBroken? 1:0;

            if(cr == n-1 && cc == m-1){
                System.out.println(dist[bIdx][cr][cc]);
                return;
            }
            for(int i=0; i<4; i++){
                int nr = cr+addR[i];
                int nc = cc +addC[i];
                if(nr<0 || nc<0 || nr>=n || nc>=m ) continue;
                if(map[nr][nc]=='1'){
                    if(!isBroken && dist[1][nr][nc] == 0){
                        dist[1][nr][nc] = dist[0][cr][cc] +1;
                        queue.add(new Node(nr,nc,true));
                    }
                }else{
                    if(dist[bIdx][nr][nc] == 0){
                        dist[bIdx][nr][nc] = dist[bIdx][cr][cc]+1;
                        queue.add(new Node(nr,nc,isBroken));
                    }
                }
            }
        }

        System.out.println(-1);

    }
    static class Node{
        int r;
        int c;
        boolean isBroken;
        Node(int r, int c, boolean isBroken){
            this.r = r;
            this.c = c;
            this.isBroken = isBroken;
        }
    }
}

