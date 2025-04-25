package practiceCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmpSort {
    //sort the list of employees based on salary

    public static void main(String args[]){
        Employee e1 = new Employee("amsa",22,"sales",1000000d);
        Employee e2 = new Employee("veni",21,"sales", 50000d);
        Employee e3 = new Employee("Mittu",20,"IT",100000d);
        Employee e4 = new Employee("Chittu",25,"IT",50000d);
        List<Employee> list = Arrays.asList(e1,e2,e3,e4);
        //sorting employees based on salary
        final List<Employee> collect = list.stream().sorted(Comparator.comparing(Employee::salary)).collect(Collectors.toList());
        collect.forEach(System.out::println);
        //grouping employees based on department
        final Map<String, List<Employee>> collect1 = list.stream().collect(Collectors.groupingBy(e -> e.dept()));
        System.out.println(collect1);


    }
}

record Employee(String name, Integer age, String dept, Double salary){}
