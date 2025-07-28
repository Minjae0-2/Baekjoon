/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1546                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1546                           #+#        #+#      #+#    */
/*   Solved: 2025/07/28 11:48:59 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        String[] str= br.readLine().split(" ");
        int[] score= new int[n];
        int max = 0;
        for(int i=0; i<n; i++){
            score[i]=Integer.parseInt(str[i]);
            if(max < score[i]){
                max = score[i];
            }
        }
        float avg=0;
        for(int j=0; j<n; j++) {
                avg += (float)score[j]/max*100;
        }
        avg = avg/n;
        System.out.println(avg);
    }
}
