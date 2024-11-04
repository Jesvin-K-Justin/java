import java.util.Scanner;

class Employee {
    int empId;
    String e_name;
    String desig;
    double bonus_percent;
    static double totalPayroll = 0;  // Static variable to track total payroll

    // Method to set employee data
    void set_data() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee id:");
        empId = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter employee name:");
        e_name = sc.nextLine();
        System.out.println("Enter employee designation:");
        desig = sc.nextLine();
    }

    // Method to get employee data
    void get_data() {
        System.out.println("Employee Id: " + empId);
        System.out.println("Employee name: " + e_name);
        System.out.println("Employee Designation: " + desig);
    }

    // Base bonus calculation method
    void calculateBonus() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter bonus % (0 - 0.05):");
        bonus_percent = sc.nextDouble();

        if (bonus_percent > 0.05 || bonus_percent < 0) {
            System.out.println("Bonus percentage should be between 0 and 0.05");
        }
    }

    // Method to add to total payroll
    void addToTotalPayroll(double annualIncome) {
        totalPayroll += annualIncome;
    }
}

class HourlyEmployee extends Employee {
    double hourlyRate;
    int hoursWorked;

    // Method to set hourly employee data
    void setHourlyData(double rate, int hours) {
        if (rate < 300 || rate > 1500 || hours < 2 || hours > 12) {
            System.out.println("Hourly rates should be between 300 and 1500 and hours worked should be between 2 and 12");
        } else {
            hourlyRate = rate;
            hoursWorked = hours;
        }
    }

    // Method to calculate weekly salary
    double weeklySalary() {
        return hourlyRate * hoursWorked;
    }

    void display_weeklySalary(double salary) {
        System.out.println("Weekly salary of Hourly employee: " + salary);
    }

    // Overridden method to calculate bonus using super
    @Override
    void calculateBonus() {
        super.calculateBonus();
        double bonus = bonus_percent * weeklySalary();
        System.out.println("Bonus amount: " + bonus);
    }

    void AnnualIncome() {
        double annualIncome = weeklySalary() * 52;
        System.out.println("Annual income is: " + annualIncome);
        addToTotalPayroll(annualIncome);
    }
}

class SalariedEmployee extends Employee {
    double monthlySalary;

    // Method to set monthly salary
    void setMonthlySalary(double salary) {
        if (salary < 20000 || salary > 500000) {
            System.out.println("Monthly salary should be between 20000 and 500000");
        } else {
            monthlySalary = salary;
        }
    }

    // Method to calculate weekly salary
    double weeklySalary() {
        return monthlySalary / 4;
    }

    void display_weeklySalary(double salary) {
        System.out.println("Weekly salary: " + salary);
    }

    // Overridden method to calculate bonus using super
    @Override
    void calculateBonus() {
        super.calculateBonus();
        double bonus = bonus_percent * weeklySalary();
        System.out.println("Bonus amount: " + bonus);
    }

    void AnnualIncome() {
        double annualIncome = weeklySalary() * 52;
        System.out.println("Annual income is: " + annualIncome);
        addToTotalPayroll(annualIncome);
    }
}

class ExecutiveEmployee extends SalariedEmployee {
    double bonusPercentage;

    // Method to set and validate bonus percentage for executive
    void setBonusPercentage(double bonusPercentage) {
        if (bonusPercentage >= 0 && bonusPercentage <= 0.1) {
            this.bonusPercentage = bonusPercentage;
        } else {
            System.out.println("Bonus percentage for executive should be between 0 and 0.1");
            this.bonusPercentage = 0.1;  // Default to 10% if invalid
        }
    }

    // Overridden method to calculate executive bonus
    @Override
    void calculateBonus() {
        double bonus = bonusPercentage * (weeklySalary() * 52);
        System.out.println("Yearly Bonus amount for executive employee: " + bonus);
    }
}

public class Payroll {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("press 1 to start, 0 to exit:");
        int i=sc.nextInt();

        while(i!=0){
            System.out.println("Enter employee type (Hourly employee:1, Salaried employee:2, Executive employee:3)");
            int empType = sc.nextInt();

            if (empType == 1) {
                HourlyEmployee he = new HourlyEmployee();
                he.set_data();

                System.out.println("Enter hourly rate:");
                double hourlyRate = sc.nextDouble();

                System.out.println("Enter hours worked:");
                int hoursWorked = sc.nextInt();

                he.setHourlyData(hourlyRate, hoursWorked);
                double salary = he.weeklySalary();
                he.get_data();
                he.display_weeklySalary(salary);
                he.AnnualIncome();
                he.calculateBonus();

            } else if (empType == 2) {
                SalariedEmployee se = new SalariedEmployee();
                se.set_data();

                System.out.println("Enter monthly salary:");
                double monthlySalary = sc.nextDouble();

                se.setMonthlySalary(monthlySalary);
                double salary = se.weeklySalary();
                se.get_data();
                se.display_weeklySalary(salary);
                se.AnnualIncome();
                se.calculateBonus();

            } else if (empType == 3) {
                ExecutiveEmployee ee = new ExecutiveEmployee();
                ee.set_data();

                System.out.println("Enter monthly salary:");
                double monthlySalary = sc.nextDouble();
                ee.setMonthlySalary(monthlySalary);

                System.out.println("Enter bonus percentage for executive (0 - 0.1):");
                double execBonus = sc.nextDouble();
                ee.setBonusPercentage(execBonus);

                double salary = ee.weeklySalary();
                ee.get_data();
                ee.display_weeklySalary(salary);
                ee.AnnualIncome();
                ee.calculateBonus();

            } else {
                System.out.println("Invalid choice");
            }

            // Display total payroll at the end
            System.out.println("Total Payroll: " + Employee.totalPayroll);
            System.out.println("press 1 to continue, 0 to exit:");
            i=sc.nextInt();

            }
            
        
        
    }
}
