import java.util.HashSet;

/**
 * 804. 唯一摩尔斯密码词
 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。

 为了方便，所有26个英文字母对应摩尔斯密码表如下：

 [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + "-..." + ".-"字符串的结合)。我们将这样一个连接过程称作单词翻译。

 返回我们可以获得所有词不同单词翻译的数量。
 */
public class UiqueMorseCode {
    public int uniqueMorseRepresentations(String[] words) {
        String[] code=new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",
                ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-",
                "...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();
        for (String s:words){
            String res= new String();
            for (char cha:s.toCharArray()){
                int index = cha-'a';
                res+= code[index];
            }
            set.add(res);
        }

        return set.size();
    }

    public static void main(String[] args){
       UiqueMorseCode uiqueMorseCode = new UiqueMorseCode();
       String[] s = new String[]{"gin", "zen", "gig", "msg"};
       int res = uiqueMorseCode.uniqueMorseRepresentations(s);
       System.out.println("======res:"+res+"=====");
    }
}
