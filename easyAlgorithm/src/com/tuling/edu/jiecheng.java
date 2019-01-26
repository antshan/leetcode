package com.tuling.edu;

/**
 * 对于大数和小数的阶乘，使用不同的方法
 */
public class jiecheng {

    //对于大数的阶乘保存结果到数组中
    public static void jc(int n){
        int[] arr= new int[100];
        arr[arr.length-1]= 1;

        boolean flag= false;

        for (int i=1;i<=n;i++){
            arr= demo(arr,i);
        }

        for (int i=0;i<arr.length;i++){
            if (arr[i]!=0) flag= true;
            if(flag){
                System.out.print(arr[i]);
            }
        }
    }

    //数组与数相乘 得到的结果保存在数组中
    public static int[] demo(int[] arr,int a){

        for (int i=0;i<arr.length;i++){
            arr[i]*=a;
        }

        for (int i=arr.length-1;i>0;i--){
            arr[i-1]+=arr[i]/10;
            arr[i]=arr[i]%10;
        }

        return arr;
    }

    //对于较小的数的阶乘
    public static void xjc(int n){
        int sum= 1;
        for (int i=1;i<=n;i++){
            sum*=i;
        }

        System.out.println(sum);
    }

    public static void main(String[] args){
        int[] arr={0,0,0,0,0,0,0,0,1000};
        int a= 100;
        demo(arr,a);
        xjc(10);
        jc(10);

    }
}
