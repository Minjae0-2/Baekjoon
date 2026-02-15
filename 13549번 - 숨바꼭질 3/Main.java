/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 13549                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/13549                          #+#        #+#      #+#    */
/*   Solved: 2026/02/15 17:08:53 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static int[] addX = new int[]{-1,+1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();
        int[] time = new int[100001];
        Arrays.fill(time,-1);
        deque.add(n);
        time[n]=0;
        while(!deque.isEmpty()){
            int cur = deque.poll();

            if(cur == m){
                System.out.println(time[m]);
                return;
            }
            int next = cur*2;
            if(next <= 100000 && time[next]==-1){
                time[next] = time[cur];
                deque.addFirst(next);
            }
            int next1;
            for(int i=0; i<2; i++){
                next1 = cur+addX[i];
                if(next1>100000||next1<0|| time[next1]!=-1) continue;
                time[next1] = time[cur] + 1;
                deque.addLast(next1);
            }
        }
    }
}
/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static int n;
    static int k;
    static int[] addN= {-1,+1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 시간 최소 총합 - 예전엔 bfs로 함 가중치있어서 다익스트라로 가자
        // 가중치가 적은것 먼저 처리해야함
        int[] time = new int[100001];
        Arrays.fill(time,Integer.MAX_VALUE);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        queue.add(new int[]{n,0});
        time[n]=0;
        while(!queue.isEmpty()){
            int[] curArr = queue.poll();
            int cur = curArr[0];
            int curT = curArr[1];
            if(time[cur] < curT) continue;
            if(cur==k) {
                System.out.println(curT);
                return;
            }
            int n = cur*2;
            if(n<=100000 && time[n] > curT){
                time[n] = curT;
                queue.add(new int[]{n,time[n]});
            }

            for(int i=0; i<2; i++){
                n = cur + addN[i];
                if(n>100000 ||n<0|| time[n] <= curT) continue;
                time[n] = curT+1;
                queue.add(new int[]{n,time[n]});
            }
        }


    }
}*/