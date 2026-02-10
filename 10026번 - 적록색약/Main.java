/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 10026                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/10026                          #+#        #+#      #+#    */
/*   Solved: 2026/02/10 17:27:36 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static int[] ar = new int[] {1,0,-1,0};
    static int[] ac = new int[] {0,-1,0,1};
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        char[][] normal = new char[n][n];
        for(int i=0; i<n ; i++){
            normal[i] = br.readLine().toCharArray();
        }
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new ArrayDeque<>();
        int normalCount = 0;
        int abnormalCount = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++){
                if(!visited[i][j]) {
                    bfs(visited, i, j, normal, queue);
                    normalCount++;
                }
            }
        }

        visited = new boolean[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++){
               if(normal[i][j] == 'G') normal[i][j] = 'R';
            }
        }


        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++){
                if(!visited[i][j]) {
                    bfs(visited, i, j, normal, queue);
                    abnormalCount++;
                }
            }
        }

        System.out.println(normalCount+" "+ abnormalCount);
    }
    public static void bfs(boolean[][] visited, int i, int j, char[][] normal, Queue<int[]> queue){

        queue.add(new int[] {i,j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cr = cur[0];
            int cc = cur[1];
            for (int k = 0; k < 4; k++) {
                int nr = cr + ar[k];
                int nc = cc + ac[k];
                if (nr >= n || nc >= n || nr < 0 || nc < 0 || visited[nr][nc]) continue;
                if(normal[nr][nc] != normal[cr][cc]) continue;
                visited[nr][nc] = true;
                queue.add(new int[]{nr, nc});
            }
        }
    }
}