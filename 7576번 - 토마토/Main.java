/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 7576                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/7576                           #+#        #+#      #+#    */
/*   Solved: 2026/02/10 16:51:24 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static int row;
    static int col;
    static int[] addR = new int[] {+1,0,-1,0};
    static int[] addC = new int[] {0,-1,0,+1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        int[][] tomato = new int[row][col];
        Queue<int[]> queue = new ArrayDeque<>();

        // 답 -1 bfs로
        for(int i=0; i<row; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<col; j++) {
                tomato[i][j] = Integer.parseInt(st2.nextToken());
                if(tomato[i][j] == 1){
                    queue.add(new int[] {i,j});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curR = cur[0];
            int curC = cur[1];
            for(int i=0; i<4; i++){
                int nextR = curR + addR[i];
                int nextC = curC + addC[i];
                if(nextR>=row || nextC>=col|| nextR<0|| nextC<0 || tomato[nextR][nextC] != 0 ) continue;
                tomato[nextR][nextC] = tomato[curR][curC] + 1;
                queue.add(new int[] {nextR,nextC});
            }
        }
        hasYoungTomato(tomato);
    }

    public static void hasYoungTomato(int[][] tomato){
        int maxVal =0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++) {
                if(tomato[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                if(maxVal < tomato[i][j]) maxVal = tomato[i][j];
            }
        }
        System.out.println(maxVal-1);
    }
}