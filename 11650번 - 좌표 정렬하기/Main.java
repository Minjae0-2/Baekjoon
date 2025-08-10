/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11650                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11650                          #+#        #+#      #+#    */
/*   Solved: 2025/08/10 20:58:56 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Pos {
    int x;
    int y;
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr= new int[n];
        String[] str= new String[2];
        Pos[] position = new Pos[n];
        for(int i=0;i<n;i++){
           str = br.readLine().split(" ");
           position[i]=new Pos();
           position[i].x=Integer.parseInt(str[0]);
           position[i].y=Integer.parseInt(str[1]);
        }

        Arrays.sort(position,(p1, p2) -> {
        if(p1.x==p2.x){
            return p1.y-p2.y;
        }else{
            return p1.x-p2.x;
        }});

        for(int i=0;i<arr.length;i++){
            sb.append(position[i].x).append(" ").append(position[i].y).append('\n');
        }
        System.out.print(sb);
    }
}