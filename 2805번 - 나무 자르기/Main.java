/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2805                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2805                           #+#        #+#      #+#    */
/*   Solved: 2026/02/03 20:59:59 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
        long arr[] = new long[n];
        long max = 0;
        for(int i=0; i<n; i++){
            arr[i] = Long.parseLong(st2.nextToken());
            if(max < arr[i]) max = arr[i];
        }
        long start = 0;
        long end = max;
        long res = 0;
        while(start<=end){
            long mid = (start+end)/2;
            long sum = 0;
            for(int i=0; i<n; i++){
                if(arr[i]<mid) continue;
                else sum += (arr[i]-mid);
            }
            if(sum >= m){
                res = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        System.out.println(res);

    }
}