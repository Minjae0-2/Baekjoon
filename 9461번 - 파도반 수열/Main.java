/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 9461                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/9461                           #+#        #+#      #+#    */
/*   Solved: 2026/01/29 21:48:33 by lawpea38      ###          ###   ##.kr    */
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
        long[] d = new long[101];
        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            // 7이 어케 생겼냐 그전 5랑 5번재 전 2
            // 9는 그전 7과 5번째 전 2
            // 12  는 9랑 5번째 전 3
            if(n>=1) d[1] = 1;
            if(n>=2) d[2] = 1;
            if(n>=3) d[3] = 1;
            if(n>=4) d[4] = 2;
            if(n>=5) d[5] = 2;
            for(int j=6; j<=n; j++){
                d[j] = d[j-5]+d[j-1];
            }
            sb.append(d[n]).append('\n');
        }
        System.out.println(sb);
    }
}
