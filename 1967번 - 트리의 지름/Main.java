/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1967                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1967                           #+#        #+#      #+#    */
/*   Solved: 2026/02/20 17:02:31 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static List<Node>[] tree;
    static int n;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        if(n==1){
            System.out.println(0);
            return;
        }
        tree = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            tree[p].add(new Node(c,w));
            tree[c].add(new Node(p,w));
        }

        // bfs 2번
        int ans1 = bfs(1);
        int ans2 = bfs(ans1);
        System.out.println(max);

    }
    static class Node{
        int child;
        int weight;
        Node(int child, int weight){
            this.child = child;
            this.weight = weight;
        }
    }
    static int bfs(int start){
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        dist[start] = 0;
        visited[start]=true;
        max = 0;
        int ans = start;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(start,0));
        while(!queue.isEmpty()){
            Node cur= queue.poll();
            int curC = cur.child;
            int curW = cur.weight;
            for(Node next:tree[curC]){
                int nextC = next.child;
                int nextW = next.weight;
                if(visited[nextC]) continue;
                visited[nextC] = true;
                dist[nextC] = nextW+curW;
                queue.add(new Node(nextC,dist[nextC]));
                if(max < dist[nextC]){
                    max = dist[nextC];
                    ans = nextC;
                }
            }
        }
        return ans;
    }
}
