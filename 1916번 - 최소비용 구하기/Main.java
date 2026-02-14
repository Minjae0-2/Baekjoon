/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1916                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1916                           #+#        #+#      #+#    */
/*   Solved: 2026/02/14 23:33:50 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import javax.lang.model.type.ArrayType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<int[]>[] list = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[from].add(new int[]{ to, cost});
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int ansFrom = Integer.parseInt(st.nextToken());
        int ansDest = Integer.parseInt(st.nextToken());
        // 다익스트라
        int[] minDist = new int[n+1];
        Arrays.fill(minDist,Integer.MAX_VALUE);
        minDist[ansFrom]=0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        queue.add(new int[]{ansFrom,0});

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int curCity = cur[0];
            int curCost = cur[1];
            if(curCost > minDist[curCity]) continue;
            for(int[] next: list[curCity]){
                int nextTo = next[0];
                int nextCost = next[1];
                int nextCostSum = nextCost+curCost;
                if(nextCostSum>= minDist[nextTo]) continue;
                minDist[nextTo] = nextCostSum;
                queue.add(new int[] {nextTo,nextCostSum});
            }
        }
        System.out.println(minDist[ansDest]);

    }
}