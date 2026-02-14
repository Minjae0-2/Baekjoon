/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 1991                              :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/1991                           #+#        #+#      #+#    */
/*   Solved: 2026/02/14 19:29:56 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static StringBuilder sb2;
    static StringBuilder sb3;
    static int[][] tree;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        sb2 = new StringBuilder();
        sb3 = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        tree = new int[26][2];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int parent = st.nextToken().charAt(0)-'A';
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree[parent][0] = (left=='.')?-1:left-'A';
            tree[parent][1] = (right=='.')?-1:right-'A';
        }
        preorder(0);
        inorder(0);
        postorder(0);
        System.out.println(sb);
        System.out.println(sb2);
        System.out.println(sb3);
    }
    public static void preorder(int current) {
        if (current == -1) return;
        sb.append((char)(current+'A'));
        preorder(tree[current][0]);
        preorder(tree[current][1]);
    }
    public static void inorder(int current) {
        if (current == -1) return;
        inorder(tree[current][0]);
        sb2.append((char)(current+'A'));
        inorder(tree[current][1]);
    }
    public static void postorder(int current) {
        if (current == -1) return;
        postorder(tree[current][0]);
        postorder(tree[current][1]);
        sb3.append((char)(current+'A'));
    }
}