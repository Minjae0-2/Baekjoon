/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 9019                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/9019                           #+#        #+#      #+#    */
/*   Solved: 2026/02/10 22:26:21 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.cert.PolicyQualifierInfo;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int k=0; k<t; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int input = Integer.parseInt(st.nextToken());
            ans = Integer.parseInt(st.nextToken());

            //bfs
            Queue<Integer> queue = new ArrayDeque<>();
            boolean[] visited= new boolean[10000];
            int[] preNum = new int[10000];
            char[] how = new char[10000];
            queue.add(input);
            visited[input] = true;

            while(!queue.isEmpty()){
                int cur = queue.poll();
                if(cur == ans) break;

                int d = (cur *2) % 10000;
                if(!visited[d]){
                    update(queue,visited,preNum,how,cur,d,'D');
                }
                int s = (cur==0)? 9999 : cur-1;
                if(!visited[s]){
                    update(queue,visited,preNum,how,cur,s,'S');
                }
                int l = (cur %1000)*10 +cur /1000;
                if(!visited[l]){
                    update(queue,visited,preNum,how,cur,l,'L');
                }
                int r = (cur%10)*1000 + cur /10;
                if(!visited[r]){
                    update(queue,visited,preNum,how,cur,r,'R');
                }
            }
            StringBuilder sb2= new StringBuilder();
            while(input != ans){
                sb2.append(how[ans]);
                ans = preNum[ans];
            }
            sb.append(sb2.reverse()).append('\n');
        }
        System.out.println(sb);
    }
    public static void update(Queue<Integer> queue,boolean[] visited, int[] preNum, char[] how, int cur, int next, char command ){
        visited[next]= true;
        preNum[next] = cur;
        how[next] = command;
        queue.add(next);
    }
}