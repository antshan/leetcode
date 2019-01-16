/**
 * Created by shanwei on 2019/1/16.
 */
public class Sort {

    public int[] quiksort(int[] arr){
        return qsort(arr,0,arr.length-1);
    }

    public int[] qsort(int[] arr,int low,int high){
        if (low<high){
            int pivot= pationsort(arr,low,high);
            qsort(arr,low,pivot-1);
            qsort(arr,pivot+1,high);
        }
        return arr;
    }

    public int pationsort(int[] arr,int low, int high){
        int pivot =arr[low];
        while (low<high){
            while (low<high && arr[high]>=pivot) --high;
            arr[low]=arr[high];
            while (low<high && arr[low]<=pivot) ++low;
            arr[high]=arr[low];
        }

        arr[low]=pivot;
        return low;
    }


    public static void main(String[] args){

        Sort sort= new Sort();
        int[] arr= {7,4,3,1,8,6,0,2,5};
        int[] res= sort.quiksort(arr);
        for (int i=0;i<arr.length;i++){
            System.out.println(res[i]);
        }
    }
}
