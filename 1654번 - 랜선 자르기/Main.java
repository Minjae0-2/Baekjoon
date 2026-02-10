/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1654                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1654                           #+#        #+#      #+#    */
/*   Solved: 2026/02/03 15:45:57 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[k];
        long max = 0;
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(max <= arr[i]) max= arr[i];
        }
        // 이분탐색으로 내려가자
        // 이분탐색으로 내려가자
        long sumCount = 0;

        long left = 1;
        long right = max;
        long res = 0;
        while(left <= right) {
            long mid = (left+right)/2;
            sumCount = 0;
            for (int i = 0; i < k; i++) {
                sumCount += arr[i] / mid;
            }
            if(sumCount >= n){
                res = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(res);
    }
}