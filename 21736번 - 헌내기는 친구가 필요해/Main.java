/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 21736                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/21736                          #+#        #+#      #+#    */
/*   Solved: 2026/02/04 15:38:42 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n;
    static int m;
    static char[][] campus;
    static int count;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        campus = new char[n][m];
        int myPosCol = 0;
        int myPosRow = 0;
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                campus[i][j] = str.charAt(j);
                if(campus[i][j] == 'I') {
                    myPosRow = i;
                    myPosCol = j;
                }
            }
        }
        // BFS 큐로
        count = 0;
        visited = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {myPosRow, myPosCol});
        visited[myPosRow][myPosCol] = true;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            for(int i=0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >=0 && nr<n && nc>=0 && nc<m&& campus[nr][nc]!='X'&& !visited[nr][nc]){
                    if(campus[nr][nc]=='P'){
                        count++;
                    }
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr,nc});
                }
            }

        }

        if(count==0){
            System.out.println("TT");
        }
        else {
            System.out.println(count);
        }
    }
}
/* 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n;
    static int m;
    static char[][] campus;
    static int count;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        campus = new char[n][m];
        int myPosCol = 0;
        int myPosRow = 0;
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                campus[i][j] = str.charAt(j);
                if(campus[i][j] == 'I') {
                    myPosRow = i;
                    myPosCol = j;
                }
            }
        }
        // DFS 재귀로
        count = 0;
        visited = new boolean[n][m];
        divide(myPosRow,myPosCol);
        if(count==0){
            System.out.println("TT");
        }
        else {
            System.out.println(count);
        }
    }
    public static void divide(int row, int col){
        if(row<0 || col<0 || row>=n || col>=m|| visited[row][col]) return;
        int curState = campus[row][col];
        if(curState == 'X') return;
        if(curState == 'P') count++;
        visited[row][col] = true;
        divide(row-1,col);
        divide(row,col+1);
        divide(row+1,col);
        divide(row,col-1);
    }
}
    */