import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int[] arr0 = new int[41];
        int[] arr1 = new int[41];
        arr0[0]= 1;
        arr0[1]= 0;
        arr1[0]= 0;
        arr1[1]= 1;
        // 캐싱!
        for(int j=2; j<=40; j++){
            arr0[j]= arr0[j-1] + arr0[j-2];
            arr1[j]= arr1[j-1] + arr1[j-2];
        }
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            sb.append(arr0[n]).append(" ").append(arr1[n]).append('\n');
        }
        System.out.print(sb);
    }
}