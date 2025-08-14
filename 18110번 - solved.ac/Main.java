/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 18110                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/18110                          #+#        #+#      #+#    */
/*   Solved: 2025/08/14 16:42:31 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        if(n==0){
            System.out.print(0);
            br.close();
            return;
        }
        int[] arr= new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        float avg= 0;
        int excludedCount = (int)Math.round(n*0.15);
        int start = excludedCount;
        int last = n-excludedCount-1;
        for(int i=start; i<=last; i++){
            avg+=arr[i];
        }
        avg = Math.round(avg/(last-start+1));
        sb.append((int)avg);
        System.out.print(sb);
        br.close();
    }
}

