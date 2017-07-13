package test;

import company.Employee;
import company.Hierarchy;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

       employees.add(new Employee("Alan", 100, 150));
        employees.add(new Employee("Martin", 220, 100));
        employees.add(new Employee("Jamie", 150, null));
        employees.add(new Employee("Alex", 275, 100));
        employees.add(new Employee("Steve", 400, 150));
        employees.add(new Employee("David", 190, 400));
        
//        employees.add(new Employee("Alan", 100, 150));
//        employees.add(new Employee("Martin", 220, 100));
//        employees.add(new Employee("Susan", 150, null));
//        employees.add(new Employee("Alex", 275, 100));
//        employees.add(new Employee("Steve", 400, 150));
//        employees.add(new Employee("David", 190, 400));
//        employees.add(new Employee("John", 191, 190));
//        employees.add(new Employee("Max", 192, 191));
//        employees.add(new Employee("Nicol", 193, 192));
//        employees.add(new Employee("Ann", 194, 192));
//        // null name, but valid ids
        employees.add(new Employee(null, 191, 400));
//
//        // No manager ID, but can't be CEO without its own ID
        employees.add(new Employee("P0", null, null));
//
//        // Manager is missing ID
        employees.add(new Employee("P1m", null, 150));
//        // and its employee can't be listed
        employees.add(new Employee("P1e", 106, 105));
//
//        // Circular hierarchy means CEO is missing
        employees.add(new Employee("P2", 1, 2));
        employees.add(new Employee("P3", 2, 3));
        employees.add(new Employee("P4", 3, 1));
        // Manager to himself
        employees.add(new Employee("P5", 1001, 1001));

        Hierarchy hierarchy = new Hierarchy(employees);

        hierarchy.printSorted();
    }
    
}
