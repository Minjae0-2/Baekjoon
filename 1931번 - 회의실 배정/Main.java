/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1931                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1931                           #+#        #+#      #+#    */
/*   Solved: 2026/02/09 16:07:25 by lawpea38      ###          ###   ##.kr    */
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
        int[][] meeting = new int[n][2];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
             meeting[i][0] = Integer.parseInt(st.nextToken());
             meeting[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(meeting,(p,q) -> {
            if(p[1] != q[1]) {
                return Integer.compare(p[1],q[1]);
            }else{
                return Integer.compare(p[0],q[0]);
            }
        });

        int lastEndTime = -1;
        int count = 0;
        for(int i=0; i<n; i++){
            if(lastEndTime <= meeting[i][0]){
                lastEndTime = meeting[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}