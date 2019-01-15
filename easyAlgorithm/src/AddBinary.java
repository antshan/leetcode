/**
 * 67 二进制相加
 */
public class AddBinary {

    public String addBinary(String a, String b) {

        int i= a.length()-1;
        int j= b.length()-1;
        int remainder= 0;
        StringBuilder sb= new StringBuilder();
        while (i>=0 || j>=0){
            int sum= remainder;
            if (i>=0) sum+=a.charAt(i--)-'0';
            if (j>=0) sum+=b.charAt(j--)-'0';

            sb.append(sum%2);
            remainder= sum/2;

        }

        if (remainder!=0){
            sb.append(remainder);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args){
        AddBinary addBinary= new AddBinary();
        String res= addBinary.addBinary("11","1");
        System.out.println("=====res:"+res+"=======");
    }
}
