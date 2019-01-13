/**
 * 70 爬楼梯
 */
public class ClimbStairs {

    //1
    public int climbStairs(int n) {

        if(n<=1) return 1;
        int oneStep=1,twoStep=1,res=0;
        for(int i=2;i<=n;i++){
            res= oneStep+twoStep;
            twoStep= oneStep;
            oneStep= res;
        }

        return res;
    }

    public int climbStairs1(int n){
        if (n<=2) {
            return n;
        }else {
            return climbStairs1(n-1)+climbStairs1(n-2);
        }

    }

    public static void main(String[] args){
        ClimbStairs climbStairs = new ClimbStairs();
        int n=5;
        int res = climbStairs.climbStairs1(n);
        System.out.println("=====res:"+res+"=====");
    }
}
