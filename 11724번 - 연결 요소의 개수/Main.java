/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11724                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11724                          #+#        #+#      #+#    */
/*   Solved: 2026/02/03 22:42:56 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static boolean[] visited;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        int start = 0;
        for(int i=0; i<m; i++){
            StringTokenizer st2 =new StringTokenizer(br.readLine()," ");
            start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());
            list[start].add(end);
            list[end].add(start);
        }
        // dfs로 접근
        int count = 0;
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++) {
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
    public static void dfs(int node){
        visited[node] = true;
        for(int neighbor: list[node]){
            if(!visited[neighbor]){
                dfs(neighbor);
            }
        }
    }
}