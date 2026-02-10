/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 18870                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/18870                          #+#        #+#      #+#    */
/*   Solved: 2026/02/04 14:58:02 by lawpea38      ###          ###   ##.kr    */
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

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        int[] sorted = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sorted);

        // 중복 제거 1 1 2 2 3 3 뒤에는 쓰레기 남지만 이진탐색으로 안볼거
        int j = 0;
        for(int i = 1; i<n; i++){
            if(sorted[i] != sorted[j]){
                j++;
                sorted[j] =  sorted[i];
            }
        }

        for(int i=0; i<n; i++) {
            int rank = Arrays.binarySearch(sorted,0,j+1,arr[i]);
            sb.append(rank).append(' ');
        }

        System.out.println(sb);
    }
}