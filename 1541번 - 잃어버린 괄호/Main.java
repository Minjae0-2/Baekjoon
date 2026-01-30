/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1541                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1541                           #+#        #+#      #+#    */
/*   Solved: 2026/01/30 21:37:39 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] minusSplit = str.split("-");

        String[] plusStrArray = minusSplit[0].split("\\+");
        int[] plusArray = new int[plusStrArray.length];
        int sum = 0;

        // - 전은 모두 +
        for(int i=0; i<plusArray.length; i++){
            plusArray[i] = Integer.parseInt(plusStrArray[i]);
            sum += plusArray[i];
        }

        String[] plusStr2Array;
        // - 후는 모두 -취급하면 됨
        for(int i=1; i<minusSplit.length; i++) {
            plusStr2Array = minusSplit[i].split("\\+");
            for(int j=0; j<plusStr2Array.length; j++) {
                sum -= Integer.parseInt(plusStr2Array[j]);
            }
        }
        System.out.println(sum);

    }
}
