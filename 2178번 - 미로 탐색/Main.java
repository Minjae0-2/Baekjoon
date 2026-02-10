/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2178                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2178                           #+#        #+#      #+#    */
/*   Solved: 2026/02/07 17:13:13 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static final int[] addRow = {+1, 0, -1, 0};
    static final int[] addCol = {0, -1, 0, +1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int destRow = n-1;
        int destCol = m-1;

        char[][] arr = new char[n][m];

        for(int i=0; i<n; i++){
           arr[i] = br.readLine().toCharArray();
        }

        // 최단경로 - bfs - queue에 1차원 배열 - 좌표 기록 위해
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] dist = new int[n][m];
        for (int i=0; i<n; i++){
            Arrays.fill(dist[i], -1);
        }

        queue.add(new int[]{0,0});
        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] curArr = queue.poll();
            int curRow = curArr[0];
            int curCol = curArr[1];

            for(int i=0; i<=3; i++) {
                int row = curRow + addRow[i];
                int col = curCol + addCol[i];
                if(row>destRow || row<0 || col>destCol || col<0 || dist[row][col] != -1 || arr[row][col] == '0') continue;
                dist[row][col] = dist[curRow][curCol]+1;

                if(row==destRow && col==destCol) {
                    System.out.println(dist[destRow][destCol]);
                    return;
                }

                queue.add(new int[]{row,col});
            }

        }
    }
}