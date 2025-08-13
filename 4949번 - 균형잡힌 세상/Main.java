/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 4949                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/4949                           #+#        #+#      #+#    */
/*   Solved: 2025/08/14 00:06:43 by lawpea38      ###          ###   ##.kr    */
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
        while (true) {
            String sentence = br.readLine();
            if (sentence.charAt(0) == '.') break;
            sb.append(isEquivalence(sentence)).append('\n');
        }
        System.out.print(sb);
        br.close();
    }

    public static String isEquivalence(String sentence) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : sentence.toCharArray()){
            if (c == '[' || c == '(') {
                stack.push(c);
            }
            else if (c == ']'){
                if(stack.isEmpty()||stack.peek()!='['){
                    return "no";
                }else{
                    stack.pop();
                }
            }
            else if (c == ')'){
                if(stack.isEmpty()||stack.peek()!='('){
                    return "no";
                }else{
                    stack.pop();
                }
            }
            else if (c == '.') {
                break;
            }
        }
        if(stack.isEmpty()){
            return "yes";
        }else{
            return "no";
        }

}
}

