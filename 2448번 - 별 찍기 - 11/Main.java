/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2448                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2448                           #+#        #+#      #+#    */
/*   Solved: 2026/02/21 01:27:39 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static boolean[][] star;
    static int[] addr = {0,+1,+1,+2,+2,+2,+2,+2};
    static int[] addc = {0,-1,+1,-2,-1,0,+1,+2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        star = new boolean[n][2*n-1];
        solve(0,n-1,n);
        for(int i=0; i<n; i++){
            for(int j=0; j<2*n-1; j++){
                if(star[i][j]){
                    sb.append('*');
                }else{
                    sb.append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
    static void solve(int row, int col, int n){
        if(n == 3){
            for(int i=0; i<8; i++){
                star[row+addr[i]][col+addc[i]] = true;
            }
            return;
        }
        solve(row,col,n/2);
        solve(row+n/2,col-n/2,n/2);
        solve(row+n/2,col+n/2,n/2);
    }
}
