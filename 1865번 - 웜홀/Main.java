/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1865                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1865                           #+#        #+#      #+#    */
/*   Solved: 2026/03/11 18:16:57 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import javax.lang.model.type.ArrayType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static int t,n,m,w;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        t = Integer.parseInt(br.readLine());

        for(int o=0; o<t; o++){
            List<Line> graphList = new ArrayList<>() ;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            for(int i=0; i<m; i++){
                StringTokenizer st1 = new StringTokenizer(br.readLine(), " " );
                int u = Integer.parseInt(st1.nextToken());
                int v = Integer.parseInt(st1.nextToken());
                int w = Integer.parseInt(st1.nextToken());
                graphList.add(new Line(u,v,w));
                graphList.add(new Line(v,u,w));
            }
            for(int i=0; i<w; i++){
                StringTokenizer st1 = new StringTokenizer(br.readLine(), " " );
                int u = Integer.parseInt(st1.nextToken());
                int v = Integer.parseInt(st1.nextToken());
                int w = Integer.parseInt(st1.nextToken());
                graphList.add(new Line(u,v,-w));
            }
            bellmanFord(graphList);
        }
    }
    static class Line{
        int from;
        int to;
        int weight;
        Line(int from , int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    static void bellmanFord(List<Line> graphList){
        int[] dist = new int[n+1];
        // 0으로 초기화 - 가상 노드 0 생성후 모든 노드에 0 화살표 꽂은 효과 - 모든게 출발점
        Arrays.fill(dist,0);
        for(int i=1; i<=n; i++){
            for(Line cur:graphList){
                int curF = cur.from;
                int curT = cur.to;
                int curW = cur.weight;
                if(dist[curT] <= dist[curF]+curW) continue;
                dist[curT] = dist[curF] + curW;
                if(i == n){
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");

    }
}

