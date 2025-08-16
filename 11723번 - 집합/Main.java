/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11723                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11723                          #+#        #+#      #+#    */
/*   Solved: 2025/08/16 15:45:59 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int bit = 0;
        for(int i=0; i<n; i++) {
            String[] str = br.readLine().split(" ");
            String instruction = str[0];
            if(instruction.equals("all")){
                bit = 0xFFFFF;
                continue;
            }
            else if(instruction.equals("empty")){
                bit = 0;
                continue;
            }
            int operand = Integer.parseInt(str[1]);
            if(instruction.equals("add")){
                bit = bit | 1 << operand-1;
            }
            else if(instruction.equals("remove")){
                bit = bit & ~(1 << operand-1);
            }
            else if(instruction.equals("check")){
                if( 0 == (bit & (1 << operand-1))){
                    sb.append(0).append('\n');
                }else{
                    sb.append(1).append('\n');
                }
            }
            else if(instruction.equals("toggle")){
               bit ^= 1 << operand-1;
            }
        }
        System.out.print(sb);
        br.close();
    }
}

