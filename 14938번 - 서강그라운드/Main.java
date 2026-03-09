/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 14938                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/14938                          #+#        #+#      #+#    */
/*   Solved: 2026/03/06 20:10:17 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static int n;
    static int m;
    static int r;
    static int[] item;
    static List<Node>[] list;
    static final int INF = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        item = new int[n+1];
        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=n; i++) {
            item[i]= Integer.parseInt(st2.nextToken());
        }
        for(int i=0; i<r; i++){
            StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st3.nextToken());
            int b = Integer.parseInt(st3.nextToken());
            int len = Integer.parseInt(st3.nextToken());
            list[a].add(new Node(b,len));
            list[b].add(new Node(a,len));
        }
        int max = 0;
        for(int i=1; i<=n; i++){
            max = Math.max(getMaxItems(i),max);
        }
        System.out.println(max);
    }
    static class Node{
        int node;
        int cost;
        Node(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
    static int getMaxItems(int start){
        int[] dist = new int[n+1];
        Arrays.fill(dist,INF);
        Queue<Node> queue = new PriorityQueue<>((a,b)->{return a.cost-b.cost;});
        queue.add(new Node(start,0));
        dist[start] = 0;
        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            int cn = curNode.node;
            int cc = curNode.cost;
            if(cc > dist[cn]) continue;
            for(Node nextNode : list[cn]){
                int nn = nextNode.node;
                int nc = nextNode.cost;
                if(cc+nc>m || dist[nn] <= nc+cc) continue;
                nc = cc+nc;
                dist[nn] = nc;
                queue.add(new Node(nn,nc));
            }
        }
        int  max = 0;
        for(int i=1; i<=n; i++){
            if(dist[i]<INF){
                max += item[i];
            }
        }
        return max;
    }
}

