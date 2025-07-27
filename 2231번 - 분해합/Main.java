/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2231                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2231                           #+#        #+#      #+#    */
/*   Solved: 2025/07/27 17:31:01 by lawpea38      ###          ###   ##.kr    */
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
        int sum;
        boolean find=false;
        for(int i=1; i<n; i++){
            int num=i;
            sum=0;
            sum+=i;
            while(true){
                sum+=num%10;
                num/=10;
                if(num==0) break;
            }
            if(sum==n){
                System.out.println(i);
                find=true;
                break;
            }
        }
        if(!find) {
            System.out.println(0);
        }
    }
}
