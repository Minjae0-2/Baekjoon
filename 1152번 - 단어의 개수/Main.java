/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1152                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1152                           #+#        #+#      #+#    */
/*   Solved: 2025/07/24 13:21:08 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */

/* 
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count=0;
        while(sc.hasNext()){
        String str = sc.next();
        count++;}
        System.out.println(count);
    }
} */


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s= sc.nextLine();
        s =s.trim();
        if(s.isBlank()){            //s.isEmpty()도 가능
            System.out.println(0);
        }else {
            String[] arr = s.split("\\s+");
            System.out.println(arr.length);
        }
    }
}