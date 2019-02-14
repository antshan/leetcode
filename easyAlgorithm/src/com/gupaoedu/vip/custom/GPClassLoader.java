package com.gupaoedu.vip.custom;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by shanwei on 2019/2/14.
 */
public class GPClassLoader extends ClassLoader {

    private File baseDir;

    public GPClassLoader(){

        String basePath = GPClassLoader.class.getResource("").getPath();
        this.baseDir = new File(basePath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        String className= GPClassLoader.class.getPackage().getName()+"."+name;
        if (baseDir != null){

            File classFile = new File(baseDir,name.replaceAll("\\.","/")+".class");
            if (classFile.exists()){
                FileInputStream in = null;
                ByteArrayOutputStream out = null;
                try {
                    in= new FileInputStream(classFile);
                    out= new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while ((len=in.read(buff)) != -1){
                        out.write(buff,0,len);
                    }
                    return defineClass(className,out.toByteArray(),0,out.size());

                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    try {
                        if (in != null){
                            in.close();
                        }
                        if (out != null){
                            out.close();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }
        }

        return null;
    }
}
