import java.util.Locale;
import java.util.Random;
import com.github.javafaker.Faker; // 确保你已经在项目中添加了JavaFaker依赖  

public class Student {
    private String name;
    private int age;
    private int score;

    // 构造函数  
    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    // Getter 方法  
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getScore() {
        return score;
    }

    // 静态方法用于生成学生数据  
    public static Student get_data() {
        Faker faker = new Faker(new Locale("zh", "CN"));

        // 生成学生姓名  
        String name = faker.name().fullName();

        // 生成年龄（6到23岁之间）  
        Random random = new Random();
        int age = random.nextInt(18) + 6; // 注意这里，随机数是0到17，加6后变为6到23  

        // 生成分数（0到100之间）  
        int score = random.nextInt(101);

        // 返回Student对象  
        return new Student(name, age, score);
    }
public static void main(String[] args) {
        Student student =Student.get_data();
        System.out.println(student.getName());

}

}