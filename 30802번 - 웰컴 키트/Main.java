/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 30802                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/30802                          #+#        #+#      #+#    */
/*   Solved: 2025/07/26 23:16:22 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb= new StringBuilder();
    int num = Integer.parseInt(br.readLine());
    String[] str = br.readLine().split(" ");
    int[] size = new int[6];
    size[0] = Integer.parseInt(str[0]);
    size[1] = Integer.parseInt(str[1]);
    size[2] = Integer.parseInt(str[2]);
    size[3] = Integer.parseInt(str[3]);
    size[4] = Integer.parseInt(str[4]);
    size[5] = Integer.parseInt(str[5]);
    String[] str2 = br.readLine().split(" ");
    int tNum = Integer.parseInt(str2[0]);
    int pNum = Integer.parseInt(str2[1]);
    int tCount = 0;

    for(int i=0; i<6; i++){
        if(size[i]>0){
            tCount += (size[i]-1)/tNum+1;
        }else{
            tCount+=0;
        }
    }
    sb.append(tCount).append('\n');
    sb.append(num/pNum).append(" ");
    sb.append(num%pNum);
    System.out.println(sb);
        br.close();
    }
    }

