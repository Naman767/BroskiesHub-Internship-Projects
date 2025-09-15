import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeSorting {
    // Function to sort by salary
    public static void sortBySalaryDesc(List<Employee> employees) {

        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o2.getSalary(),o1.getSalary());
            }
        });
    }

    // Function to sort by name
    public static void sortByNameAsc(List<Employee> employees) {
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getName().compareTo(e2.getName());
            }
        });
    }

    // Function to print employee list
    public static void printEmployees(List<Employee> employees) {
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        // Create ArrayList of Employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Naman", 23, 55000));
        employees.add(new Employee("Aryan", 25, 65000));
        employees.add(new Employee("Ashish", 22, 45000));
        employees.add(new Employee("Rohit", 28, 75000));

        // Sort by salary
        sortBySalaryDesc(employees);
        System.out.println("\nEmployees sorted by Salary:");
        printEmployees(employees);

        // Sort by name
        sortByNameAsc(employees);
        System.out.println("\nEmployees sorted by Name:");
        printEmployees(employees);
    }
}

