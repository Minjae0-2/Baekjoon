/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11054                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11054                          #+#        #+#      #+#    */
/*   Solved: 2026/02/24 02:05:32 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1,1);
        Arrays.fill(dp2,1);
        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                if (arr[i] > arr[j]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
        }
        for(int i=n-1; i>=0; i--) {
            for(int j=n-1; j>i; j--) {
                if (arr[i] > arr[j]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }

        int max = 0;
        for(int i=0; i<n; i++) {
            max = Math.max(dp1[i]+dp2[i]-1,max);
        }
        System.out.println(max);
        }
    }

