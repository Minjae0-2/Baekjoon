/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 7568                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/7568                           #+#        #+#      #+#    */
/*   Solved: 2025/08/02 21:12:42 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] weight= new int[n];
        int[] height= new int[n];
        for(int i=0; i<n; i++){
            String[] arr=br.readLine().split(" ");
            weight[i] = Integer.parseInt(arr[0]);
            height[i] = Integer.parseInt(arr[1]);
        }
        for(int i=0;i<n;i++){
            int count=1;
            for(int j=0; j<n; j++){
                if(i==j) continue;
                if(weight[i]<weight[j] && height[i]<height[j]){
                    count++;
                }
            }
            sb.append(count).append(' ');
        }
        System.out.print(sb);
        br.close();

    }
}
