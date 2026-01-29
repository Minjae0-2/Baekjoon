/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1463                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1463                           #+#        #+#      #+#    */
/*   Solved: 2026/01/28 17:30:42 by lawpea38      ###          ###   ##.kr    */
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
        arr[1]=0;
        for(int i=2; i<=n; i++){
            arr[i] = arr[i-1] + 1;
            if(i%3 == 0){
                arr[i] = Math.min(arr[i/3]+1, arr[i]);
            }
            if(i%2 == 0){
                arr[i] = Math.min(arr[i/2]+1, arr[i]);
            }
        }
        System.out.println(arr[n]);

    }
}