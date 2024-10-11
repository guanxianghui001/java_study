package day_001;
//面向对象-方法
public class Hello {
    public static void main(String[] args){
        System.out.println("Hello World");
        Person ming = new Person();
        ming.setName("xiaoming");
        ming.setAge(12);
        System.out.println(ming.getName()+ming.getAge());


    }
}

class Person{
    private String name;
    private int  age;

    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        if (age<0 || age>100)
        {
            throw new IllegalArgumentException("invalid name");
        }
        this.age = age;
    }
}