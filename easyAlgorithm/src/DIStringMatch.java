/**
 * 942. 增减字符串匹配
 * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。

 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：

 如果 S[i] == "I"，那么 A[i] < A[i+1]
 如果 S[i] == "D"，那么 A[i] > A[i+1]
 */
public class DIStringMatch {

    public int[] diStringMatch(String S) {
        int N = S.length();
        int low=0,high=N;
        int[] res= new int[N+1];
        for (int i =0;i<S.length();i++){
            if (S.charAt(i)=='I'){
                res[i]=low++;
            }else {
                res[i]=high--;
            }
        }

        res[N]=low;
        return res;
    }

    public static void main(String[] args){
        DIStringMatch diStringMatch = new DIStringMatch();
        String s= "DDDDI";
       int[] res= diStringMatch.diStringMatch(s);
       for (int i=0;i<res.length;i++)
           System.out.println(res[i]);
    }

}
