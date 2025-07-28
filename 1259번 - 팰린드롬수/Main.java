/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1259                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1259                           #+#        #+#      #+#    */
/*   Solved: 2025/07/28 11:24:39 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        while(true){
            String n = br.readLine();
            if(n.equals("0")){
                break;
            }
            int len = n.length();
            boolean isPen = true;

            if(len==1){
                isPen= true;
            }else {
                for (int i = 0; i < len / 2; i++) {
                    if (n.charAt(i) != n.charAt(len - i - 1)) {
                        isPen = false;
                        break;
                    }
                }
            }

            if(isPen){
                sb.append("yes").append('\n');
            }else{
                sb.append("no").append('\n');
            }
        }
            System.out.println(sb);
    }
}
