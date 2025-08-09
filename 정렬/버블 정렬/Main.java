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
        boolean swap;
        for(int i=0;i<n;i++) {
            swap=false;
            for(int j=0; j<n-i-1;j++){
              if(arr[j] < arr[j+1]){
                  int temp = arr[j];
                  arr[j]=arr[j+1];
                  arr[j+1]=temp;
                  swap=true;
              }
            }
            if(!swap){
                break;
            }
        }
        for(int i=0;i<n;i++){
            sb.append(arr[i]).append(' ');
        }

        System.out.print(sb);
        br.close();

    }
}
