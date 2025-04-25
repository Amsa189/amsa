package practiceCode;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmpSalSort {

    void main(){

        Employee4 emp1 = new Employee4("Amsa",32,10000,"Pittsburgh", "IT");
        Employee4 emp2 = new Employee4("Mittu",28,20000,"Pittsburgh", "IT");
        Employee4 emp3 = new Employee4("Navi",26,30000,"NewJersey", "Sales");
        Employee4 emp4 = new Employee4("Sath",25,40000,"Texas", "Sales");
        Employee4 emp5 = new Employee4("Nila",35,50000,"Texas", "Sales");
        List<Employee4> empList = new ArrayList<>();
        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);
        empList.add(emp4);
        empList.add(emp5);
        List<Integer> arrList = new ArrayList<>();
        arrList.add(1);
        arrList.add(1);
        arrList.add(2);
        arrList.add(2);
        arrList.add(2);

        List<String> arrList1 = new ArrayList<>();
        arrList1.add("amsa");
        arrList1.add("veni");
        arrList1.add("navi");
        arrList1.add("mittu");
        arrList1.add("sath");
        arrList1.stream().collect(Collectors.toMap(str -> str, str -> str.length()));
        System.out.println(arrList.stream().distinct().toList());
        System.out.println(arrList.stream().mapToInt(Integer::intValue));
        System.out.println("reduced answer:: "+arrList.stream().reduce(1,(a,b)->a*b));

        //get the age of employees who takes salary more than 30000
        List<Integer> ageList = empList.stream().filter(emp -> emp.salary()> 30000).map(Employee4::age).sorted().peek(System.out::println).toList();
        System.out.println(ageList);

        //get the employee name who gets highest salary in each department
        final Map<String, Optional<Employee4>> collect = empList.stream().collect(Collectors.groupingBy(Employee4::dept, Collectors.minBy(Comparator.comparingDouble(Employee4::salary))));
        collect.entrySet().stream().forEach(entry-> System.out.println("key::"+entry.getKey()+"value::"+entry.getValue()));
        //group the employees based on dept and sort based on dept;
        TreeMap<String,List<Employee4>> output = empList.stream().collect(Collectors.groupingBy(Employee4::dept,TreeMap::new,Collectors.toList()));
        output.entrySet().forEach(System.out::println);

        //sum the salary of employees in each department.

        final Map<String, Double> collect1 = empList.stream().collect(Collectors.groupingBy(Employee4::dept, Collectors.summingDouble(e -> e.salary())));
        collect1.entrySet().forEach(System.out::println);
        //using groupingby inside groupingBy
        final Map<String, Map<String, List<Employee4>>> collect2 = empList.stream().collect(Collectors.groupingBy(Employee4::dept, Collectors.groupingBy(emp -> emp.city())));
        collect2.entrySet().forEach(System.out::println);
    }
}
record Employee4(String name, int age, double salary, String city, String dept){}
