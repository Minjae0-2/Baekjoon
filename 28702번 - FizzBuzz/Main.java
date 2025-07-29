/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 28702                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/28702                          #+#        #+#      #+#    */
/*   Solved: 2025/07/29 16:36:28 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count=0;
        int num=0;
        for(int i=0; i<3; i++){
            try{
                count++;
                num = Integer.parseInt(br.readLine());
                break;
            }catch(NumberFormatException e){
            }
            }
        /* 아래 코드도 가능
        if (!str.contains("zz")) {
				num = Integer.parseInt(str) + i;
				break;
			}
		*/
        num+=(4-count);
        if(num%15==0){
            System.out.println("FizzBuzz");
        }else if(num%5==0){
            System.out.println("Buzz");
        }else if(num%3==0){
            System.out.println("Fizz");
        }else{
            System.out.println(num);
        }
        br.close();

    }
}
