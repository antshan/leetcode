/**
 * 461 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 */
public class HanmingDistance {

    public int hammingDistance(int x, int y) {
        int z = x^y;//求异或
        int count = 0;
        while(z!=0){//求1的个数
            ++ count;
            z &= z-1;
        }

        return count;
    }
}
