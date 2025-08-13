/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2839                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2839                           #+#        #+#      #+#    */
/*   Solved: 2025/08/13 19:14:32 by lawpea38      ###          ###   ##.kr    */
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
        boolean isChecked=false;
        for(int i=n/5; i>=0; i--){
            if((n-i*5)%3 == 0){
                int count3kg = (n-i*5)/3;
                System.out.print(i+count3kg);
                isChecked=true;
                break;
            }
        }
        if(!isChecked) {
            System.out.print(-1);
        }

        br.close();
    }
}

