/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2577                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2577                           #+#        #+#      #+#    */
/*   Solved: 2025/07/25 22:28:02 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        String res = String.valueOf(a*b*c);
        int[] plus = new int[10];
        for(int i=0; i<res.length(); i++){
                int digit = res.charAt(i)- '0';
                plus[digit]++;
            }
        for(int k=0; k<10; k++){
            sb.append(plus[k]).append('\n');
        }
        System.out.println(sb);
    }
    }
