/* ************************************************************************** */
/*                                                                            */
/*                                                      :::    :::    :::     */
/*   Problem Number: 10809                             :+:    :+:      :+:    */
/*                                                    +:+    +:+        +:+   */
/*   By: lawpea38 <boj.kr/u/lawpea38>                +#+    +#+          +#+  */
/*                                                  +#+      +#+        +#+   */
/*   https://boj.kr/10809                          #+#        #+#      #+#    */
/*   Solved: 2025/07/24 22:52:32 by lawpea38      ###          ###   ##.kr    */
/*                                                                            */
/* ************************************************************************** */
/*
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr= new int[26];
        Arrays.fill(arr,-1);
        for(int i=0; i<str.length();i++) {
            int c = str.charAt(i)- 'a';
            if(arr[c]==-1) {
                arr[c] = i;
            }
        }
        for(int k=0; k<26; k++){
            System.out.print(arr[k]+" ");
        }
        }
    } */

    import java.io.IOException;
    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    
    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            StringBuilder sb= new StringBuilder();
            for(char c='a';c<='z';c++ ){
                sb.append(str.indexOf(c)).append(" ");
            }
            System.out.println(sb.toString().trim());
            }
        }
    