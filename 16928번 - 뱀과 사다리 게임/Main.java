/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 16928                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/16928                          #+#        #+#      #+#    */
/*   Solved: 2026/02/10 19:03:38 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static int[] dice = new int[] {1,2,3,4,5,6};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st2.nextToken());
            int l = Integer.parseInt(st2.nextToken());
            map.put(s,l);
        }
        for(int i=0; i<m ; i++){
            StringTokenizer st3 = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st3.nextToken());
            int l = Integer.parseInt(st3.nextToken());
            map.put(s,l);
        }
        // bfs + 해당 snake 또는 ladder 도달시 이동
        // 처음 100 나올시 return + 방문 기록 필요함 - count 추적도 필요함
        Queue<Integer> queue = new ArrayDeque<>();
        int[] count = new int[101];
        boolean[] visited = new boolean[101];
        queue.add(1);

        while (!queue.isEmpty()){
            int cur = queue.poll();
            for(int i=0; i<6; i++){
                int next = cur+dice[i];

                if(next>100) continue;
                if(map.containsKey(next)){
                    next = map.get(next);
                }

                if(visited[next]) continue;

                visited[next] = true;
                count[next] = count[cur]+1;

                if(next == 100){
                    System.out.println(count[next]);
                    return;
                }

                queue.add(next);

            }
        }
    }
}