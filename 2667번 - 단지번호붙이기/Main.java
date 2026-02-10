/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2667                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2667                           #+#        #+#      #+#    */
/*   Solved: 2026/02/07 19:48:20 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static List<Integer> countL;
    static int n;
    static char arr[][];
    static boolean[][] dist;
    static final int[] addR = {+1,0,-1,0};
    static final int[] addC = {0,-1,0,+1};
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for(int i=0; i<n; i++){
            arr[i] = br.readLine().toCharArray();
        }

        // 각 단지간 집개수 리스트
        countL = new ArrayList<>();
        // 방문 했는지 안했는지
        dist = new boolean[n][n];

        // dfs 가 나을거 같음
        for(int i=0;i<n; i++) {
            for(int j =0; j<n; j++) {
                count = 0;
                dfs(i, j);
                if(count!=0){
                    countL.add(count);
                }
            }
        }
        Collections.sort(countL);
        StringBuilder sb = new StringBuilder();
        sb.append(countL.size()).append('\n');
        for(int l: countL) {
            sb.append(l).append('\n');
        }
        System.out.print(sb);
    }
    public static void dfs(int row, int col){
        if(row>=n || row<0 || col>= n|| col<0 || arr[row][col] == '0' || dist[row][col]) return;

        count++;
        dist[row][col] = true;

        for(int i=0; i<=3; i++) {
            int r= row+addR[i];
            int c= col+addC[i];
            dfs(r,c);
        }
    }
}