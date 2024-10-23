package day_003;

public class Abstract {

    public static void main(String[] args) {
        Person1 p = new Student1();
        p.run();
    }
}

abstract class Person {
    public abstract void run();
}

class Student extends Person1 {
    @Override
//    Override和Overload不同的是，如果方法签名不同，就是Overload，Overload方法是一个新方法；如果方法签名相同，并且返回值也相同，就是Override。
    public void run() {
        System.out.println("Student.run");
    }
}
