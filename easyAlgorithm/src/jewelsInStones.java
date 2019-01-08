import java.util.HashMap;
import java.util.Map;

/**
 * 771. 宝石与石头
 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。

 J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。

 示例 1:

 输入: J = "aA", S = "aAAbbbb"
 输出: 3
 示例 2:

 输入: J = "z", S = "ZZ"
 输出: 0
 注意:

 S 和 J 最多含有50个字母。
 J 中的字符不重复




 */
public class jewelsInStones {

    class Solution {

        //方法1
        public int numJewelsInStones(String J, String S) {

            char[] jew= J.toCharArray();
            char[] sto= S.toCharArray();
            int sum=0;
            for (char chj:jew){
                for (char chs:sto){

                    if (chj==chs){
                        sum++;
                    }
                }
            }

            return sum;
        }

        //方法2
        public int numJewelsInStones1(String J,String S){
            Map<Character,Integer> map= new HashMap<>();
            int sum=0;
            for(char chj:J.toCharArray()){
                map.put(chj,0);
            }
            for (char chs:S.toCharArray()){
                if (map.containsKey(chs)){
                    map.put(chs,map.get(chs)+1);
                }
            }
            for (Map.Entry<Character,Integer> mm:map.entrySet()){
              sum+=mm.getValue();
            }
            return sum;
        }
    }

    public static void main(String[] args){
        Solution s = new jewelsInStones().new Solution();
        int sum =s.numJewelsInStones1("aA","aAAbbbb");
        System.out.println("======sum:"+sum+"=======");
    }
}
