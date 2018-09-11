package com.imooc.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by xj on 2018/9/11.
 */
public class ClassUtil {
    /**
     * 打印类的信息，包括类的成员函数，成员变量
     * @param obj
     */
    public static void printClassMessage(Object obj){
        //要获取类的信息，首先要获取类的类类型
        Class c=obj.getClass();
        System.out.println("类的名称"+c.getName());
        /*
        methode类，方法对象，一个成员方法就是一个Method对象
        getMethods()方法获取的所有public的函数，包括父类继承的
        getDeclaredMethods()获取所有类自己声明的方法
         */

        Method[] ms=c.getMethods();// c.getDeclaredMethods();
        for(int i=0;i<ms.length;i++){
            //得到方法的返回值类型的类类型
            Class returnType=ms[i].getReturnType();
            System.out.print(returnType.getName()+" ");
            //得到方法的名称
            System.out.print(ms[i].getName()+"(");
            //获取参数类型,得到的是参数列表的类类型
            Class[] paramTypes=ms[i].getParameterTypes();
            for (Class class1:  paramTypes  ) {
                System.out.print(class1.getName());
                    if (!class1.equals(paramTypes[paramTypes.length - 1])) {
                        System.out.print(",");
                    }
                }
            System.out.println(")");
            }

            /*
            成员变量也是对象java.lang.reflect.Field
            Field类封装了关于成员变量的操作
            getFields()获取的是所有public的成员变量的信息
            getDeclaredFields获取的是该类自己声明的成员变量的信息
             */
        Field[] fs=c.getDeclaredFields();
        for (Field f:fs) {
            //得到成员变量的类型的类类型
            Class fieldType=f.getType();
            //得到成员变量类型的名字
            String fieldTypeName=fieldType.getName();
            //得到成员变量的名字
            String fieldName=f.getName();
            System.out.println(fieldTypeName+" "+fieldName);

        }

        }

}
