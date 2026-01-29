/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11047                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11047                          #+#        #+#      #+#    */
/*   Solved: 2026/01/26 23:00:20 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int k = Integer.parseInt(arr[1]);
        int[] intarr = new int[n];
        for(int i=0; i<n; i++){
            intarr[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;
        for(int i=n-1; i>=0; i--){
            if(k == 0) break;
            if(k % intarr[i] == 0){
                count++;
                k %= intarr[i];
            }
        }
        System.out.println(count);
        
        
    }
}