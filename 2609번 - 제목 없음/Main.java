/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2609                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2609                           #+#        #+#      #+#    */
/*   Solved: 2025/07/28 16:16:31 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n= Integer.parseInt(str[0]);
        int m= Integer.parseInt(str[1]);
        int minN =gcd(n,m);
        int maxN =lcm(n,m,minN);
        System.out.println(minN);
        System.out.println(maxN);
    }
    public static int gcd(int n, int m){
        int temp=0;
        while(true){
            temp=n;
            if(n%m==0) break;
            n=n%m;
            m=temp;
        }
        return m;
    }
    public static int lcm(int n, int m, int minN){
        return (n/minN)*m;
    }
}
