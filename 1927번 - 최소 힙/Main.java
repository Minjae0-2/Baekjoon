/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1927                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1927                           #+#        #+#      #+#    */
/*   Solved: 2026/02/03 15:45:15 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            long a = Long.parseLong(br.readLine());
            long res = 0;
            if(a==0 && queue.isEmpty()){
                sb.append(0).append('\n');
            }else if(a==0){
                res = queue.poll();
                sb.append(res).append('\n');
            }else{
                queue.add(a);
            }
        }
        System.out.println(sb);
    }
}
