/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 17144                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/17144                          #+#        #+#      #+#    */
/*   Solved: 2026/03/08 18:53:06 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static int n,m,t;
    static int[][] room;
    static int[][] result;
    static int airRow; // -1인것도 airRow
    static int[] addR = {0,+1,0,-1};
    static int[] addC = {+1,0,-1,0};
    static int[] shiftClockWiseR = {+1,0,-1,0};
    static int[] shiftClockWiseC = {0,+1,0,-1};
    static int[] shiftCounterClockWiseR = {-1,0,+1,0};
    static int[] shiftCounterClockWiseC = {0,+1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        room = new int[n][m];
        result = new int[n][m];

        for(int i=0; i<n; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++) {
                room[i][j] = Integer.parseInt(st2.nextToken());
                if(room[i][j] == -1){
                    airRow = i;
                    result[i][j] = -1;
                }
            }
        }
        for(int i=0; i<t; i++) {
            diffusion();
            operateAirPurifier(airRow+1,true,shiftClockWiseR,shiftClockWiseC);
            operateAirPurifier(airRow-2,false,shiftCounterClockWiseR,shiftCounterClockWiseC);
            // 원본 배열에 복사해주어야 함
            int[][] temp= room;
            room = result;
            result = temp;
            for(int j=0; j<n; j++){
                Arrays.fill(result[j],0);
            }

            room[airRow][0] = -1;
            room[airRow-1][0] = -1;
            result[airRow][0] = -1;
            result[airRow-1][0] = -1;
        }
        int res=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                if(room[i][j] == -1) continue;
                res +=room[i][j];
            }
        }
        System.out.println(res);
    }
    public static void diffusion(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                if(room[i][j] == 0 || room[i][j]==-1) continue;
                int diffCount=0;
                for(int k=0; k<4; k++){
                    int nr = i+ addR[k];
                    int nc = j+ addC[k];
                    if(nr<0 || nc<0 || nr>=n || nc>=m || (nr== airRow&&nc==0 )|| (nr==airRow-1 && nc==0)) continue;
                    diffCount++;
                    result[nr][nc] += room[i][j]/5;
                }
                result[i][j] += room[i][j] - (room[i][j]/5)*diffCount;
            }
        }
    }
    public static void operateAirPurifier(int startRow, boolean isClockWise, int[] shiftR, int[] shiftC ) {
        int standardMinRow = 0;
        int standardMaxRow = 0;
        if(isClockWise) {
            standardMinRow = airRow;
            standardMaxRow = n-1;
        }else{
            standardMinRow = 0;
            standardMaxRow = airRow-1;
        }
        int cr = startRow;
        int cc = 0;
        for(int i=0; i<4; i++){
            while(true) {
                int nr = cr + shiftR[i];
                int nc = cc + shiftC[i];
                if(nr<standardMinRow || nc<0 || nr>standardMaxRow || nc>=m) break;
                if(room[nr][nc] == -1){
                    result[cr][cc]=0;
                    return;
                }
                result[cr][cc] = result[nr][nc];
                cr = nr;
                cc = nc;
            }
        }
    }
}


