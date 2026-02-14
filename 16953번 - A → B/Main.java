/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 16953                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/16953                          #+#        #+#      #+#    */
/*   Solved: 2026/02/13 22:02:34 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 1이 붙으면 홀수 + 짝수(*2) 는 독립적 거꾸로 생각해봐야함
        // 번갈아 나오는듯
        int count = 1;
        while(m > n){
            if(m%2 == 0){
                m/=2;
            }else if(m % 10 == 1){
                m /= 10;
            }else{
                break;
            }
            count++;
        }
        if(m == n)System.out.println(count);
        else System.out.println(-1);

    }
}