import java.util.ArrayList;
import java.util.List;

/**
 * 728. 自除数
 * 自除数 是指可以被它包含的每一位数除尽的数。

 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。

 还有，自除数不允许包含 0 。

 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 */
public class SelfDividingNum {

    public List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> list= new ArrayList<>();
        for (int i=left;i<=right;i++){
            if (selfdividing(i)){
                list.add(i);
            }
        }

        return list;
    }

    public boolean selfdividing(int n){
        for (char ch:String.valueOf(n).toCharArray()){
            if (ch=='0' || n%(ch-'0')>0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        SelfDividingNum selfDividingNum = new SelfDividingNum();
        int left=1,right=22;
        List<Integer> list=selfDividingNum.selfDividingNumbers(left,right);
        for (Integer a:list){
            System.out.println(a);
        }
    }
}
