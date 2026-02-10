/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2630                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2630                           #+#        #+#      #+#    */
/*   Solved: 2026/02/03 18:03:32 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[][] arr;
    static int n;
    static int whiteCount;
    static int blueCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        arr = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=1; j<=n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(1,1, n);
        System.out.println(whiteCount);
        System.out.println(blueCount);
    }
    public static void divide(int row, int col, int size){
        if(!checkColor(row, col, size)){
            size /= 2;
            divide(row, col, size);
            divide(row, col+size, size);
            divide(row+size, col, size);
            divide(row+size, col+size, size);
        }
    }
    public static boolean checkColor(int row, int col, int size){
        int targetColor = arr[row][col];

        for(int i=row; i<row+size; i++){
            for(int j= col; j<col+size; j++){
                if(arr[i][j] != targetColor){
                    return false;
                }
            }
        }
        if(targetColor == 0) whiteCount++;
        else blueCount++;
        return true;
    }
}