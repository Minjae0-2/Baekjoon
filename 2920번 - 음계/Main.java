/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2920                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2920                           #+#        #+#      #+#    */
/*   Solved: 2025/07/25 21:57:09 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] str = br.readLine().split(" ");
        boolean reverse = true;
        boolean origin = true;
        for(int i=0; i<8; i++){
            int res = Integer.parseInt(str[i]);
            if(res == i+1 && origin){
                reverse=false;
            }else if(res == 8-i && reverse){
                origin=false;
            }else{
                reverse=false;
                origin=false;
                break;
            }
        }
        if(origin){
            System.out.println("ascending");
        }else if(reverse){
            System.out.println("descending");
        }else{
            System.out.println("mixed");
        }

    }
    }
