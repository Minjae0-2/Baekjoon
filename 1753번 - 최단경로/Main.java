/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1753                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1753                           #+#        #+#      #+#    */
/*   Solved: 2026/02/20 15:40:15 by lawpea38      ###          ###   ##.kr    */
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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        List<Node>[] graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());
            int w = Integer.parseInt(st2.nextToken());
            graph[u].add(new Node(v,w));
        }
        //dijkstra로
        int[] dist = new int[n+1];
        Arrays.fill(dist,INF);
        PriorityQueue<Node> queue = new PriorityQueue<>((a,b)-> a.weight-b.weight);
        queue.add(new Node(start,0));
        dist[start] = 0;
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            int curE = cur.end;
            int curW = cur.weight;
            if(curW > dist[curE]) continue;
            for(Node next:graph[curE]){
                int nextE = next.end;
                int nextW = next.weight;
                if(dist[nextE]>curW+nextW){
                    dist[nextE] = curW+nextW;
                    queue.add(new Node(nextE,dist[nextE]));
                }
            }
        }
        for(int i=1;i<=n;i++){
            sb.append(dist[i]>=INF?"INF":dist[i]).append('\n');
        }
        System.out.print(sb);

    }
    static class Node{
        int end;
        int weight;
        Node(int end,int weight){
            this.end = end;
            this.weight = weight;
        }
    }
}