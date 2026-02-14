/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11725                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11725                          #+#        #+#      #+#    */
/*   Solved: 2026/02/13 20:21:49 by lawpea38      ###          ###   ##.kr    */
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
        n = Integer.parseInt(br.readLine());
        List<Integer>[] list = new ArrayList[n+1];
        int[] ans = new int[n+1];
        for(int i=0; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
            //bfs가 유력 queue에서 꺼내고 그 다음 확인할 경우 그 다음 것들의 배열에 queue.poll한거 저장
            boolean[] visited = new boolean[n+1];
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(1);
            while(!queue.isEmpty()){
                int cur = queue.poll();
                for(int a: list[cur]){
                    if(!visited[a]) {
                        visited[a] = true;
                        ans[a] = cur;
                        queue.add(a);
                    }
                }
            }
        for(int i=2; i<=n; i++){
            sb.append(ans[i]).append('\n');
        }
    System.out.print(sb);
    }
}