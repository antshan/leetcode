/**
 * 561 数组拆分
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 */
public class ArrayPartI {
    public int arrayPairSum(int[] nums) {

        int sum =0;
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<nums.length-1;j++){
                if (nums[j]>nums[j+1]){
                    int temp =nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }

        for (int i=0;i<nums.length;i=i+2){
            sum +=nums[i];
        }
        return sum;
    }

    public static void main(String[] args){
        ArrayPartI arrayPartI= new ArrayPartI();
        int[] nums= new int[]{1,4,3,2};
        int res = arrayPartI.arrayPairSum(nums);
        System.out.println("=====res:"+res+"=====");
    }
}
