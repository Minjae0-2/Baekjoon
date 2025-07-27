/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1978                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1978                           #+#        #+#      #+#    */
/*   Solved: 2025/07/27 15:36:51 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int count = 0;
        for(int i=0; i<n; i++ ){
            int temp = 0;
            temp = Integer.parseInt(str[i]);
            if(isPrime(temp)){
                count++;
            }
        }
        System.out.println(count);

    }
    public static boolean isPrime(int n){
        if(n == 1) return false;
        for(int j=2; j*j<=n; j++){
            if (n % j == 0) {
                return false;
            }
        }
        return true;
    }

    }

