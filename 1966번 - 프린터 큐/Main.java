/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1966                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1966                           #+#        #+#      #+#    */
/*   Solved: 2025/08/15 11:56:15 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
class Document{
    int priority;
    int order;
    public Document(int priority, int order){
        this.priority = priority;
        this.order = order;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        for(int i=0; i<num; i++){
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            String[] str2 = br.readLine().split(" ");
            Deque<Document> queue = new ArrayDeque<>();
            for(int j=0; j<n;j++){
                queue.offer(new Document(Integer.parseInt(str2[j]),j));
            }
            int count = 0;
            while(!queue.isEmpty()){
                Document current = queue.poll();
                boolean isHigherPriority = queue.stream().anyMatch(doc -> doc.priority > current.priority); //for-each도 가능
                if(isHigherPriority){
                    queue.offer(current);
                }else{
                    Document res = current;
                    count++;
                    if(res.order==m){
                        sb.append(count).append('\n');
                    }
                }
            }

        }
        System.out.print(sb);
        br.close();
    }
}

