/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 14626                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/14626                          #+#        #+#      #+#    */
/*   Solved: 2025/07/29 15:57:02 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int starPosition = 0;
        int sum = 0;
        for(int i=0; i<13; i++){
            char part = str.charAt(i);
            if(part == '*'){
                starPosition=i;
                continue;
            }
                if ((i + 1) % 2 != 0) {
                    sum += part - '0';
                } else {
                    sum += 3 * (part - '0');
                }
        }
        int res=0;
        int testSum=sum;
        for(int j=0; j<10;j++){
            if((starPosition+1)%2!=0){
                testSum+=j;
            }else{
                testSum+=3*j;
            }
            if(testSum%10==0){
                res=j;
                break;
            }
            testSum=sum;
        }
        System.out.println(res);
        br.close();

    }
}
