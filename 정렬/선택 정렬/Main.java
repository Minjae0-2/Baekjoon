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
        for(int i=0;i<n;i++) {
            int maxIdx=i;
            for(int j=i+1; j<n;j++){
                if(arr[j]>arr[maxIdx]){
                    maxIdx=j;
                }
            }
                int temp=arr[i];
                arr[i]=arr[maxIdx];
                arr[maxIdx]=temp;
        }
        for(int i=0;i<n;i++){
            sb.append(arr[i]).append(' ');
        }

        System.out.print(sb);
        br.close();

    }
}
