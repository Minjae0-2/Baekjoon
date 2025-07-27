/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2292                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2292                           #+#        #+#      #+#    */
/*   Solved: 2025/07/27 20:50:43 by lawpea38      ###          ###   ##.kr    */
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
        if (n == 1) {
            System.out.println(1);
        }else{
            System.out.println(findRoom(n));
        }
    }


    public static int findRoom(int n){
        int sum = 1;
        int count = 0;
        for(int i=1;;i++){
            sum+=6*i;
            if(sum>=n){
                count = i+1;
                break;
            }
        }
        return count;
    }
}
