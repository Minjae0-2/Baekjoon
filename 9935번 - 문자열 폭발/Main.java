/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 9935                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/9935                           #+#        #+#      #+#    */
/*   Solved: 2026/02/23 17:08:04 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String str = br.readLine();
        String explode = br.readLine();
        int exLen = explode.length();
        for(int i=0; i<str.length(); i++) {
            sb.append(str.charAt(i));
            if(sb.charAt(sb.length()-1) == explode.charAt(exLen-1) && sb.length() >= exLen){
                boolean isSame = true;
                for(int j=0; j<exLen; j++){
                    if(sb.charAt(sb.length()-exLen+j) != explode.charAt(j)){
                        isSame = false;
                        break;
                    }
                }
                if(isSame){
                    sb.delete(sb.length()-exLen,sb.length());
                }
            }
        }
        if (sb.length() == 0){
            System.out.println("FRULA");
        }else{
            System.out.println(sb);
        }
    }
}
