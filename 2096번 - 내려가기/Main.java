/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2096                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2096                           #+#        #+#      #+#    */
/*   Solved: 2026/02/15 01:53:13 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import javax.lang.model.type.ArrayType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] dpMin = new int[2][3];
        int[][] dpMax = new int[2][3];
        int min = Integer.MAX_VALUE;
        int max = 0 ;
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(i==0){
                dpMin[0][0] = a;
                dpMin[0][1] = b;
                dpMin[0][2] = c;
                dpMax[0][0] = a;
                dpMax[0][1] = b;
                dpMax[0][2] = c;
            }

            //DP
            if (i>=1) {
                dpMin[1][0] = Math.min(dpMin[0][1], dpMin[0][0]) +a;
                dpMin[1][1] = Math.min(Math.min(dpMin[0][2], dpMin[0][1]), dpMin[0][0]) +b;
                dpMin[1][2] = Math.min(dpMin[0][2], dpMin[0][1]) +c;

                dpMax[1][0] = Math.max(dpMax[0][1], dpMax[0][0]) +a;
                dpMax[1][1] = Math.max(Math.max(dpMax[0][2], dpMax[0][1]), dpMax[0][0]) +b;
                dpMax[1][2] = Math.max(dpMax[0][2], dpMax[0][1]) +c;

                dpMin[0][0] = dpMin[1][0];
                dpMin[0][1] = dpMin[1][1];
                dpMin[0][2] = dpMin[1][2];
                dpMax[0][0] = dpMax[1][0];
                dpMax[0][1] = dpMax[1][1];
                dpMax[0][2] = dpMax[1][2];
            }
        }
        min = Math.min(Math.min(dpMin[0][0],dpMin[0][1]),dpMin[0][2]);
        max = Math.max(Math.max(dpMax[0][0],dpMax[0][1]),dpMax[0][2]);
        System.out.println(max+" "+min);
    }
}