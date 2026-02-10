/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11403                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11403                          #+#        #+#      #+#    */
/*   Solved: 2026/02/07 23:31:57 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            for(int j=0; j<n; j++) {
                arr[i][j] =Integer.parseInt(str[j]);
            }
        }
        // floyd
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    //1,4 -> 4,6 -> 6,7
                   if(arr[i][k] == 1 && arr[k][j]==1){
                       arr[i][j]=1;
                   }
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            for(int j=0; j<n; j++) {
                arr[i][j] =Integer.parseInt(str[j]);
            }
        }
        // BFS
        int[][] ans = new int[n][n];
        for(int i=0; i<n; i++) {
            boolean[] visited = new boolean[n];
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            while(!queue.isEmpty()){
                int cur = queue.poll();
                for(int next=0; next<n; next++){
                    if(arr[cur][next] == 0 || visited[next]){continue;}
                    visited[next] = true;
                    ans[i][next] = 1;  //**
                    queue.add(next);
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sb.append(ans[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
*/