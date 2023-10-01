package com.hsp.Reflection.Question;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @author wxx
 * @version 1.0
 * 关于静态加载和动态加载
 */
public class ClassLoad {
//    属性-成员变量-字段
//    分析类加载的连接阶段-准备，属性是如何处理的
//i1是实例属性,而不是静态变量,所以在准备阶段,不会分配内存
    public int i1=10;
//i2是静态变量,在准备阶段,默认初始化为0,而不是20
    public static int i2=20;
//i3由于是static final,是常量,故在准备阶段直接赋值为30
    public static final  int i3=30;
    public static void main(String[] args)throws Exception {
        Scanner scanner=new Scanner(System.in);
        int s=scanner.nextInt();
        switch (s){
            case 1:
//                静态加载，依赖性很强
//                若不存在Dog类，编译时会报错
//                Dog dog = new Dog();
//                dog.hi();
                break;
            case 2:
//                反射--》动态加载
//                不存在该类，编译时不会报错
                Class cls=Class.forName("com.hsp.Dog");
                Object o=cls.newInstance();
                Method method=cls.getMethod("hi");
                method.invoke(o);
                break;
        }
    }
}


//类加载
//加载阶段,加载类,并生成类的class文件
//连接阶段, num=0;
//初始化阶段,
//依次自动收集类中所有静态变量的赋值动作和静态代码块的语句,并合并到clinit方法里面
//  clinic(){
//      System.out.println("=====");
//      num=200;
//      num=100;
//  }
//合并后,num=100
class ClassLOAD{
    static {
        System.out.println("=====");
          int num=200;
    }
    public static int num=100;
}
