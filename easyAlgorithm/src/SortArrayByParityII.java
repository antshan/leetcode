/**
 * 922 奇数放在奇数位置，偶数放在偶数位置
 */
public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] A) {

        int[] res = new int[A.length];
        int i=0;
        for (int a:A){
            if (a%2==0){
                res[i]=a;
                i=i+2;
            }
        }

        i=1;
        for (int a:A){
            if (a%2==1){
                res[i]=a;
                i=i+2;
            }
        }

        return res;
    }

    public static void main(String[] args){
        SortArrayByParityII sortArrayByParityII = new SortArrayByParityII();
        int[] A= new int[]{1,2,3,4,5,6};
        int[] res=sortArrayByParityII.sortArrayByParityII(A);
        for (int a:res){
            System.out.println(a);
        }
    }
}
