/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 2606                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/2606                           #+#        #+#      #+#    */
/*   Solved: 2026/01/29 18:09:04 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        //2차원 배열은 모든 값을 다 확인해야하므로(제거 불가) 인접리스트로 접근(이중 리스트)
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            list.get(n1).add(n2);
            list.get(n2).add(n1);
        }
        Queue<Integer> virusQueue = new LinkedList<>();
        boolean[] visited = new boolean[n+1]; // 중복 막기 위해서. 또는 hashSet써도 무방 but 느림
        int count = 0;

        virusQueue.add(1);
        visited[1] = true;
        while(!virusQueue.isEmpty()){
            int virus = virusQueue.poll();
              for(int t : list.get(virus)){
                if(!visited[t]){
                    virusQueue.add(t);
                    visited[t] = true;
                    count++;
                }
              }
        }
        System.out.println(count);

    }
}
