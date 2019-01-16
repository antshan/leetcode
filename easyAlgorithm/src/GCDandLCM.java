/**
 * p,q的最大公约数和最小公倍数
 */
public class GCDandLCM {

    public int gcd(int p,int q){
        if (q==0) return p;

        return gcd(q,p%q);
    }

    public int lcm(int p,int q){
        return p*q/gcd(p,q);
    }

    public static void main(String[] args){
        GCDandLCM gcDandLCM= new GCDandLCM();
        int res= gcDandLCM.gcd(319,377);
        int res1= gcDandLCM.lcm(319,377);
        System.out.println("======res:"+res1+"======");
    }
}
