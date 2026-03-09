/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 10830                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/10830                          #+#        #+#      #+#    */
/*   Solved: 2026/02/23 18:11:28 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static int[][] matrix;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        matrix = new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<n;j++){
                matrix[i][j] = (int)(Long.parseLong(st2.nextToken())%1000);
            }
        }
        int[][] ans =  divide(m);
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++) {
                sb.append(ans[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
    static int[][] divide(long m){
        if(m==1){
            return matrix;
        }
        int[][] r = divide(m/2);
        if(m%2 != 0){
            // 홀수 - 1번 더 곱해줘야함
            int[][] temp =  multiply(r);
            return multiply(temp,matrix);
        }else{
            return multiply(r);
        }
    }
    static int[][] multiply(int[][] matrix){
        int[][] result =  new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) {
                for(int k=0; k<n; k++) {
                    result[i][j] += (matrix[i][k] * matrix[k][j])%1000;
                }
                result[i][j] %= 1000;
            }
        }
        return result;
    }
    static int[][] multiply(int[][] matrix,int[][] matrix2){
        int[][] result =  new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) {
                for(int k=0; k<n; k++) {
                    result[i][j] += (matrix[i][k] * matrix2[k][j])%1000;
                }
                result[i][j] %= 1000;
            }
        }
        return result;
    }
}
