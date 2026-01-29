/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 11399                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/11399                          #+#        #+#      #+#    */
/*   Solved: 2026/01/27 16:42:13 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // Arrays.sort는 primitive 배열은 dualpivot sort로 O(n제곱)이 최악 O(nlogn)이 평균이고, 추가로 드는 메모리 비용 없음.
        // primitive 배열은 Arrays.sort(배열) 만약 내림차순을 쓰려면, for문 돌려서 위치 바꾸기 n/2까지 또는 boxing해서 객체로 바꿔서 arrays.sort(arr,Collections.reverseOrder()) 쓰기 (성능 권장 x)
        // 객체는 timsort로 O(nlogn)이 최악 O(n)이 최선 하지만 메모리를 추가로 사용.
        Arrays.sort(arr);
        int sum=0;
        for(int i=0; i<n; i++){
            sum+= arr[i]*(n-i);
        }
        System.out.println(sum);
    }
}