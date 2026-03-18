/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11779                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11779                          #+#        #+#      #+#    */
/*   Solved: 2026/03/18 11:46:30 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import javax.lang.model.type.ArrayType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static int n;
    static int m;
    static int start;
    static int dest;
    static List<Node>[] bus;
    static final int INF = 200_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        bus = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            bus[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            bus[u].add(new Node(v,w));
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st2.nextToken());
        dest = Integer.parseInt(st2.nextToken());
        dijkstra();
    }
    static class Node{
        int next;
        int cost;
        Node(int next, int cost){
            this.next = next;
            this.cost = cost;
        }
    }
    static void dijkstra(){
        int[] dist = new int[n+1];
        int[] parent = new int[n+1];
        Arrays.fill(dist, INF);
        for(int i=1; i<=n; i++){
            parent[i]=i;
        }
        PriorityQueue<Node> queue = new PriorityQueue<>((a,b)->a.cost - b.cost);
        queue.add(new Node(start,0));
        dist[start] = 0;
        while(!queue.isEmpty()){
            Node c = queue.poll();
            int cn = c.next;
            int cc = c.cost;
            if(dist[cn] < cc) continue;
            for(Node next:bus[cn]){
                int nn = next.next;
                int nc = next.cost;
                if(dist[nn]<=cc+nc) continue;
                dist[nn] = cc+nc;
                parent[nn] = cn;
                queue.add(new Node(nn,dist[nn]));
            }
        }
        // 1. 최소비용
        sb.append(dist[dest]).append('\n');
        //2. 도시 개수 + 도시 순서
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(dest);
        int val = dest;
        while(val != start){
            val = parent[val];
            deque.addFirst(val);
        }
        sb.append(deque.size()).append('\n');
        while(!deque.isEmpty()){
            sb.append(deque.poll()).append(' ');
        }

        System.out.println(sb);
    }
}

