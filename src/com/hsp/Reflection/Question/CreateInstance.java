package com.hsp.Reflection.Question;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author wxx
 * @version 1.0
 */
public class CreateInstance {
    public static void main(String[] args) throws Exception{
        Class cls=Class.forName("com.hsp.Cat");
//        法1:调用类中的public修饰的无参构造器
        Object o1=cls.newInstance();
//        法2:调用类中的指定参数的构造器
//        2.1调用public修饰的
        Constructor constructor1=cls.getConstructor(String.class,int.class);
        Object o2=constructor1.newInstance("bb",3);
//        2.2 调用private修饰的
        //这里不能使用getConstructor()方法,因为它只能得到public修饰的构造器
        Constructor constructor2=cls.getDeclaredConstructor(String.class);
//      正常情况下无法访问private构造器
        constructor2.setAccessible(true);//暴破[暴力破解],可以用此来通过反射访问private构造器
        Object o3=constructor2.newInstance("cc");

//      使用反射来修改private成员变量
        System.out.println(o1);
        Field field=cls.getDeclaredField("name");
        field.setAccessible(true);
        field.set(o1,"大黄");
        System.out.println(o1);
//      使用反射来访问类中方法
        Method method=cls.getDeclaredMethod("hi",String.class);
        method.setAccessible(true);
//        在反射中,如果方法有返回值,统一用object接收.但是运行类型和方法定义的一致
        Object get=method.invoke(o1,"xxn");
        System.out.println(get);
    }
}
