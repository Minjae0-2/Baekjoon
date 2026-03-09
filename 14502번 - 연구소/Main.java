/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 14502                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/14502                          #+#        #+#      #+#    */
/*   Solved: 2026/03/02 21:56:52 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static final long X = 1000000007;
    static int[][] virus;
    static int n;
    static int m;
    static int[] addR = {0,+1,0,-1};
    static int[] addC = {+1,0,-1,0};
    static int max;
    static List<Node> initialViruses;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        virus = new int[n][m];
        initialViruses = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                virus[i][j] = Integer.parseInt(st2.nextToken());
                if(virus[i][j] == 2){
                    initialViruses.add(new Node(i,j));
                }
            }
        }
        // 벽 3개를 우선적으로 세우고-- backtracking(-원본배열에 간섭)
        // 배열이 2개 있어야함 - 복사본
        // 2있는 모든 곳을 bfs 탐색
        // 그 후 복사본 배열에서 0 몇개인지 탐색
        buildWall(0,0);
        System.out.println(max);
    }
    public static void buildWall(int start, int count){
        if(count==3){
            int res = bfs();
            max = Math.max(res,max);
            return;
        }
        for(int i=start; i<n*m;i++){
            int r = i/m;
            int c = i%m;
            if(virus[r][c]==0) {
                virus[r][c]=1;
                buildWall(i+1,count+1);
                virus[r][c]=0;
            }
        }
    }
    public static int bfs(){
        int[][] map= new int[n][m];
        for(int i=0;i<n;i++) {
            System.arraycopy(virus[i],0,map[i],0,m);
        }
        Queue<Node> queue = new ArrayDeque<>(initialViruses);

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            int cr = cur.row;
            int cc = cur.col;
            for(int i=0; i<4; i++){
                int nr = cr+addR[i];
                int nc = cc+addC[i];
                if(nr<0 || nr>=n || nc<0 || nc>=m || map[nr][nc]!=0) continue;
                map[nr][nc]=2;
                queue.add(new Node(nr,nc));
            }
        }
        int res = printSafety(map);
        return res;
    }
    static int printSafety(int[][] map){
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                if(map[i][j]==0){
                    count++;
                }
            }
        }
        return count;
    }
    static class Node{
        int row;
        int col;
        Node(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}

