/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 8958                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/8958                           #+#        #+#      #+#    */
/*   Solved: 2025/07/25 20:19:28 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(br.readLine());
        for(int i=0; i<a; i++){
            int score=0;
            String str = br.readLine();
            int add=0;
            for(int j=0; j< str.length(); j++){
                if(str.charAt(j) == 'O'){
                    add++;
                    score=score+add;
                }else{
                    add=0;
                }
            }
            sb.append(score).append('\n');
        }
        System.out.println(sb);
        }
    }
