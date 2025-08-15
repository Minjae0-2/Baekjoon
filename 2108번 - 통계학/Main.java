/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2108                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2108                           #+#        #+#      #+#    */
/*   Solved: 2025/08/15 15:22:02 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr= new int[n];
        long sum= 0;
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum+=arr[i];
        }
        sb.append(Math.round((double)sum/n)).append('\n'); //산술평균

        Arrays.sort(arr);
        sb.append(arr[n/2]).append('\n'); //중앙값

        /* 최빈값 1solve 풀이 */
        Map<Integer,Integer> map = new HashMap<>();
        int preValue=0;
        boolean isDuplicated = false;
        int answer = 0;
        for(int num: arr){
            int value = map.getOrDefault(num,0);
                map.put(num, ++value);
                if(preValue<value) {
                    preValue = value;
                    answer=num;
                    isDuplicated=false;
                }else if(!isDuplicated && preValue==value){
                    answer=num;
                    isDuplicated=true;
                }
        }
        sb.append(answer).append('\n'); //최빈값
       
        /* 최빈값 범용적 풀이 */
        Map<Integer,Integer> map = new HashMap<>();
        int maxFrequency = 0;
        for(int num: arr){
                int currentValue =map.getOrDefault(num,0);
                map.put(num, ++currentValue);
                maxFrequency = Math.max(maxFrequency,currentValue);
        }
        List<Integer> list = new ArrayList<>();
        for(int key: map.keySet()){
            if(maxFrequency == map.get(key)) {
                list.add(key);
            }
        }

        Collections.sort(list);

        if(list.size()>1){
            sb.append(list.get(1)).append('\n'); //최빈값
        }else{
            sb.append(list.get(0)).append('\n'); //최빈값
        }

        sb.append(arr[n-1]-arr[0]).append('\n'); //범위

        System.out.print(sb);
        br.close();
    }
}

