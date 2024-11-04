class Employee {
    int empId;
    String e_name;
    String desig;
    double bonus_percent = 0.05;  // Set default bonus percentage (5%)
    static double totalPayroll = 0;  // Static variable to track total payroll

    void set_data(int empId, String name, String designation) {
        this.empId = empId;
        this.e_name = name;
        this.desig = designation;
    }

    void get_data() {
        System.out.println("Employee Id: " + empId);
        System.out.println("Employee Name: " + e_name);
        System.out.println("Employee Designation: " + desig);
    }

    void calculateBonus() {
        System.out.println("Base class bonus calculation.");
    }

    void addToTotalPayroll(double annualIncome) {
        totalPayroll += annualIncome;
    }
}

class HourlyEmployee extends Employee {
    double hourlyRate;
    int hoursWorked;

    void setHourlyData(double rate, int hours, double bonusPercent) {
        this.hourlyRate = rate;
        this.hoursWorked = hours;
        this.bonus_percent = bonusPercent;  // Set bonus percent
    }

    double weeklySalary() {
        return hourlyRate * hoursWorked;
    }

    void display_weeklySalary() {
        System.out.println("Weekly salary: " + weeklySalary());
    }

    @Override
    void calculateBonus() {
        double bonus = bonus_percent * weeklySalary();
        System.out.println("Hourly employee bonus: " + bonus);
    }

    void displayAnnualIncome() {
        double annualIncome = weeklySalary() * 52;
        System.out.println("Annual Income: " + annualIncome);
        addToTotalPayroll(annualIncome);
    }
}

class SalariedEmployee extends Employee {
    double monthlySalary;

    void setMonthlySalary(double salary, double bonusPercent) {
        this.monthlySalary = salary;
        this.bonus_percent = bonusPercent;  // Set bonus percent
    }

    double weeklySalary() {
        return monthlySalary / 4;
    }

    void display_weeklySalary() {
        System.out.println("Weekly salary: " + weeklySalary());
    }

    @Override
    void calculateBonus() {
        double bonus = bonus_percent * weeklySalary();
        System.out.println("Salaried employee bonus: " + bonus);
    }

    void displayAnnualIncome() {
        double annualIncome = monthlySalary * 12;
        System.out.println("Annual Income: " + annualIncome);
        addToTotalPayroll(annualIncome);
    }
}

class ExecutiveEmployee extends SalariedEmployee {
    double bonusPercentage;

    void setBonusPercentage(double bonusPercentage) {
        this.bonusPercentage = bonusPercentage;
    }

    @Override
    void calculateBonus() {
        double annualIncome = monthlySalary * 12;
        double bonus = bonusPercentage * annualIncome;
        System.out.println("Executive employee bonus: " + bonus);
    }
}

public class TestPayroll {
    public static void main(String[] args) {
        // Test data for HourlyEmployee
        HourlyEmployee he = new HourlyEmployee();
        he.set_data(101, "Alice", "Teaching Assistant");
        he.setHourlyData(1200, 10, 0.04);  // Set bonus percent explicitly
        he.get_data();
        he.display_weeklySalary();
        he.displayAnnualIncome();
        he.calculateBonus();

        System.out.println();

        // Test data for SalariedEmployee
        SalariedEmployee se = new SalariedEmployee();
        se.set_data(102, "Bob", "Lecturer");
        se.setMonthlySalary(40000, 0.03);  // Set bonus percent explicitly
        se.get_data();
        se.display_weeklySalary();
        se.displayAnnualIncome();
        se.calculateBonus();

        System.out.println();

        // Test data for ExecutiveEmployee
        ExecutiveEmployee ee = new ExecutiveEmployee();
        ee.set_data(103, "Carol", "Dean");
        ee.setMonthlySalary(100000, 0.05);  // Bonus percent set through Executive class
        ee.setBonusPercentage(0.1);          // Set higher bonus percentage for executive
        ee.get_data();
        ee.display_weeklySalary();
        ee.displayAnnualIncome();
        ee.calculateBonus();

        // Display total payroll at the end
        System.out.println("\nTotal Payroll: " + Employee.totalPayroll);
    }
}
