import java.util.ArrayList;
import java.util.List;

/**
 * 46 全排列
 *
 * Input [1,2,3]
 *
 * OutPut:
 * {
 *     [1,2,3]
 *     [1,3,2]
 *     [2,1,3]
 *     [2,3,1]
 *     [3,1,2]
 *     [3,2,1]
 * }
 */
public class Permutations {
    //1
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> res= new ArrayList<>();
       if (nums==null || nums.length==0) return res;
       helper(res,new ArrayList<>(),nums);
       return res;
    }

    public void helper(List<List<Integer>> res,List<Integer> list,int[] nums){
        if (list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            helper(res,list,nums);
            list.remove(list.size()-1);
        }
    }

    //2
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        if (nums==null || nums.length==0) return res;
        helper1(res,0,nums);
        return res;
    }

    public void helper1(List<List<Integer>> res,int start,int[] nums){

        if (start==nums.length){
            List<Integer> list= new ArrayList<>();
            for (int num:nums){
                list.add(num);
            }
            res.add(list);
        }
        for (int i=start;i<nums.length;i++){
            swap(nums,start,i);
            helper1(res,start+1,nums);
            swap(nums,start,i);
        }
    }

    public void swap(int[] nums,int i,int j){
        int temp= nums[i];
        nums[i]= nums[j];
        nums[j]= temp;
    }

    public static void main(String[] args){
        Permutations permutations= new Permutations();
        int[] nums= {1,2,3};
        List<List<Integer>> res= permutations.permute(nums);
    }
}
