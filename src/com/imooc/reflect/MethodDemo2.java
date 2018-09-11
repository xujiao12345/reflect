package com.imooc.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by xj on 2018/9/11.
 */
public class MethodDemo2 {
    public static void main(String[] args){
        ArrayList list=new ArrayList();
        ArrayList<String> list1=new ArrayList<String>();
        list1.add("hello");
//        list1.add(20);是错误的
        Class c1=list.getClass();
        Class c2=list1.getClass();
        System.out.println(c1==c2);
        //反射的操作都是编译之后的操作
        /**
         * c1==c2结果返回true,说明编译之后的泛型是去泛型化的,Java中
         * 集合的泛型是防止错误输入的,只在编译阶段有效,绕过编译就无效了
         验证:通过方法的反射来操作,绕过编译
         */
        try {
            Method m=c2.getMethod("add",Object.class);
            m.invoke(list1,20);//绕过编译就绕过了泛型
            System.out.println(list1.size());
            System.out.println(list1);
            /*for (String string:list1){
                System.out.println(string);
            }*///现在就不能这样遍历
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
