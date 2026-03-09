/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 12851                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/12851                          #+#        #+#      #+#    */
/*   Solved: 2026/02/27 15:34:09 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static final int INF = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // bfs
        if(n == m){
            sb.append(0).append('\n').append(1);
            System.out.print(sb);
            return;
        }
        // time: n-?초
        int[] time = new int[100001];
        Arrays.fill(time,INF);
        // ways: 경우의 수
        int[] ways = new int[100001];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(n);
        time[n] = 0;
        ways[n] = 1;
        while(!queue.isEmpty()){
            int c = queue.poll();
            int[] nArr = {c-1,c+1,c*2};
            for(int i=0; i<3; i++){
                int next = nArr[i];
                if(next> 100000 || next<0 || time[next]<time[c]+1) continue;
                if(time[next] == INF) {
                    time[next] = time[c]+1;
                    ways[next] = ways[c];
                    queue.add(next);
                }else if(time[next] == time[c]+1){
                    ways[next] += ways[c];
                }

            }
        }
        System.out.println(time[m]+"\n"+ ways[m]);

    }

}
