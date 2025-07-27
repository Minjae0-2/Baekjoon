/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2798                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2798                           #+#        #+#      #+#    */
/*   Solved: 2025/07/27 21:33:40 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        String[] card = br.readLine().split(" ");
        int[] cardNum = new int[n];
        for (int i = 0; i < n; i++) {
            cardNum[i] = Integer.parseInt(card[i]);
        }
        int sum= 0 ;
        int presum = 0;

        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    sum = cardNum[i]+cardNum[j]+cardNum[k];
                    if(sum==m){
                        System.out.println(sum);
                        return;
                    }
                    if(sum<=m && presum<sum){
                    presum = sum;
                    }
                }
            }
        }
        System.out.println(presum);
    }
}
