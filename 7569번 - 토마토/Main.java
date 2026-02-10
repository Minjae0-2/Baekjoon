/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 7569                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/7569                           #+#        #+#      #+#    */
/*   Solved: 2026/02/10 16:38:46 by lawpea38      ###          ###   ##.kr    */
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
    static int h;
    static int[] addH = new int[] {0,0,0,0,+1,-1};
    static int[] addR = new int[] {+1,0,-1,0,0,0};
    static int[] addC = new int[] {0,-1,0,+1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        int[][][] tomato = new int[h][row][col];
        for(int i=0; i<h; i++){
            for(int j=0; j<row; j++){
                StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
                for(int k=0; k<col; k++){
                    tomato[i][j][k] = Integer.parseInt(st2.nextToken());
                }
            }
        }
        // BFS로 추적 후 마지막에 0 있는지 확인 tomato 전염되면 +1
        // 방문처리 -> 새로운 배열 생성 안해도 됨

        Queue<int[]> queue = new ArrayDeque<>();

        for(int i=0; i<h; i++) {
            for(int j=0; j<row; j++) {
                for(int k=0; k<col; k++) {
                    if(tomato[i][j][k]==1) {
                        queue.add(new int[]{i,j,k});
                    }
                }
            }
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int ch = cur[0];
            int cr = cur[1];
            int cc = cur[2];
            for(int i=0; i<6; i++){
                int nh = ch+ addH[i];
                int nr = cr+ addR[i];
                int nc = cc+ addC[i];
                if(nh>=h || nr>=row || nc>= col || nh<0 || nc<0 || nr<0) continue;
                if(tomato[nh][nr][nc] != 0) continue;
                tomato[nh][nr][nc] = tomato[ch][cr][cc]+1;
                queue.add(new int[] {nh,nr,nc});
            }
        }
        hasYoungTomato(tomato);

    }

    public static void hasYoungTomato(int[][][] minCount){
        int maxVal = 0;
        for(int i=0; i<h; i++){
            for(int j=0; j<row; j++){
                for(int k=0; k<col; k++){
                    if(minCount[i][j][k]== 0){
                        System.out.println(-1);
                        return;
                    }
                    if(maxVal < minCount[i][j][k]) maxVal = minCount[i][j][k];
                }
            }
        }
        System.out.println(maxVal-1);
    }
}