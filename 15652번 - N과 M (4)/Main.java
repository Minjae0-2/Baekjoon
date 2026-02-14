/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 15652                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/15652                          #+#        #+#      #+#    */
/*   Solved: 2026/02/13 14:32:54 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static StringBuilder sb;
    static int n;
    static int m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        backtracking(1,0);
        System.out.println(sb);
    }
    public static void backtracking(int start,int depth){
        if(depth == m){
            for(int i: arr){
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=start; i<=n; i++){
            arr[depth] = i;
            backtracking(i,depth+1);
        }
    }
}