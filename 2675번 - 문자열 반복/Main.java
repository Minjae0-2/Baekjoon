/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2675                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2675                           #+#        #+#      #+#    */
/*   Solved: 2025/07/24 10:06:20 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    for(int i=0; i<num; i++){
        int count = sc.nextInt();
        String str = sc.next();
        int length = str.length();
        for(int k=0; k<length; k++){
        for(int j=0; j<count; j++) {
            System.out.print(str.charAt(k));
        }
        }
        System.out.println();
    }
    }
}