/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11286                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11286                          #+#        #+#      #+#    */
/*   Solved: 2026/02/07 20:53:25 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> queue = new PriorityQueue<>((p,q) -> {
            long p1 = Math.abs(p);
            long q1 = Math.abs(q);
            if(p1 != q1) return Long.compare(p1,q1);
            return Long.compare(p,q);
        });
        for(int i =0; i<n; i++){
            long val = Long.parseLong(br.readLine());
            if(val == 0 && !queue.isEmpty()){
                long ans = queue.poll();
                sb.append(ans).append('\n');
            }else if (val == 0 && queue.isEmpty()){
                sb.append(0).append('\n');
            }else{
                queue.add(val);
            }
        }
        System.out.println(sb);
    }
}