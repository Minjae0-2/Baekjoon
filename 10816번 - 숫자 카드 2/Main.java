/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 10816                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/10816                          #+#        #+#      #+#    */
/*   Solved: 2025/08/14 15:07:22 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] myCard = br.readLine().split(" ");
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(String str :  myCard){
            int card = Integer.parseInt(str);
            map.put(card,map.getOrDefault(card,0)+1);
        }
        int m = Integer.parseInt(br.readLine());
        String[] givenCard = br.readLine().split(" ");
        for(String str: givenCard){
            int card = Integer.parseInt(str);
            sb.append(map.getOrDefault(card,0)).append(" ");
        }
        System.out.print(sb);
        br.close();
    }
}

