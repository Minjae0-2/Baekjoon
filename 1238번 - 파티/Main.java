/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1238                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1238                           #+#        #+#      #+#    */
/*   Solved: 2026/03/11 14:06:48 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import javax.lang.model.type.ArrayType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static int n,m,x;
    static List<Node>[] graphList;
    static List<Node>[] reverseGraphList;
    static final int INF = 100000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        graphList = new ArrayList[n+1];
        reverseGraphList = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graphList[i] = new ArrayList<>();
            reverseGraphList[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());
            int w = Integer.parseInt(st2.nextToken());
            graphList[u].add(new Node(v,w));
            reverseGraphList[v].add(new Node(u,w));
        }
        int[] dist1 = dijkstra(true);
        int[] dist2 = dijkstra(false);
        int max = 0;
        for(int i=1; i<=n; i++){
            if(dist1[i] >= INF || dist2[i]>=INF) continue;
            max = Math.max(max, dist1[i]+ dist2[i]);
        }
        System.out.println(max);
    }
    static class Node{
        int next;
        int weight;
        Node(int next, int weight){
            this.next = next;
            this.weight = weight;
        }
    }
    static int[] dijkstra(boolean isReversed){
        List<Node>[] graph;
        if(isReversed){
            graph = reverseGraphList;
        }else{
            graph = graphList;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> a.weight - b.weight);
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        pq.add(new Node(x,0));
        dist[x] = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curN = cur.next;
            int curW = cur.weight;
            if(dist[curN] < curW) continue;
            for(Node ne :graph[curN]){
                int neN = ne.next;
                int neW = ne.weight;
                if(dist[neN] <= neW+curW) continue;
                dist[neN] = neW + curW;
                pq.add(new Node(neN,dist[neN]));
            }
        }
        return dist;
    }
}

