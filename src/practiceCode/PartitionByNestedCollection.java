package practiceCode;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionByNestedCollection {

    public static void main(String args[]){
    List<Student> students = List.of(
            new Student("Alice", 85,7),
            new Student("Bob", 45,7),
            new Student("Charlie", 72,7),
            new Student("Diana", 95,8),
            new Student("Eve", 30,8)
    );

    Map<Boolean, Map<Integer, List<Student>>> partitioned = students.stream()
            .collect(Collectors.partitioningBy(
                    student -> student.grade >= 50, // Pass if grade >= 50
                    Collectors.groupingBy(student -> student.age)
            ));

        System.out.println("Passing students grouped by grade level: " + partitioned.get(true));
        System.out.println("Failing students grouped by grade level: " + partitioned.get(false));

    }


}

class Student {
    String name;
    int grade;
    int age;

    Student(String name, int grade, int age) {
        this.name = name;
        this.grade = grade;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                ", age=" + grade +
                '}';
    }
}
