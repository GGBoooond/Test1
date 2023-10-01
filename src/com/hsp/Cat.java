package com.hsp;

/**
 * @author wxx
 * @version 1.0
 */
public class Cat {
    private String name="大橘";
    public int age;
    public Cat(){}
    public Cat(String name,int age){
        this.name=name;
        this.age=age;
    }
    private Cat(String name){}
    public void  hi(){
        System.out.println("my name is:"+name);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
    private String hi(String sex){
        return name+"性别"+sex;
    }
}
