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
        quicksort(arr,0,arr.length-1);

        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.print(sb);
    }
    public static void quicksort(int[] arr,int start,int end){
        if(start >= end){
            return;
        }

        int pivot = arr[(start+end)/2];
        int i = start; //pivot보다 같거나 큰것
        int j = end; //pivot보다 작은것
        while(i<=j){
            while(i<=end && arr[i]<pivot){
                i++;
            }
            while(j>=start && arr[j]>pivot){
                j--;
            }
            if(i<=j){
                swap(arr,i,j);
                i++;
                j--;
            }
        }

        if(start<j){
            quicksort(arr,start,j);
        }
        if(i<end) {
            quicksort(arr, i, end);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}

