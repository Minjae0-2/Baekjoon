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
       mergesort(arr,0,arr.length-1);
        for(int i=0;i<n;i++){
            sb.append(arr[i]).append(' ');
        }

        System.out.print(sb);
        br.close();

    }
    public static void mergesort(int[] arr, int start, int end){
        if(start<end) {
            int mid= (start+end)/2;
            mergesort(arr,start,mid);
            mergesort(arr,mid+1,end);
            merge(arr,start,mid,end);
       }
    }
    public static void merge(int[] arr, int start, int mid, int end){
        // 0 0 1
        // 1 2 3
        // 0 1 3
        int[] temp = new int[end-start+1];
        int j=mid+1;
        int i=start;
        int k=0;
        while(i<=mid && j<=end) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[j++];
            } else {
                temp[k++] = arr[i++];
            }
        }

        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=end){
            temp[k++]=arr[j++];
        }

        for(int l=0 ;l<temp.length;l++){
            arr[start+l]=temp[l];
        }

        }
}
