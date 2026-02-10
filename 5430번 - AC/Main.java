/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 5430                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/5430                           #+#        #+#      #+#    */
/*   Solved: 2026/02/09 17:17:10 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        // deque로 접근하는게 좋을거 같음
        // flag 변수 둬서  r1개 -> flag 참 -> D나온순간 pollLast 하면됨
        // r2개째 나오면 flag 거짓 -> D나온 순간 poll 하면되고
        // 결과에서 flag 에 따라 나오는것도 가능하고
        for(int i=0; i<t; i++) {
            char[] command = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(),"[],");
            Deque<Integer> deque = new ArrayDeque<>();

            while(st.hasMoreTokens()){
                deque.add(Integer.parseInt(st.nextToken()));
            }

            process(command,deque);
        }
        System.out.print(sb);
    }
    public static void process(char[] commands, Deque<Integer> deque){
        boolean isReverse = false;
        for(char c: commands){
            if(c == 'R'){
                isReverse = !isReverse;
                continue;
            }
            // 명령이 D일시
            if(deque.isEmpty()){
                sb.append("error").append('\n');
                return;
            }
            if(isReverse){
                deque.pollLast();
            }else{
                deque.poll();
            }
        }
        printDeque(deque, isReverse);
    }
    public static void printDeque(Deque<Integer> deque, boolean isReverse){
        sb.append('[');
        while(!deque.isEmpty()){
            if(isReverse){
                sb.append(deque.pollLast());
            }else{
                sb.append(deque.poll());
            }
            if(!deque.isEmpty()){
                sb.append(",");
            }
        }
        sb.append(']').append('\n');
    }
}