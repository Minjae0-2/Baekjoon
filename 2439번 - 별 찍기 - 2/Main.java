/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2439                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2439                           #+#        #+#      #+#    */
/*   Solved: 2025/07/24 14:16:16 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.Scanner;
/* 
public class Main {
    public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    int num = sc.nextInt();
    for(int i=0;i<num;i++){
        for(int j=0; j<num-i-1;j++){
            System.out.print(" ");
        }
        for(int k=0;k<i+1;k++){
            System.out.print("*");
        }
        System.out.println("");
    }
    }
}
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    int num = sc.nextInt();

    for(int i=1; i<=num; i++){
        System.out.println(" ".repeat(num-i)+"*".repeat(i));
    }
    }
}