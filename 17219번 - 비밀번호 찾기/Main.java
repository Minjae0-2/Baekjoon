/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 17219                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/17219                          #+#        #+#      #+#    */
/*   Solved: 2026/01/27 16:56:31 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map <String,String> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
            map.put(st2.nextToken(), st2.nextToken());
        }

        for(int i=0; i<m; i++) {
            String key = br.readLine();
            String val = map.getOrDefault(key,null);
            sb.append(val).append('\n');
        }
        System.out.print(sb);
    }
}