import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 961重复N次的元素
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。

 返回重复了 N 次的那个元素。
 */
public class NRepeatElement {

    //方法1
    public int repeatedNTimes(int[] A) {

        Map<Integer,Integer> map = new HashMap<>();
        for(int a:A){
            if (map.containsKey(a)){
                map.put(a,map.get(a)+1);
            }else {
                map.put(a,1);
            }
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (entry.getValue().equals(A.length/2)){
                return entry.getKey();
            }
        }
        return -1;
    }

    //方法2
    public int repeatedNTimes1(int[] A){

        Set<Integer> set = new HashSet<>();
        for (int a:A){
            if (set.contains(a))
                return a;
            set.add(a);
        }
        return -1;
    }

    public static void main(String[] args){
        NRepeatElement nRepeatElement = new NRepeatElement();
        int[] A = new int[]{5,1,5,2,5,3,5,4};
        int res = nRepeatElement.repeatedNTimes(A);
        System.out.println("=====res:"+res+"=====");
    }
}
