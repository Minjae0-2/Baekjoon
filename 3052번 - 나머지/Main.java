/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 3052                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/3052                           #+#        #+#      #+#    */
/*   Solved: 2025/07/24 16:14:39 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
/*import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str;
    int[] arr= new int[10];
    for(int i=0; i<10; i++){
        str = br.readLine();
        int num=Integer.parseInt(str);
        arr[i]=num%42;
    }
    Arrays.sort(arr);
    int count=1;
    for(int j=0; j<9; j++){
        if(arr[j]!=arr[j+1]){
            count++;
        }
    }

    System.out.println(count);

    br.close();
    }
}*/

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] arr= new boolean[42];
        for(int i=0; i<10; i++){
            int r = Integer.parseInt(br.readLine())%42;
            arr[r]=true;
        }
        int count=0;
        for(boolean j: arr){
            if(j){
                count++;
            }
        }
        System.out.println(count);
        br.close();
    }
}