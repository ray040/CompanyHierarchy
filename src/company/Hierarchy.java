package company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hierarchy {
    private final List<Employee> employees;

    public Hierarchy(List<Employee> employees) {
        this.employees = employees;
    }

    public void printSorted() {

        final List<Employee> ceos = getCEOs();
        // if no CEO can be found
        if (ceos.isEmpty()) {
            System.out.println(" ______________________________________________________________ ");
            System.out.println("|                                                              |");
            System.out.println("|                    No CEO in the company!                    |");
            System.out.println("|______________________________________________________________|");
        } else {
            ceos.stream().forEach((ceo) -> {
                print(0, ceo);
            });
        }
        // if there are unlisted employees
        if (!employees.isEmpty()) {
            System.out.println("\nEmployees with Error:");
            // for each one of them
            employees.stream().forEach((employee) -> {
                System.out.println(employee);
            });
        }
    }
    
    private void print(int level, Employee employee) {
        employees.remove(employee);
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
        System.out.println(employee.getName());
        List<Employee> inferiors = getInferiors(employee.getId());
        if (!inferiors.isEmpty()) {
            inferiors.stream().forEach((inferior) -> {
                print(level +1, inferior);
            });
        }
    }

    private List<Employee> getCEOs() {
        List<Employee> CEOs = new ArrayList<>();
        employees.stream().filter((employee) -> (employee.getManagerId() == null && employee.getId() != null)).forEach((employee) -> {
            CEOs.add(employee);
        });
        return CEOs;
    }

    private List<Employee> getInferiors(int managerId) {
        return employees.stream().filter(employee -> employee.getName() != null && employee.getId() != null && employee.getManagerId() != null && employee.getManagerId() == managerId).collect(Collectors.toList());
    }
}
