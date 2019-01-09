/**
 * 709: 大写转换小写
 */
public class toLowCase {

    public String toLowerCase(String str) {

        char[] ch =str.toCharArray();
        for (int i=0;i<ch.length;i++){
            if (ch[i]>='A' && ch[i]<='Z'){
                ch[i]+=32;
            }
        }
        return new String(ch);
    }

    public static void main(String[] args){
        toLowCase toLowCase =new toLowCase();
        String s = "LOVELY";
        String res = toLowCase.toLowerCase(s);
        System.out.println(res);
    }
}
