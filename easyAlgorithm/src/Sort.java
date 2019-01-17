/**
 * Created by shanwei on 2019/1/16.
 */
public class Sort {

    //快速排序 时间复杂度O(nlogn)
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


    // 选择排序 时间复杂度O(n^2)
    public void selectSort(int[] arr){

        for (int i=0;i<arr.length;i++){
            int min=i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<arr[min]) min= j;
            }
            if (i!=min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    //冒泡排序 时间复杂度O(n^2)
    public void bubblesort(int[] arr){

        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length-1;j++){
                if (arr[j]>arr[j+1]){
                    int temp= arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1]= temp;
                }
            }
        }
    }

    public static void main(String[] args){

        Sort sort= new Sort();
        int[] arr= {7,4,3,1,8,6,0,2,5};
//        int[] res= sort.quiksort(arr);
//        sort.selectSort(arr);
        sort.bubblesort(arr);
        for (int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }
    }
}
