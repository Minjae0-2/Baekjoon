/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 4153                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/4153                           #+#        #+#      #+#    */
/*   Solved: 2025/07/26 17:36:52 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb= new StringBuilder();
    while(true) {
        String[] str = br.readLine().split(" ");
        int[] line = new int[3];
        line[0] = Integer.parseInt(str[0]);
        line[1] = Integer.parseInt(str[1]);
        line[2] = Integer.parseInt(str[2]);
        if(line[0]==0&&line[1]==0&&line[2]==0) break;

        Arrays.sort(line);

        if(line[2]*line[2]==line[1]*line[1]+line[0]*line[0]){
            sb.append("right").append('\n');
        }else{
            sb.append("wrong").append('\n');
        }
    }
        System.out.println(sb);
        br.close();
    }
    }

