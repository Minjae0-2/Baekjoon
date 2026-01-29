/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2579                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2579                           #+#        #+#      #+#    */
/*   Solved: 2026/01/28 23:10:24 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] d = new int[n+1];
        if(n>=1){
            d[1] = arr[1];
        }
        if(n>=2) {
            d[2] = arr[2]+ arr[1];
        }

        for(int i=3; i<=n; i++){
            d[i]= Math.max(d[i-2]+arr[i] , d[i-3]+arr[i-1]+arr[i]);
        }
        System.out.println(d[n]);
    }
}

/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 2차원은 계단층 1차원은 몇번 연속으로 1칸 옮겼는지
        int [][] d = new int[n+1][2];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<2; j++){
                d[i][j]=0;
            }
        }
        if(n>=1){
            d[1][0] = arr[1];
        }
        if(n>=2) {
            d[2][0] = arr[2];
            d[2][1] = d[1][0] + arr[2];
        }
        //d[4][0]= max(d[2][0],d[2][1])+arr[4];
        //d[4][1] = d[3][0]+arr[4];

        for(int i=3; i<=n; i++){
            d[i][0] = Math.max(d[i-2][0], d[i-2][1]) + arr[i];
            d[i][1] = d[i-1][0]+ arr[i];
        }
        int result = Math.max(d[n][0],d[n][1]);
        System.out.println(result);
    }
}
*/