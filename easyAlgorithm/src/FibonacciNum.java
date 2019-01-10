/**
 * 509 斐波那契
 * F(N)=F(N-1)+F(N-2)
 */
public class FibonacciNum {

    public int fib(int N) {
        int res;
        if (N==0){
            res= 0;
        }else if (N==1){
            res= 1;
        }else {
            res= fib(N-1)+fib(N-2);
        }

        return res;
    }

}
