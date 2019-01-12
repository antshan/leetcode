/**
 * 8 字符串转数字
 */
public class StringToInteger {

    public int myAtoi(String str) {

        char[] ch = str.toCharArray();
        if ("".equals(str)){
            return 0;
        }
        int sign = 1, base = 0, i = 0;
        while (i<ch.length && ch[i] == ' ') { i++; }
        if (i<ch.length && (ch[i] == '-' || ch[i] == '+')) {
            int boo= (ch[i++] == '-')?1:0;
            sign = 1 - 2 * boo;
        }
        while (i<ch.length && ch[i] >= '0' && ch[i] <= '9') {
            if (base >  Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && ch[i] - '0' > 7)) {
                if (sign == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            base  = 10 * base + (ch[i++] - '0');
        }
        return base * sign;
    }

    public int myAtoi1(String str) {

        char[] ch = str.toCharArray();
        if ("".equals(str)){
            return 0;
        }
        int sign = 1, i = 0;
        long base =0L;
        while (i<ch.length && ch[i] == ' ') { i++; }
        if (i<ch.length && (ch[i] == '-' || ch[i] == '+')) {
            int boo= (ch[i++] == '-')?1:0;
            sign = 1 - 2 * boo;
        }
        while (i<ch.length && ch[i] >= '0' && ch[i] <= '9') {
            base  = 10 * base + (ch[i++] - '0');
            if (sign==1 && base>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else if (sign==-1 && sign*base<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        return (int)base * sign;
    }

    public static void main(String[] args){
        StringToInteger stringToInteger = new StringToInteger();
        String s =" -42 ";
        int res= stringToInteger.myAtoi1(s);
        System.out.println("=======res:"+res+"=======");
    }
}
