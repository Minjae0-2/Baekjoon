/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11279                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11279                          #+#        #+#      #+#    */
/*   Solved: 2026/02/03 21:08:02 by lawpea38      ###          ###   ##.kr    */
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
        PriorityQueue<Long> queue = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<n ;i++){
            long m = Long.parseLong(br.readLine());
            if(m == 0 && queue.isEmpty()){
                sb.append(0).append('\n');
            }else if(m == 0){
                sb.append(queue.poll()).append('\n');
            }else{
                queue.add(m);
            }
        }
        System.out.print(sb);


    }
}