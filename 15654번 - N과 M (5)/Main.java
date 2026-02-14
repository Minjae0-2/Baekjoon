/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 15654                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/15654                          #+#        #+#      #+#    */
/*   Solved: 2026/02/13 16:14:19 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static StringBuilder sb;
    static int n;
    static int m;
    static int[] arr;
    static int[] ans;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        ans = new int[m];
        visited = new boolean[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(arr);
        backtracking(0);
        System.out.print(sb);
    }
    public static void backtracking(int depth){
        if(depth == m){
            for(int i: ans){
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = 0; i<n; i++){
            if(!visited[i]) {
                visited[i] = true;
                ans[depth] = arr[i];
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}