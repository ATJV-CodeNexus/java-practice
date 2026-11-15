public class TestEncapsulation {

    public static void main(String[] args) {

        System.out.println("Creating first employee using constructor...");
        Employee employee1 = new Employee("John doe", 30, 5000);

        System.out.println("Creating second employee using setters...");
        Employee employee2 = new Employee();
        employee2.setName("Jane Smith");
        employee2.setAge(25);
        employee2.setSalary(5500);

        System.out.println("Initial Employee Details:");
        employee1.displayDetails();
        employee2.displayDetails();

        System.out.println("Testing validation with invalid values:");
        employee1.setName("");
        employee1.setAge(70);
        employee2.setSalary(-100);

        System.out.println("Employee Details After Invalid Values:");
        employee1.displayDetails();
        employee2.displayDetails();

        System.out.println("Giving both employees a 10% raise:");
        employee1.giveRaise(10);
        employee2.giveRaise(10);

        System.out.println("Employee Details after a raise: ");
        employee1.displayDetails();
        employee2.displayDetails();

        try {
            Employee clonedEmployee = (Employee) employee1.clone();
            System.out.println("Cloned Employee Details:");
            clonedEmployee.displayDetails();

            System.out.println("Modifying the original employee's salary...");
            employee1.setSalary(6000);

            System.out.println("\nOriginal Employee After Modification:");
            employee1.displayDetails();

            System.out.println("Cloned Employee After Original was Modified:");
            clonedEmployee.displayDetails();

        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported: " + e.getMessage());
        }

        String result = compareSalaries(employee1, employee2);
        System.out.println("Salary Comparison Result: " + result);
    }

    public static String compareSalaries(Employee emp1, Employee emp2) {
        if (emp1.getSalary() > emp2.getSalary()) {
            return emp1.getName() + " has a higher salary";
        } else if (emp1.getSalary() < emp2.getSalary()) {
            return emp2.getName() + " has a higher salary";
        } else {
            return "both have the same salary";
        }
    }
}
