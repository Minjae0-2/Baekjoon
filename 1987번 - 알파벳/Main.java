/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1987                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1987                           #+#        #+#      #+#    */
/*   Solved: 2026/02/20 17:43:22 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static int r;
    static int c;
    static int max = 1;
    static int[] addR = {0,+1,0,-1};
    static int[] addC = {+1,0,-1,0};
    static char[][] board;
    static boolean[] alphabet;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[r][c];
        for(int i=0; i<r; i++) {
            board[i] = br.readLine().toCharArray();
        }
        // 20*20 =400 -> dfs로 풀어도 됨
        alphabet = new boolean[26]; // -'A'해서 계산
        alphabet[board[0][0]-'A']= true;
        dfs(0,0,1);
        System.out.println(max);
    }

    static void dfs(int row, int col, int count){
        max = Math.max(max,count);
        for(int i=0; i<4; i++){
            int nextR = row+addR[i];
            int nextC = col+addC[i];
            if(nextR>=r || nextC>=c || nextR<0|| nextC<0 || alphabet[board[nextR][nextC]-'A'] ) continue;
            alphabet[board[nextR][nextC]-'A']= true;
            dfs(nextR,nextC,count+1);
            alphabet[board[nextR][nextC]-'A']= false;
        }
    }
}
