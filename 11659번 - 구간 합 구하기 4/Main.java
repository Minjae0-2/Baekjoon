/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11659                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11659                          #+#        #+#      #+#    */
/*   Solved: 2026/01/29 22:07:34 by lawpea38      ###          ###   ##.kr    */
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
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] sumArr = new int[n+1];
        sumArr[0]=0;

        StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
        for(int i=1; i<=n; i++){
            sumArr[i] = Integer.parseInt(st2.nextToken()) + sumArr[i-1];
        }

        for(int i=0; i<m; i++){
            StringTokenizer st3 = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st3.nextToken());
            int end = Integer.parseInt(st3.nextToken());

            int sum = sumArr[end]- sumArr[start-1];

            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }
}
