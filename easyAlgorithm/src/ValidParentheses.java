import java.util.Stack;

/**
 * 20 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

 有效字符串需满足：

 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。
 */
public class ValidParentheses {

    public boolean isValid(String s) {

        if (s==null || s.length()==0) return true;
        Stack<Character> stack = new Stack<>();
        for(Character ch:s.toCharArray()){
            if (ch=='('){
                stack.push(')');
            }else if (ch=='['){
                stack.push(']');
            }else if (ch=='{'){
                stack.push('}');
            }else {
                if (stack.isEmpty() || stack.pop()!= ch){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args){
        ValidParentheses validParentheses = new ValidParentheses();
        String s="[({)}]";
        boolean res =validParentheses.isValid(s);
        System.out.println("=====res:"+res+"======");
    }
}
