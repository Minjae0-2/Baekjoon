/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1697                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1697                           #+#        #+#      #+#    */
/*   Solved: 2026/02/07 16:23:39 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    final static int MAX_VAL= 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if(n==m){
            System.out.println(0);
            return;
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        // 누적 시간 추적하는 배열 필요 + 방문했는지 안했으면(-1)
        int[] time = new int[MAX_VAL+1];
        Arrays.fill(time, -1);

        queue.add(n);
        time[n] = 0;
        while(!queue.isEmpty()){
            int current = queue.poll();

            int[] nextVal = {current-1,current+1, 2*current};
            for(int next: nextVal){
                if(next>MAX_VAL || next<0 || time[next]!=-1) continue;
                time[next] = time[current]+1;

                if(next == m){
                    System.out.println(time[next]);
                    return;
                }

                queue.add(next);
            }

        }
    }
}