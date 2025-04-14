import java.util.*;
class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

  
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    
    public int getId()
     { 
        return id; 
     }
    public String getName()
     {
         return name;
     }
    public String getDepartment()
     {
         return department; 
     }
    public double getSalary() 
    { 
         return salary; 
    }

    
    public void setName(String name) { this.name = name; }
    public void setDepartment(String department) { this.department = department; }
    public void setSalary(double salary) { this.salary = salary; }

    
    public void displayEmployee() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: $" + salary);
    }
}

class EmployeeManagementSystem {
    private ArrayList<Employee> employees = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        employees.add(new Employee(id, name, department, salary));
        System.out.println("Employee added successfully!\n");
    }

    
    public void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("\nEmployee List:");
            for (Employee emp : employees) {
                emp.displayEmployee();
            }
        }
    }

   
    public void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  
        boolean found = false;

        for (Employee emp : employees) {
            if (emp.getId() == id) {
                System.out.print("Enter new name (or press Enter to keep unchanged): ");
                String name = scanner.nextLine();
                if (!name.isEmpty()) emp.setName(name);

                System.out.print("Enter new department (or press Enter to keep unchanged): ");
                String department = scanner.nextLine();
                if (!department.isEmpty()) emp.setDepartment(department);

                System.out.print("Enter new salary (or press 0 to keep unchanged): ");
                double salary = scanner.nextDouble();
                if (salary > 0) emp.setSalary(salary);

                System.out.println("Employee updated successfully!\n");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee ID not found.\n");
        }
    }

   
    public void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = scanner.nextInt();
        boolean removed = employees.removeIf(emp -> emp.getId() == id);

        if (removed) {
            System.out.println("Employee deleted successfully!\n");
        } else {
            System.out.println("Employee ID not found.\n");
        }
    }

    public void menu() {
        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    displayAllEmployees();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


public class EMSMain {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        ems.menu();
    }
}
