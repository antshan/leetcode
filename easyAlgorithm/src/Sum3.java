import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15 3Sum 找出三个数的和为0
 */
public class Sum3 {

    //1
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList= new ArrayList<>();

        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;i++){
            for (int j=i+1;j<nums.length-1;j++){
                for (int k=j+1;k<nums.length;k++){
                    if (nums[i]+nums[j]+nums[k]==0){
                        List<Integer> list = new ArrayList<>();

                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        if (!resultList.contains(list)) {
                            resultList.add(list);
                        }
                    }
                }
            }
        }

        return resultList;
    }

    //2
    public List<List<Integer>> threeSum1(int[] nums){
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;i++){
            if (i>0 && nums[i]==nums[i-1]) continue;
            int low= i+1,high = nums.length-1,sum= 0-nums[i];
            while (low<high){
                if (nums[low]+nums[high]== sum){
                    resultList.add(Arrays.asList(nums[i],nums[low],nums[high]));
                    while (low<high && nums[low]==nums[low+1])low++;
                    while (low<high && nums[high]== nums[high-1]) high--;
                    low++;
                    high--;
                }else if (nums[low]+nums[high]>sum){
                    high--;
                }else
                    low++;
            }
        }
        return resultList;
    }

    public static void main(String[] args){
        Sum3 sum3 = new Sum3();
        int[] nums= new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = sum3.threeSum1(nums);
        System.out.println(result);
    }
}
