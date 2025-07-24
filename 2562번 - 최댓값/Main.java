/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2562                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2562                           #+#        #+#      #+#    */
/*   Solved: 2025/07/24 10:19:21 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    int max=Integer.MIN_VALUE;
    int count=0;
    for(int i=0; i<9; i++){
        int c =sc.nextInt();
        if(max<c){
            max=c;
            count=i+1;
        }
    }
    System.out.println(max+"\n"+count);
    }
}