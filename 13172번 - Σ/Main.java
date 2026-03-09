/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 13172                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/13172                          #+#        #+#      #+#    */
/*   Solved: 2026/03/02 15:52:32 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static final long X = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());

        long sum = 0;

        for(int i=0;i<m;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            long res = divide(s,n,X-2);
            sum += (s*res)%X;
        }
        // sigma (Si/Ni) = a/b -> a*b^-1(mod 1000000007)
        // b^-1를 어케 구함? = b^(1000000007-2)mod1000000007
        // 각자 다 구하고 마지막에 더하면 됨
        // Si/Ni = a/b -> a*(b^(X-2)mod X)(mod X)
        System.out.println(sum%X);
    }
    public static long divide(int a, int b, long x){
        //기저조건은 a*(b)modX 즉 x가 1일때
        if(x==1){
            return b%X;
        }
        long r = divide(a,b,x/2);
        if(x%2==0){
            return (r*r)%X;
        }else{
            return (((r*r)%X)*b)%X;
        }
    }

}

