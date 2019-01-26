/**
 * 二分法
 */
public class BinarySearch {

    //非递归
    public synchronized int binarysearch(int[] arr,int key){

        int low= 0;
        int high= arr.length-1;
        while (low<=high){
            int mid= (low+high)/2;
            if (key<arr[mid]){
                high= mid-1;
            }else if (key>arr[mid]){
                low=mid+1;
            }else {
                return mid;
            }
        }

        return -1;
    }

    //递归
    public int binarysearch1(int[] arr,int key,int low,int high){
        int mid= (high-low)/2+low;
        if (arr[mid]==key){
            return mid;
        }
        if (low>=high){
            return -1;
        }else if (key>arr[mid]){
            return binarysearch1(arr,key,mid+1,high);
        }else if (key<arr[mid]){
            return binarysearch1(arr,key,low,mid-1);
        }

        return -1;
    }
    public static void main(String[] args){

        BinarySearch binarySearch= new BinarySearch();
        int[] arr={1,3,5,6,8,9};
        int key=10;
//        int res= binarySearch.binarysearch(arr,key);
        int res= binarySearch.binarysearch1(arr,key,0,arr.length-1) ;
        System.out.println("======res:"+res+"======");
    }
}
