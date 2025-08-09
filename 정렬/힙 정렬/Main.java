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
        heapsort(arr);

        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.print(sb);
    }
    public static void heapsort(int[] arr) {
        int n = arr.length;
        for (int i = n/2-1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for(int i= n-1; i>0; i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr,i,0);
        }
    }
    public static void heapify(int[] arr, int n, int i){
        int top = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if(left<n && arr[left]>arr[top]){
            top=left;
        }

        if(right<n && arr[right]>arr[top]){
            top=right;
        }

        if(top != i){
            int temp = arr[i];
            arr[i] = arr[top];
            arr[top] = temp;

            heapify(arr,n,top);
        }

    }
}

