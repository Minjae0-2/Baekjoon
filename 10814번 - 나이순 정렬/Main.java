/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 10814                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/10814                          #+#        #+#      #+#    */
/*   Solved: 2025/08/09 13:41:54 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
import jdk.jshell.PersistentSnippet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Person {
    int age;
    String name;
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr= new int[n];
        String[] str= new String[2];
        Person[] people = new Person[n];
        for(int i=0;i<n;i++){
           str = br.readLine().split(" ");
           people[i]=new Person();
           people[i].age=Integer.parseInt(str[0]);
           people[i].name=str[1];
        }

        Arrays.sort(people,(p1,p2) -> p1.age-p2.age);

        for(int i=0;i<arr.length;i++){
            sb.append(people[i].age).append(" ").append(people[i].name).append('\n');
        }
        System.out.print(sb);
    }
}

