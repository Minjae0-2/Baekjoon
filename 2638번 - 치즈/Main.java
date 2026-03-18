/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2638                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2638                           #+#        #+#      #+#    */
/*   Solved: 2026/03/17 20:25:47 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import javax.lang.model.type.ArrayType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static int[] addR = {0,+1,0,-1};
    static int[] addC = {+1,0,-1,0};
    static int n;
    static int m;
    static int[][] cheese;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        // C를 확인해서 4개 방향 공기 있는지 확인
        // 안쪽 공기는 count 안하므로 안쪽 공기는 다르게 취급
        // 만일 바깥쪽 공기가 2개 이상 포함시 안쪽 공기가 있다면 안쪽 공기를 갱신해야함
        cheese = new int[n][m];
        for(int i=0; i<n; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++) {
                cheese[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        int time = meltCheese();
        System.out.println(time);
    }
    public static boolean checkAir(){
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        int[] sr = {0,0,n-1,n-1};
        int[] sc = {0,m-1,0,m-1};
        for(int i=0; i<4; i++){
            queue.add(new int[] {sr[i],sc[i]});
            visited[sr[i]][sc[i]] = true;
            cheese[sr[i]][sc[i]] = -1;
        }
        while(!queue.isEmpty()){
            int[] c = queue.poll();
            int cr = c[0];
            int cc = c[1];
            for(int i=0; i<4; i++){
                int nr = cr+addR[i];
                int nc = cc+addC[i];
                if(nr<0 || nc<0 || nr>=n || nc>=m || visited[nr][nc]) continue;
                if(cheese[nr][nc] == 1) continue;
                visited[nr][nc] = true;
                cheese[nr][nc] = -1;
                queue.add(new int[]{nr,nc});
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(cheese[i][j] == 1) return true;
            }
        }
        return false;
    }
    public static int meltCheese(){
        int time=0;
        while(true) {
            if(!checkAir()) break;
            List<int[]> toMelt = new ArrayList<>();
            for (int i=0; i<n; i++) {
                for (int j = 0; j < m; j++) {
                    if (cheese[i][j] == 1) {
                        int air = 0;
                        for (int k=0; k<4; k++) {
                            int nr = i + addR[k];
                            int nc = j + addC[k];
                            if (nr<0 || nc<0 || nr>=n || nc>=m) continue;
                            // -1 두개면 녹음 -> 0를 -1으로
                            if (cheese[nr][nc] == -1) {
                                air++;
                            }
                        }
                        if (air >= 2) {
                            toMelt.add(new int[]{i,j});
                        }
                    }
                }
            }
            if(toMelt.isEmpty()) break;
            for(int[] c : toMelt){
                cheese[c[0]][c[1]]=0;
            }
            time++;
        }
        return time;
    }

}

