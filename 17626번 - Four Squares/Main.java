/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 17626                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/17626                          #+#        #+#      #+#    */
/*   Solved: 2026/01/29 23:50:08 by lawpea38      ###          ###   ##.kr    */
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
        int[] d = new int[n+1];
        d[0] = 0;

        for(int i=1; i<=n; i++){
            d[i]=i; //우선 1+1+1..로 가정
            for(int j=1; i-j*j>=0 && j*j<=n; j++){
                d[i]= Math.min(d[i], d[i-j*j]+1);
            }
        }
        System.out.println(d[n]);
    }
}
