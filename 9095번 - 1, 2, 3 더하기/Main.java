/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 9095                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/9095                           #+#        #+#      #+#    */
/*   Solved: 2026/01/29 20:28:22 by lawpea38      ###          ###   ##.kr    */
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
        int[] arr = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < t; i++) {
            int n = arr[i];
            int[] d = new int[arr[i]+1];
            if(n>=1) {
                d[1] = 1;
            }
            if(n>=2) {
                d[2] = 2;
            }
            if(n>=3) {
                d[3] = 4;
            }
            for(int j=4; j<= n; j++) {
                d[j] = d[j - 1] + d[j - 2] + d[j - 3];
            }
            sb.append(d[n]).append('\n');
            }
        System.out.println(sb);
    }
}
