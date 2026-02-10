/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1389                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1389                           #+#        #+#      #+#    */
/*   Solved: 2026/02/07 15:23:03 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer>[] person = new ArrayList[n+1];

        for(int i=0; i<=n; i++){
            person[i] = new ArrayList<>();
        }

        for(int i =0; i<m ;i++){
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int p1 = Integer.parseInt(st2.nextToken());
            int p2 = Integer.parseInt(st2.nextToken());
            person[p1].add(p2);
            person[p2].add(p1);
        }
        // BFS
        Queue<Integer> queue = new ArrayDeque<>();
        int[] dist;
        int targetNumValue = 0;
        int targetNum = 0;
        int minPeople = Integer.MAX_VALUE;
        int target = 0;
        for(int i =1; i<=n; i++) {
            dist = new int[n+1];
            Arrays.fill(dist,-1);
            queue.add(i);
            dist[i]= 0;
            targetNumValue =0;
            while (!queue.isEmpty()) {
                target = queue.poll();
                for(int np :person[target]){
                    if(dist[np] != -1) continue;
                    dist[np]= dist[target]+1;
                    targetNumValue += dist[np];
                    queue.add(np);
                }
            }
            if(minPeople > targetNumValue){
                minPeople = targetNumValue;
                targetNum = i;
            }
        }
            System.out.println(targetNum);
    }
}