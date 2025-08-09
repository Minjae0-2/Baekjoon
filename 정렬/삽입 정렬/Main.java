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

        InsertionSort(arr);

        for(int i=0;i<n;i++){
            sb.append(arr[i]).append(' ');
        }

        System.out.print(sb);
        br.close();

    }
    public static void InsertionSort (int[] arr){
        int len= arr.length;
        for(int i=1; i<len;i++){
            int j=i-1;
            int temp=arr[i];
           while(j>=0 && arr[j] < temp){
               arr[j+1]=arr[j];
               j--;
           }
           arr[j+1]=temp;

        }
    }
}
