/**
 * 最短路径问题
 */
public class ShortestPath {

    public int shortestPath(int[][] data){
        if (data==null || data.length==0) return 0;

        //第一列
        for (int i=1;i<data.length;i++){
            data[i][0]= data[i-1][0]+data[i][0];
        }

        //第一行
        for (int i=1;i<data[0].length;i++){
            data[0][i]= data[0][i-1]+data[0][i];
        }

        //其余区域
        for (int i=1;i<data.length;i++){
            for (int j=1;j<data[0].length;j++){
                if (data[i][j-1]<data[i-1][j]){
                    data[i][j]= data[i][j-1]+data[i][j];
                }else {
                    data[i][j]=data[i-1][j]+data[i][j];
                }
            }
        }

        return data[data.length-1][data[0].length-1];

    }

    public static void main(String[] args){

        ShortestPath shortestPath= new ShortestPath();
        int[][] data= {{1,2,3},{4,5,6},{7,8,9}};
        int res= shortestPath.shortestPath(data);
        System.out.println("=====res:"+res+"=======");
    }
}
