/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 10818                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/10818                          #+#        #+#      #+#    */
/*   Solved: 2025/07/22 16:19:09 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int max=Integer.MIN_VALUE , min=Integer.MAX_VALUE;
        for(int i=0; i<A; i++){
            int num=sc.nextInt();
            if(min>num) min=num;
            if(max<num) max=num;
        }
        System.out.println(min +" " + max);
}
}