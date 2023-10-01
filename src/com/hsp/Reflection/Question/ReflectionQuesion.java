package com.hsp.Reflection.Question;

import com.hsp.Cat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author wxx
 * @version 1.0
 */
public class ReflectionQuesion {
    public static void main(String[] args) throws Exception {

//        传统方法：创建对象 调用hi方法
//        new Cat().hi();

//        尝试：
//        使用properties文件读取调用
//        1.读取properties
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath=properties.get("classfullpath").toString();
        String method=properties.get("method").toString();
        System.out.println(classfullpath+"  "+method);
//        2.创建对象
//        传统方法不行
//        new classfullpath()//不行，因为是string
//        使用反射机制解决
//       1)加载类，返回class类型对象cls
        Class cls=Class.forName(classfullpath);
//       2)通过cls得到加载的类的对象实例
        Object o=cls.newInstance();
        System.out.println("运行类型是"+o.getClass());
//       3）通过cls得到需要的方法的方法对象
//       即：在反射机制中，可以把方法视为对象
        Method method1=cls.getMethod(method);
        System.out.println("============");
//        通过方法对象method1来实现调用方法
        method1.invoke(o);

//      java.lang.reflect.Field:代表类的成员变量
//      得到name字段
//      getField()不能得到私有的成员变量
        Field agefield=cls.getField("age");
        System.out.println("field="+agefield);
        System.out.println(agefield.get(o));
//      java.lang.reflect.Constructor：代表类的构造方法。constructor代表构造器
//      默认无参构造器
        Constructor constructor1=cls.getConstructor();
        System.out.println("constructor1="+constructor1);
//      指定有参数构造器
        Constructor constructor2=cls.getConstructor(String.class);
        System.out.println("constructor2="+constructor2);
    }
}

