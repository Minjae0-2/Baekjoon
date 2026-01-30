/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11726                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11726                          #+#        #+#      #+#    */
/*   Solved: 2026/01/29 22:52:40 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] d = new long[n+1];
        d[1]=1;
        if(n>=2) d[2]=2;
        // n=5일때 직전 4에서 1개블록 또는 3인 상태에서 2개블록
        for(int i=3; i<=n; i++){
            d[i] = (d[i-1] + d[i-2])% 10007; //더할때마다 나누자
        }
        System.out.println(d[n]);
    }
}
