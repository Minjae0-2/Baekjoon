/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1620                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1620                           #+#        #+#      #+#    */
/*   Solved: 2025/08/16 16:45:15 by lawpea38      ###          ###   ##.kr    */
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
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        Map<Integer,String> map = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        for(int i=1; i<=n; i++) {
            String input = br.readLine();
            map.put(i,input);
            map2.put(input,i);
        }
        for(int i=0; i<m; i++) {
                String input = br.readLine();
                if(Character.isDigit(input.charAt(0))){
                    int answer =Integer.parseInt(input);
                    sb.append(map.get(answer)).append('\n');
                }else{
                    sb.append(map2.get(input)).append('\n');
                    }
                }

        System.out.print(sb);
        br.close();
    }
}

