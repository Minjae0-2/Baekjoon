/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1012                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1012                           #+#        #+#      #+#    */
/*   Solved: 2026/01/30 15:55:06 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n,m;
    static boolean[][] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new boolean[n][m];
            int k = Integer.parseInt(st.nextToken());

            int x=0;
            int y=0;
            for(int j=0; j<k; j++){
                StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
                x= Integer.parseInt(st2.nextToken());
                y= Integer.parseInt(st2.nextToken());
                arr[x][y] = true;
            }

            int count = 0;

            for(int j=0; j<n; j++){
                for(int s=0; s<m; s++){
                    if(arr[j][s] == true){
                        //DFS로 인접 다 지워버려
                        count++;
                        dfs(j,s);
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);

    }
    public static void dfs(int x, int y){
        if(x<0 || x>=n || y<0 || y>=m || !arr[x][y]) return;
        arr[x][y] = false;
        dfs(x-1,y);
        dfs(x,y-1);
        dfs(x+1,y);
        dfs(x,y+1);
    }
}
