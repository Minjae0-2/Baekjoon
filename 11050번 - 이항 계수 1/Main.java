/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11050                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11050                          #+#        #+#      #+#    */
/*   Solved: 2025/07/29 12:08:01 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
      /*0 1 2 3 4 5 6
      1 1 1
      2 1 2 1
      3 1 3 3 1
      4 1 4 6 4 1
      5 1
     */
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();

        if (k>n/2) {
            k=n-k;
        }

        if(k==0){
        System.out.println(1);
        return;
    }

    int[][] D = new int[n+1][k+1];

    for(int i=1; i<=n; i++){
        D[i][0]=1;
    }
    D[1][1]=1;

    for(int i=2; i<=n; i++){
        for(int j=1; j<=k; j++){
            if(j==i){
                D[i][j]=1;
            }else if(j<i) {
                D[i][j] = D[i - 1][j - 1] + D[i - 1][j];
            }
            }
    }
    System.out.println(D[n][k]);
    }
}
