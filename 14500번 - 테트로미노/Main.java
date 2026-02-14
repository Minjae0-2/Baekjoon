/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 14500                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/14500                          #+#        #+#      #+#    */
/*   Solved: 2026/02/11 01:26:24 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static StringBuilder sb;
    static int max;
    static int r;
    static int c;
    static int[][] square;
    static boolean[][] visited;
    static int[] addR = new int[]{+1,0,-1,0};
    static int[] addC = new int[]{0,-1,0,+1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        square = new int[r][c];
        for (int i=0; i<r; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<c; j++){
                square[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        // DFS로 접근 - visited 배열 때문에
        max = 0;
        visited = new boolean[r][c];
        for (int i=0; i<r; i++) {
            for(int j=0; j<c; j++){
                visited[i][j] = true;
                dfs(i,j,1, square[i][j]);
                visited[i][j] = false;

                checkT(i,j);
            }
        }

        System.out.println(max);
    }
    public static void dfs(int i, int j, int depth, int sum){
        if(depth == 4){
            if(max<sum){
                max = sum;
            }
            return;
        }
        for(int d=0; d<4; d++){
            int nr = i+ addR[d];
            int nc = j+ addC[d];
            if(nr>=0 && nc>=0 && nr<r && nc<c && !visited[nr][nc]){
                visited[nr][nc] = true;
                dfs(nr,nc,depth+1,sum + square[nr][nc]);
                visited[nr][nc] = false;
            }
        }
    }
    public static void checkT(int i, int j){
        int sum = square[i][j];
        int min = Integer.MAX_VALUE;
        int wings = 0;
        for(int d=0; d<4; d++) {
            int ni = i+addR[d];
            int nj = j+addC[d];
            if(ni>=0 && nj>=0 && ni<r && nj<c){
                wings++;
                sum +=square[ni][nj];
                min = Math.min(min,square[ni][nj]);
            }
        }
        if(wings == 4){
            max =Math.max(max,sum-min);
        }
        else if(wings == 3){
            max = Math.max(max,sum);
        }

    }
}