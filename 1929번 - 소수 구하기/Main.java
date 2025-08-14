/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1929                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1929                           #+#        #+#      #+#    */
/*   Solved: 2025/08/14 18:35:15 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] str = br.readLine().split(" ");
        int m = Integer.parseInt(str[0]);
        int n = Integer.parseInt(str[1]);
        boolean[] isNotPrime = new boolean[n+1];
        isNotPrime[0]=true;
        isNotPrime[1]=true;
        for(int i=2; i*i<=n; i++){
            if(!isNotPrime[i]){
                for(int j=i*i; j<=n; j+=i) {
                    isNotPrime[j]=true;
                }
            }
        }
        for(int i=m; i<=n; i++){
            if(!isNotPrime[i]){
            sb.append(i).append('\n');
            }
        }
        System.out.print(sb);
        br.close();
    }
}

