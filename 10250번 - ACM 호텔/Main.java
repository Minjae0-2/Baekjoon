/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 10250                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/10250                          #+#        #+#      #+#    */
/*   Solved: 2025/07/26 17:04:10 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int a = Integer.parseInt(br.readLine());
    for(int i=0; i<a; i++){
        String[] str = br.readLine().split(" ");
        int order = Integer.parseInt(str[2]);
        int floor = Integer.parseInt(str[0]);
        int customerFloor = order%floor;
        if(customerFloor == 0) customerFloor = floor;
        sb.append(customerFloor);

        int customerRoom = (order-1)/floor+1;
        if(customerRoom<10){
            sb.append('0').append(customerRoom).append('\n');
        }else{
            sb.append(customerRoom).append('\n');
        }

        }
    System.out.println(sb);
    br.close();

    }
    }

