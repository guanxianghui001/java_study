package day_003;

public class Polymorphic_001 {
    public static void main(String[] args) {
        Person1 p = new Student1();
//        Java的实例方法调用是基于运行时的实际类型的动态调用，而非变量的声明类型。
        p.run(); // 应该打印Person.run还是Student.run?
    }
}

class Person1 {
    public void run() {
        System.out.println("Person.run");
    }
}

class Student1 extends Person1 {
    @Override
    public void run() {
        System.out.println("Student.run");
    }
}

