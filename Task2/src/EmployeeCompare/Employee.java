import java.util.*;

    // Employee class
    public class Employee {
        private String name;
        private int age;
        private double salary;

        // Constructor
        public Employee(String name, int age, double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        // Getters (needed for Comparator)
        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        // toString method for easy display
        @Override
        public String toString() {
            return "Employee [Name=" + name + ", Age=" + age + ", Salary=" + salary + "]";
        }
    }
