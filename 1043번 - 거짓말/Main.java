/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1043                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1043                           #+#        #+#      #+#    */
/*   Solved: 2026/02/16 21:44:22 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int truthN = Integer.parseInt(st2.nextToken());
        int[] truthArr = null;
        if(truthN !=0){
            truthArr = new int[truthN];
            for(int i=0; i<truthN; i++){
                truthArr[i] = Integer.parseInt(st2.nextToken());
            }
        }else{
            System.out.println(m);
            return;
        }

        parent = new int[n+1];
        for(int i=1; i<=n; i++) parent[i] = i;
        
        for(int i=1; i< truthN; i++){
            union(truthArr[0],truthArr[i]);
        }

        List<Integer>[] partyToPerson = new ArrayList[m];

        for(int i=0; i<m; i++){
            partyToPerson[i] = new ArrayList<>();
            StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
            int partySize = Integer.parseInt(st3.nextToken());
            int firstPerson = Integer.parseInt(st3.nextToken());
            partyToPerson[i].add(firstPerson);
            for(int j=1; j< partySize; j++) {
                int p = Integer.parseInt(st3.nextToken());
                partyToPerson[i].add(p);
                union(firstPerson,p);
            }
        }


        int count =0;
        for(int i=0; i<m; i++){
            boolean tellFalse = true;
            for(int person : partyToPerson[i]){
                if(find(truthArr[0]) == find(person)) {
                    tellFalse = false;
                    break;
                }
            }
            if(tellFalse){
                count++;
            }

        }
        System.out.println(count);

    }
    static int find(int i){
        if(parent[i]==i) return parent[i];
        return parent[i]=find(parent[i]);
    }
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            if(x<y) parent[y] = x;
            else parent[x] = y;
        }
    }
}
/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int truthN = Integer.parseInt(st2.nextToken());
        int[] truthArr = null;
        if(truthN !=0){
            truthArr = new int[truthN];
            for(int i=0; i<truthN; i++){
                truthArr[i] = Integer.parseInt(st2.nextToken());
            }
        }

        List<Integer>[] partyToPerson = new ArrayList[m];
        List<Integer>[] personToParty = new ArrayList[n+1];
        for(int i=0; i<=n; i++) {
            personToParty[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            partyToPerson[i] = new ArrayList<>();
            StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st3.nextToken());
            for(int j=0; j<k; j++) {
                int p = Integer.parseInt(st3.nextToken());
                partyToPerson[i].add(p);
                personToParty[p].add(i);
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        if(truthN !=0) {
            for (int i : truthArr) {
                queue.add(i);
                visited[i] = true;
            }
        }else{
            System.out.println(m);
            return;
        }

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int p: personToParty[cur]){
                for(int person: partyToPerson[p]){
                    if(!visited[person]) {
                        visited[person] = true;
                        queue.add(person);
                    }
                }
            }
        }
        int count =0;
        for(int i=0; i<m; i++){
            boolean tellFalse = true;
            for(int person : partyToPerson[i]){
                if(visited[person]) {
                    tellFalse = false;
                    break;
                }
            }
            if(tellFalse){
                count++;
            }

        }
        System.out.println(count);

    }
}*/