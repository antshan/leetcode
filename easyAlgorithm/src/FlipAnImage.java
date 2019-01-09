/**
 * 832 翻转图像
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。

 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。

 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 */
public class FlipAnImage {

    //1
    public int[][] flipAndInvertImage(int[][] A) {

        int[][] B = new int[A.length][A[0].length];
        for (int i=0;i<A.length;i++){
            for (int j=0;j<A[i].length;j++){
                B[i][j]=A[i][A[i].length-j-1];
            }
        }
        for (int i=0;i<B.length;i++){
            for (int j=0;j<B[i].length;j++){
                if (B[i][j]==0){
                    B[i][j]=1;
                }else {
                    B[i][j]=0;
                }
            }
        }

        return B;
    }

    //2
    public int[][] flipAndInvertImage1(int[][] A){
        int C=A[0].length;
        for (int[] row:A) {
            for (int i = 0; i < (C+1) / 2; i++) {
                int temp=row[i]^1;
                row[i] = row[C-i-1]^1;
                row[C-i-1] =temp;
            }
        }
        return A;
    }

    public static void main(String[] args){
        FlipAnImage flipAnImage = new FlipAnImage();
        int[][] A = new int[][]{{1,1,0},{1,0,1},{0,0,0}};
        int[][] B = flipAnImage.flipAndInvertImage1(A);
        for (int i=0;i<B.length;i++){
            for (int j=0;j<B[i].length;j++){
                System.out.println(B[i][j]);
            }
        }
    }
}
