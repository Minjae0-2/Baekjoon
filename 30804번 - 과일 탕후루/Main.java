/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 30804                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/30804                          #+#        #+#      #+#    */
/*   Solved: 2026/02/05 15:22:09 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
           arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[10];
        int start = 0;
        int maxFruits = 0;
        int distinctCount = 0;
        for(int end=0; end<n; end++){
            int fruit = arr[end];

            if(count[fruit]==0){
                distinctCount++;
            }
            count[fruit]++;

            while(distinctCount > 2){
                int removeFruit = arr[start];
                count[removeFruit]--;
                if(count[removeFruit] == 0){
                    distinctCount --;
                }
                start++;
            }
            maxFruits = Math.max(maxFruits, end-start+1);
        }
        System.out.println(maxFruits);
       
    }
}