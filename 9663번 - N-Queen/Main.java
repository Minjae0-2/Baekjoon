/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 9663                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/9663                           #+#        #+#      #+#    */
/*   Solved: 2026/02/22 16:40:27 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static int n;
    static int[] chess;
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        chess = new int[n];
        backtracking(0);
        System.out.println(count);
    }
    static void backtracking(int start){
        if(start>=n){
            count++;
            return;
        }
        for(int i=0; i<n; i++){
            if(!checkQueen(start,i)) continue;
            chess[start] = i;
            backtracking(start+1);
        }
    }
    static boolean checkQueen(int row, int col){
        for(int i=0; i<row; i++){
            if(chess[i] == col){
                return false;
            }
            // chess[1]= 1;
            // chess[6] = 7;
            // row-i col-chess[i]
            if(Math.abs(row-i) == Math.abs(col-chess[i])){
                return false;
            }
        }
        return true;
    }
}
