import java.util.ArrayList;
import java.util.List;

/**
 * 22 生成括号
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res= new ArrayList<>();
        if (n==0) return res;
        helper(res,"",n,n);
        return res;
    }

    public void helper(List<String> res,String s,int left,int right){
        if (left>right){
            return;
        }
        if (left==0 && right==0){
            res.add(s);
            return;
        }
        if (left>0){
            helper(res,s+"(",left-1,right);
        }
        if (right>0){
            helper(res,s+")",left,right-1);
        }
    }

    public static void main(String[] args){
        GenerateParentheses generateParentheses= new GenerateParentheses();
        List<String> res= generateParentheses.generateParenthesis(2);
        System.out.println(res);
    }
}
