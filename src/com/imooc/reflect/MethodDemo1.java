package com.imooc.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by xj on 2018/9/11.
 */
public class MethodDemo1 {
    public static void main(String[] args){
        //要获取print（int,int）方法,
        //1.获取类的信息，获取类的类类型
        A a1=new A();
        Class c= a1.getClass();
        //2.获取方法，名称和参数列表
        try {
//            Method m=c.getMethod("print",new Class[]{int.class,int.class});
            Method m=c.getMethod("print",int.class,int.class);
            //方法的反射操作时用m对象来进行方法调用，和a1.print调用的效果完全相同
            //方法如果没有返回值返回null，有返回值返回返回值
            Object o=m.invoke(a1,10,20);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
class A{
    public void print(int a,int b){
        System.out.println(a+b);
    }
    public void print(String a,String b){
        System.out.println(a.toUpperCase()+","+b.toLowerCase());
    }
}
