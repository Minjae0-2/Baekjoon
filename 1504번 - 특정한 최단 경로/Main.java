/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1504                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1504                           #+#        #+#      #+#    */
/*   Solved: 2026/02/20 14:29:03 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static int n;
    static int mid1;
    static int mid2;
    static List<Node>[] graph;
    static int INF = 200000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());
            int cost = Integer.parseInt(st2.nextToken());
            graph[start].add(new Node(end,cost));
            graph[end].add(new Node(start,cost));
        }

        StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
        mid1 = Integer.parseInt(st3.nextToken());
        mid2 = Integer.parseInt(st3.nextToken());

        // dikstra - priority queue로
        // 1-mid1-mid2-n
        // 1-mid2-mid1-n
        int d1= dikstra(1,mid1);
        int d2= dikstra(mid1,mid2);
        int d3= dikstra(mid2,n);
        int r1 = dikstra(1,mid2);
        int r3 = dikstra(mid1,n);

        int min= Math.min(d1+d2+d3, r1+d2+r3);
        System.out.println(min>=INF? -1:min);
    }
    static class Node{
        int next;
        int cost;
        Node(int next,int cost){
            this.next = next;
            this.cost = cost;
        }
    }
    static int dikstra(int start, int end){
        int[] dist = new int[n+1];
        Arrays.fill(dist,INF);
        dist[start]=0;
        PriorityQueue<Node> queue = new PriorityQueue<>((a,b)->a.cost-b.cost);
        queue.add(new Node(start,0));
        while (!queue.isEmpty()){
            Node cur= queue.poll();
            int curNext = cur.next;
            int curCost = cur.cost;
            if(dist[curNext] < curCost) continue;
            for(Node nextNode:graph[curNext]){
                if(dist[nextNode.next] > curCost+nextNode.cost) {
                    dist[nextNode.next]= curCost+nextNode.cost;
                    queue.add(new Node(nextNode.next,curCost+nextNode.cost));
                }
            }
        }
        return dist[end];
    }
}