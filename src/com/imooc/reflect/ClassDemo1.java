package com.imooc.reflect;

import static java.lang.System.out;

/**
 * Created by xj on 2018/9/11.
 */
public class ClassDemo1 {
    public static void main(String[] args){
        //Foo的实例对象如何表示
        Foo foo1=new Foo();//foo1就表示出来了
        //Foo这个类本身也是一个实例对象，是Class类的实例对象
        //任何一个类都是Class的实例对象，有三种表示方式
        //1.
        Class c1=Foo.class;
        //2
        Class c2=foo1.getClass();
        //3.
        Class c3=null;
        try {
            c3=Class.forName("com.imooc.reflect.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //万物皆对象，类也是对象，是Class类的实例对象
        System.out.println(c1==c2);
        System.out.println(c2==c3);
        //可以通过类的类型创建该类的实例
        try {
            Foo foo2= (Foo) c1.newInstance();
            foo2.print();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
class Foo{
    void print(){
        System.out.println("print");
    }
}
