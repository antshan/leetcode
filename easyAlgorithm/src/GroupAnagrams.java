import java.util.*;

/**
 * 49 字符串异位词分组
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res= new ArrayList<>();
        if (strs==null || strs.length==0){
            return res;
        }
        Map<String,Integer> map = new HashMap<>();
        for (String str:strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            if (map.containsKey(s)){
                List<String> list= res.get(map.get(s));
                list.add(str);
            }else {
                List<String> list= new ArrayList<>();
                list.add(str);
                map.put(s,res.size());
                res.add(list);
            }
        }
        return res;
    }
}
