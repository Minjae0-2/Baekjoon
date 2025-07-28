/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2775                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2775                           #+#        #+#      #+#    */
/*   Solved: 2025/07/28 17:56:15 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int num= Integer.parseInt(br.readLine());
        for(int i=0; i<num; i++){
            int k = Integer.parseInt(br.readLine());
            int n= Integer.parseInt(br.readLine());
            int res = live(k,n);
            sb.append(res).append('\n');
        }
        System.out.println(sb);
    }
    public static int live(int a, int b){
      /* 1 2 3 4
      3
      2 1 4 10 20
      1 1 3 6 10
      0 1 2 3 4
      */
        int[][] D= new int[a+1][b+1]; //0~a층 1~b호
        for(int j=1; j<=b; j++){
            D[0][j]=j;
        }
        for(int i=1; i<=a;i++){
            D[i][1]=1;
        }
        for(int i=1; i<=a; i++){
            for(int j=2; j<=b; j++){
               D[i][j]=D[i-1][j]+D[i][j-1];
            }
        }
        return D[a][b];
    }
}
