import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lengthOfLongestSubstring {

    class Solution {

        //第一种方案，穷举所有的子字符串然后得到最大的无重复子字符串
        public int lengthOfLongestSubstring1(String s) {
            int ans=0;
            for (int i=0;i<s.length();i++)
                for(int j=i+1;j<=s.length();j++)
                    if (alluique(s,i,j)) {
                        ans = Math.max(ans, j - i );
                    }
           return ans;
        }

        public boolean alluique(String s, int start,int end){
            Set<Character> set= new HashSet<>();
            for (int i=start;i<end;i++){
                char c =s.charAt(i);
                if (set.contains(c))return false;
                set.add(c);
            }
            return true;
        }


        //第二种方案，滑动窗口[i,j),先将j从0开始遍历，再将i从0开始遍历
        public int lengthOfLongestSubstring2(String s){
            int ans=0;
            int n=s.length(),i=0,j=0;
            Set<Character> set = new HashSet<>();
            while (i<n && j<n){
                if (!set.contains(s.charAt(j))){
                    set.add(s.charAt(j++));
                    ans=Math.max(ans,j-i);
                }else {
                    set.remove(i++);
                }
            }
            return ans;
        }

        //第三种方案，一次遍历整个字符串就行，先将j从0开始遍历，再将i从j'开始，j'表示j位置的字符上一次出现的位置
        public int lengthOfLongestSubstring3(String s){
            int ans=0;
            int n =s.length();
            Map<Character,Integer> map = new HashMap<>();
            for(int i=0,j=0;j<n;j++){
                if (map.containsKey(s.charAt(j))){
                    i= Math.max(map.get(s.charAt(j)),i);
                }
                ans= Math.max(ans,j-i+1);
                map.put(s.charAt(j),j+1);
            }
            return ans;
        }

    }


    public static void main(String[] args){

        lengthOfLongestSubstring.Solution s = new lengthOfLongestSubstring().new Solution();
        String str="abcdefg";
        int a = s.lengthOfLongestSubstring1(str);
        int b = s.lengthOfLongestSubstring2(str);
        int c = s.lengthOfLongestSubstring3(str);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
