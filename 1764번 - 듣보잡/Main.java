/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1764                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1764                           #+#        #+#      #+#    */
/*   Solved: 2025/08/16 17:38:25 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
/* HashSet의 contains에 있다면 list에 추가 이 방식도 있음 */
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        Map<String,Integer> map = new HashMap<>();
        for(int i=0 ; i<n; i++){
            map.put(br.readLine(),1);
        }
        for(int i=0 ; i<m; i++){
            String input = br.readLine();
            map.put(input,map.getOrDefault(input,0)+1);
        }
        List<String> list = new ArrayList<>();
        for(String person : map.keySet()){
            if(map.get(person)==2){
               list.add(person);
            }
        }
        Collections.sort(list);
        sb.append(list.size()).append('\n');
        for(String person: list){
            sb.append(person).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}

