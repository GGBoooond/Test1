package com.hsp.Reflection.Question;

import com.hsp.Cat;

/**
 * @author wxx
 * @version 1.0
 */
public class GetClass {
    public static void main(String[] args) throws Exception{
        Cat cat = new Cat();
//      1.已知一个类的全类名
        Class<?> cls1=Class.forName("com.hsp.Cat");
//      2.已知具体类，通过class直接获取
        Class cls2= Cat.class;
//      3.已知某个类的实例，调用该实例的getClass()方法获Class
        Class cls3=cat.getClass();
    }
}
