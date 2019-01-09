import java.util.ArrayList;
import java.util.List;

/**
 * 905. 按奇偶排序数组
 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。

 你可以返回满足此条件的任何数组作为答案。



 示例：

 输入：[3,1,2,4]
 输出：[2,4,3,1]
 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 */
public class SortArrayByParity {

    //1
    public int[] sortArrayByParity(int[] A) {

        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        for (int a:A){
            if (a%2==0){
                list.add(a);
            }else {
                list1.add(a);
            }
        }
       int[] b = new int[A.length];
        for (int i=0;i<list.size();i++){
            b[i]=list.get(i);
        }
        for (int i=list.size(),j=0;i<b.length;i++,j++){
            b[i]=list1.get(j);
        }
        return b;
    }

    //2
    public int[] sortArrayByParity1(int[] A){
        int[] B = new int[A.length];
        int j=0;
        for (int i=0;i<A.length;i++){
            if (A[i]%2 == 0){
                B[j++]=A[i];
            }
        }
        for (int i=0;i<A.length;i++){
            if (A[i]%2 != 0){
                B[j++]=A[i];
            }
        }

        return B;
    }

    public static void main(String[] args){
        SortArrayByParity sortArrayByParity = new SortArrayByParity();
        int[] A = new int[]{1,2,3,4,5,6,7,8,9};
        int[] B =sortArrayByParity.sortArrayByParity1(A);
        for (int b:B){
            System.out.println(b);
        }

    }
}
