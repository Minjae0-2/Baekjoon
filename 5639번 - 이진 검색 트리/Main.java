/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 5639                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/5639                           #+#        #+#      #+#    */
/*   Solved: 2026/02/21 02:37:57 by lawpea38      ###          ###   ##.kr    */
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
        int root = Integer.parseInt(br.readLine());
        Node nodeRoot = new Node(root);
        String line;
        while((line= br.readLine())!=null){
            int curVal = Integer.parseInt(line);
            nodeRoot.insert(curVal);
        }
        postOrder(nodeRoot);
        System.out.println(sb);
    }
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
        void insert(int n){
            if(this.val > n){
                if(this.left == null){
                    this.left = new Node(n);
                }else{
                    this.left.insert(n);
                }
            }else{
                if(this.right == null){
                    this.right = new Node(n);
                }else{
                    this.right.insert(n);
                }
            }
        }
    }
    static void postOrder(Node node){
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.val).append('\n');
    }
}
