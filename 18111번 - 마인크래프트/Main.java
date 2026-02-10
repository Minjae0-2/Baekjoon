/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 18111                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/18111                          #+#        #+#      #+#    */
/*   Solved: 2026/02/04 02:29:05 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static boolean[] visited;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int arr[][] = new int[n][m];
        for(int i=0; i<n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        int inventory;
        int time;
        int minTime = Integer.MAX_VALUE;
        int targetHeight=0;

        for(int h=0; h<= 256; h++){
            inventory = b;
            time = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++) {
                    // 파내기
                    if(arr[i][j]>h) {
                        inventory += (arr[i][j] - h);
                        time += (arr[i][j]-h)*2;
                    }
                    // 쌓기
                    if(arr[i][j]<h){
                        inventory -= ( h- arr[i][j]);
                        time += (h-arr[i][j])*1;
                    }
                }
            }
            if(inventory >= 0 && minTime>=time){
                minTime = time;
                targetHeight = h;
            }
        }
        System.out.println(minTime+" "+targetHeight);



    }
}