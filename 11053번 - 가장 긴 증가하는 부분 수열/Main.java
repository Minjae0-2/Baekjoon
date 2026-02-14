/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11053                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11053                          #+#        #+#      #+#    */
/*   Solved: 2026/02/13 16:55:36 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static StringBuilder sb;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 1 1 2 7 3 4 7 8
        // 다 해봐야함
        int[] d = new int[n];
        int max = 0;
        for(int i=0; i<n; i++){
           d[i]= 1;
           for(int j=0; j<i; j++){
               if(arr[i] > arr[j]) {
                   d[i] = Math.max(d[j] + 1, d[i]);
                   max = Math.max(d[i], max);
               }
           }
        }

        System.out.println(max);
    }
}