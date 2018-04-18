package util.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static java.util.Comparator.*;

 public class CompareByMultipleFields {

    public static void main(String[] args) {
        List<Employee> empList = getEmpList();
        
        for (Employee emp : empList) {
            System.out.println(emp);
        }
        System.out.println("---------------------------------------------------------------------------");

        Collections.sort(empList, Collections.reverseOrder(new Comparator<Employee>() {

            @Override
            public int compare(Employee o1, Employee o2) {
                /*int res = o1.getDesignation().compareTo(o2.getDesignation());
                if (res == 0) {
                    return o1.getSalary() > o2.getSalary() ? 1 : o1.getSalary() < o2.getSalary() ? -1 : 0;
                } else {
                    return res;
                }*/
            		int res = o1.getActive().compareTo(o2.getActive());
            		if(res > 0) { // o1 is inactive, o2 is active
            			return res;
            		}else if( res < 0){ //o1 is active, o2 is inactive
            			return res;
            		}else { // both are equal
            			res = o1.getDesignation().compareTo(o2.getDesignation());
            			return res;
            		}

            }
        }));
        // Before Java 8 
        /*empList.sort(new Comparator<Employee>() {

            @Override
            public int compare(Employee o1, Employee o2) {
                int res = o1.getDesignation().compareTo(o2.getDesignation());
                if (res == 0) {
                    return o1.getSalary() > o2.getSalary() ? 1 : o1.getSalary() < o2.getSalary() ? -1 : 0;
                } else {
                    return res;
                }
            	            }
        });*/
        for (Employee emp : empList) {
            System.out.println(emp);
        }
        System.out.println("---------------------------------------------------------------------------");

        // In Java 8
        /*
        empList.sort(comparing(Employee::getDesignation).thenComparing(Employee::getSalary));
        empList.stream().forEach(System.out::println);
        */

    }
    private static List<Employee> getEmpList() {
        /*
         return Arrays.asList(
         		new Employee("Chaitra S", "Developer", 250000), new Employee("Manoj PVN", "Developer", 250000),
                new Employee("Ramesh R", "Developer", 280000), 
                new Employee("Lakshman A", "Consultent", 450000),
                new Employee("Suresh S", "Developer", 270000),
                new Employee("Superman", "Receptionist", 150000),
                new Employee("Jaishree", "Opearations HR", 350000));
        */
        return Arrays.asList(
                new Employee("Manoj PVN", "M", 250000, "Y"), new Employee("Boju", "B", 250000, "N"), new Employee("Chaitra S", "B", 1250000, "Y"));
    }
}

class Employee {
    private String fullName;
    private String designation;
    private double salary;
    private String active;

    public Employee(String fullName, String designation, double salary, String active) {
        super();
        this.fullName = fullName;
        this.designation = designation;
        this.salary = salary;
        this.active = active;
    }
    
    public Employee(String fullName, String designation, double salary) {
        super();
        this.fullName = fullName;
        this.designation = designation;
        this.salary = salary;
        this.active = active;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDesignation() {
        return designation;
    }

    public double getSalary() {
        return salary;
    }
    
    public String getActive() {
    		return active;
    }
        
    @Override
    public String toString() {
        return "Employee [fullName=" + fullName + ", designation=" + designation + ", salary=" + salary + ", active= " + active + "]";
    }

}
