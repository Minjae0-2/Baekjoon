/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1018                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1018                           #+#        #+#      #+#    */
/*   Solved: 2025/08/13 15:49:15 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        String[] str= new String[2];
        str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        char[][] chess= new char[n][m];
        for(int i=0; i<n; i++){
            String str2 = br.readLine();
            for(int j=0; j<m; j++){
                chess[i][j] = str2.charAt(j);
            }
        }
        int count_G = 64;
        for(int i=0; i<=n-8; i++){
            for(int j=0; j<=m-8; j++){
               count_G = Math.min(count_G, currentValue(chess,i,j));
            }
        }

        System.out.print(count_G);
    }
    public static int currentValue(char[][] chess, int startI, int startJ){
        int count_W=0;
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if((i+j)%2==0) {
                    if(chess[i + startI][j + startJ]=='B'){
                        count_W++;
                    }
                }else{
                    if(chess[i + startI][j + startJ]=='W'){
                        count_W++;
                    }
                }
                }
        }
        int count_B= 64-count_W;
        int result = Math.min(count_W,count_B);
        return result;
    }
}

