/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 5525                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/5525                           #+#        #+#      #+#    */
/*   Solved: 2026/02/07 20:35:19 by lawpea38      ###          ###   ##.kr    */
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
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int count = 0;
        int answer = 0;
        int len = 2*n+1;
        for(int i=0; i<m - 2; i++){
            if(s.charAt(i) != 'I' || s.charAt(i+1) != 'O' || s.charAt(i+2) != 'I'){
                count = 0;
                continue;
            }
            count++;
            if(count >= n) answer++;
            i++;
        }


        System.out.println(answer);

    }
}