/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 15663                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/15663                          #+#        #+#      #+#    */
/*   Solved: 2026/02/13 20:58:09 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static int n;
    static int m;
    static int[] num;
    static int[] ans;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n];
        ans = new int[m];
        visited = new boolean[n];

        StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(num);
        backtracking(0);

        System.out.print(sb);
    }
    public static void backtracking (int depth){
        if(depth == m){
            for(int i: ans){
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        int lastUsed =-1;
        for(int i= 0; i<n; i++){
            if(visited[i]) continue;
            if(lastUsed == num[i]) continue;

            visited[i] = true;
            lastUsed = num[i];
            ans[depth] = num[i];

            backtracking(depth+1);
            visited[i]=false;
        }
    }
}