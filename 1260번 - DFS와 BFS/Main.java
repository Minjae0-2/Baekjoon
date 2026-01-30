/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1260                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1260                           #+#        #+#      #+#    */
/*   Solved: 2026/01/30 20:08:49 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n;
    static int[][] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i=0; i<m; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
            int lineN = Integer.parseInt(st2.nextToken());
            int lineN2 = Integer.parseInt(st2.nextToken());
            arr[lineN][lineN2] = 1;
            arr[lineN2][lineN] = 1;
        }

        // DFS
        visited[v] = true;
        sb.append(v).append(' ');
        for(int i=1; i<=n; i++){
            if(arr[v][i] == 1) {
                dfs(i);
            }
        }
        sb.append('\n');
        visited = new boolean[n+1];
        // BFS
        bfs(v);

        System.out.println(sb);
    }
    public static void dfs(int a){
        if(visited[a]) return;
        sb.append(a).append(' ');
        visited[a] = true;
        for(int i=1; i<=n; i++) {
            if(arr[a][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
    public static void bfs(int a){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        visited[a]= true;

        while(!queue.isEmpty()){
            int k = queue.poll();
            sb.append(k).append(' ');
            for(int i=1; i<=n; i++){
                if(arr[k][i] == 1 && !visited[i]){
                    queue.add(i);
                    visited[i]= true;
                }
            }
        }
    }
}
