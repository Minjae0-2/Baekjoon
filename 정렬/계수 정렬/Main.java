import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
       int[] count = new int[400];
        for(int i=0; i<n;i++){
            count[arr[i]]++;
        }
        int index=0;
        for(int i=0; i<400;i++){
            while(count[i]>0){
                arr[index] = i;
                index++;
                count[i]--;
            }
        }

        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.print(sb);
    }
}

