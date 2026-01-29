/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 9375                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/9375                           #+#        #+#      #+#    */
/*   Solved: 2026/01/29 21:48:55 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String,Integer> map = new HashMap<>();

            for(int k=0; k<n; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                // 이름 과감히 버리자 중복 절대 아님
                st.nextToken();
                String s2 = st.nextToken();
                map.put(s2, map.getOrDefault(s2, 0) + 1);
            }
            int res=1;
            // map.values()는 Collection<> 타입
            for(Integer j : map.values()){
                res *= (j+1);
            }
            res -= 1; // 알몸일 경우 제외
            sb.append(res).append('\n');
        }
        System.out.println(sb);
    }
}
