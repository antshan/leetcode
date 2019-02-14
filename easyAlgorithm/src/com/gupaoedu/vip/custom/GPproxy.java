package com.gupaoedu.vip.custom;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by shanwei on 2019/2/14.
 */
public class GPproxy {

    private static  String ln = "\r\n";

    public static Object newProxyInstance(GPClassLoader classloader,
                                          Class<?>[] interfaces,
                                          GPInvocationHandler h)
            throws IllegalArgumentException{

        try {


            //1.生成源代码
            String proxySrc = generateSrc(interfaces[0]);

            //2.将生成的源代码保存到磁盘
            String filePath = GPproxy.class.getResource("").getPath();
            File f = new File(filePath+"$Proxy0.java");
            FileWriter fw=  new FileWriter(f);
            fw.write(proxySrc);
            fw.flush();
            fw.close();

            //3.编译源代码
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null,null,null);
            Iterable iterable = manager.getJavaFileObjects(f);

            JavaCompiler.CompilationTask task = compiler.getTask(null,manager,null,null,null,iterable);
            task.call();
            manager.close();

            //4.动态加载class文件

            //5.返回被代理后的代理对象
           Class clazz =  classloader.findClass("$Proxy0");
           Constructor constructor = clazz.getConstructor(GPInvocationHandler.class);
           return constructor.newInstance(h);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?> interfaces){

        StringBuffer src = new StringBuffer();
        src.append("package com.gupaoedu.vip.custom;"+ln);
        src.append("import java.lang.reflect.Method;"+ln);
        src.append("public class $Proxy0 implements "+ interfaces.getName()+"{"+ln);
        src.append("GPInvocationHandler h;"+ln);
        src.append("public $Proxy0(GPInvocationHandler h){"+ln);
        src.append("this.h = h;"+ln);
        src.append("}"+ln);

        for (Method m:interfaces.getMethods()){

            src.append("public "+m.getReturnType().getName()+" "+m.getName()+"(){"+ln);
            src.append("try{"+ln);
            src.append("Method m="+interfaces.getName()+".class.getMethod(\""+m.getName()+"\",new Class[]{});"+ln);
            src.append("this.h.invoke(this,m,null);"+ln);
            src.append("}catch(Throwable e){e.printStackTrace();}");
            src.append("}"+ln);
        }
        src.append("}");


        return src.toString();
    }
}
