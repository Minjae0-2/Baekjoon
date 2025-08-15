/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1874                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1874                           #+#        #+#      #+#    */
/*   Solved: 2025/08/15 14:31:10 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr= new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<n; i++) {
             arr[i]= Integer.parseInt(br.readLine());
        }
        int num=1;
        for(int i=0; i<n; i++) {
            while (num<=arr[i]) {
                    stack.push(num);
                    sb.append('+').append('\n');
                    num++;
            }
            if(!stack.isEmpty() && arr[i]==stack.peek()){
                stack.pop();
                sb.append('-').append('\n');
            }
            else{
                System.out.print("NO");
                br.close();
                return;
            }

        }
        System.out.print(sb);
        br.close();
    }
}

