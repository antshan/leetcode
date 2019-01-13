import java.util.HashSet;
import java.util.Set;

/**
 * 73 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 */
public class SetMatrixZeroes {

    //1
    public void setZeroes(int[][] matrix) {
        int rnums= matrix.length;
        int cnums= matrix[0].length;
        Set<Integer> rows= new HashSet<>();
        Set<Integer> colums= new HashSet<>();
        for (int i=0;i<rnums;i++){
            for (int j=0;j<cnums;j++){
                if (matrix[i][j]==0){
                    rows.add(i);
                    colums.add(j);
                }
            }
        }

        for (int i=0;i<rnums;i++){
            for (int j=0;j<cnums;j++){
                if (rows.contains(i) || colums.contains(j)){
                    matrix[i][j]=0;
                }
            }
        }
    }

    //2
    public void setMatrixZeroes1(int[][] matrix){
        int rnums= matrix.length;
        int cnums= matrix[0].length;

        boolean[] rflag= new boolean[rnums];
        boolean[] cflag= new boolean[cnums];

        for (int i=0;i<rnums;i++){
            for (int j=0;j<cnums;j++){
                if (matrix[i][j]==0){
                    rflag[i]=true;
                    cflag[j]=true;
                }
            }
        }

        for (int i=0;i<rnums;i++){
            if (rflag[i]){
                for (int j=0;j<cnums;j++){
                    matrix[i][j]=0;
                }
            }
        }

        for (int i=0;i<cnums;i++){
            if (cflag[i]){
                for (int j=0;j<rnums;j++){
                    matrix[j][i]=0;
                }
            }
        }
    }
}
