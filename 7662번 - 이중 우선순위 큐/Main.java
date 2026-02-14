/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 7662                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/7662                           #+#        #+#      #+#    */
/*   Solved: 2026/02/10 20:05:47 by lawpea38      ###          ###   ##.kr    */
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
        for(int l=0; l<t; l++) {
            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer,Integer> treeMap = new TreeMap<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                char inst = st.nextToken().charAt(0);
                int q1 = Integer.parseInt(st.nextToken());
                if (inst == 'I') {
                    treeMap.put(q1, treeMap.getOrDefault(q1,0)+1);
                }else{
                    if(!treeMap.isEmpty()){
                       int key = (q1 == 1)? treeMap.lastKey() : treeMap.firstKey();
                       int val = treeMap.get(key);
                       if(val == 1) treeMap.remove(key);
                       else treeMap.put(key, val-1);
                    }
                }
            }
            if(!treeMap.isEmpty()) {
                int max = treeMap.lastKey();
                int min = treeMap.firstKey();
                sb.append(max).append(' ').append(min).append('\n');
            }else{
                sb.append("EMPTY").append('\n');
            }
        }
        System.out.print(sb);
    }
}