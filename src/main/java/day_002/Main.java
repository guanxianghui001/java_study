package day_002;
public class Main{
    public static void main(String[] args){

//    Person xiao =new Person("huahua");
    Person xiao =new Person();
    System.out.println(xiao.getName());
    System.out.println(xiao.getAge());
    }
        }

class Person{
    private String name;
    private int age;
//    默认的构造方法
//    如果我们自定义了一个构造方法，那么，编译器就不再自动创建默认构造方法：
    public Person(){

    }
    public Person(String name){
//        一个构造方法可以调用其他构造方法，这样做的目的是便于代码复用。调用其他构造方法的语法是this(…)
        this("gxh",12);
    }
//    带有两个参数的构造方法
    public  Person(String name,int age) {
        this.name=name;
        this.age=age;

    }
    public String getName(){
        return this.name;

    }
    public int getAge(){
        return this.age;
    }
}