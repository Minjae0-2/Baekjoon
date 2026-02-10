/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1074                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1074                           #+#        #+#      #+#    */
/*   Solved: 2026/02/09 14:33:58 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int res = solve(r,c,n);
        System.out.println(res);
    }
    public static int solve (int row, int col, int n){
        if(n<1) return 0;
        int half =  1 << (n-1);
        int halfSize = half*half;
        if(row<half && col>=half){
            return halfSize + solve(row,col-half,n-1);
        }else if(row>=half && col>=half){
            return 3*halfSize + solve(row-half, col-half, n-1);
        }else if(row>=half && col<half){
            return 2*halfSize +solve(row-half, col, n-1);
        }else{
            return solve(row,col,n-1);
        }
    }
}