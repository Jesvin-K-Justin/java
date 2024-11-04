Lab 1.1 Credit card number validation

This Java program validates a credit card number . The program first removes the last digit of the input number and reverses the remaining digits. It then processes each digit, doubling the digits at odd positions and summing them. If a doubled digit is greater than or equal to 10, the digits are split and summed. Finally, the program checks if the last digit matches the calculated checksum. If they match, the card is considered valid; otherwise, it's invalid.

Lab 1.2 Alphabet War Game

This Java program, AlphabetWarGame, simulates a game where two teams (left and right) compete based on the strength of characters in a word or two separate words. The program has two constructors: one with default strengths for characters (w, p, b, s, m, q, d, z) and another that allows users to input custom strengths. The game compares the strength of characters in either a single word or two separate words (left and right). Based on the total strength of the characters, the program declares which team wins, or if it's a tie.

Lab 2.1 Top k numbers with highest frequency

This Java program identifies the top K numbers with the highest frequency from a user-defined array. It uses a 2D array to store each unique number and its frequency. The findTopKFrequent method first counts frequencies, then sorts the array in descending order of frequency (and by value if frequencies match). Finally, it outputs the top K frequent numbers. The main method handles input for the array and the K value and calls the frequency method to display the result.
  
Lab 2.2  Maximum Profit

This Java program calculates the maximum profit a trader can make with at most two stock transactions within a day. The program uses two arrays: profitLeft (tracking maximum profit if selling on or before each day) and profitRight (tracking maximum profit if buying on or after each day). By combining the results from both arrays, it finds the maximum profit achievable from two non-overlapping transactions. The main method takes stock prices as input and displays the maximum profit.


Lab 3.1 Payroll system

The payroll system handles different employee types—HourlyEmployee, SalariedEmployee, and ExecutiveEmployee—by calculating their weekly salaries, annual incomes, and bonuses based on distinct pay structures. Each employee type inherits from a base Employee class, with HourlyEmployee and SalariedEmployee classes extending Employee, and ExecutiveEmployee extending SalariedEmployee. I implemented methods in each class to set and display employee details, compute weekly salary, calculate bonuses, and validate input values for attributes like salary and bonus percentages. Additionally, ExecutiveEmployee overrides the bonus calculation to provide a higher bonus rate. A static variable is used to track the total payroll across all employees.

Lab3.2 Testing Payroll System

It is a test program to demonstrate the functionality of the employee payroll system. The test program should instantiate objects for each employee type: HourlyEmployee, SalariedEmployee, and ExecutiveEmployee, and set their attributes, including employee ID, name, designation, hourly rate, hours worked, monthly salary, and bonus percentage.The program  displays detailed information for each employee, including their calculated weekly salary, annual earnings, bonuses, and the total payroll amount. It utilizes method overriding and the super keyword appropriately to invoke base class functionalities. Furthermore, the test program reflect robust data validation, ensuring that all attributes conform to predefined constraints, thereby showcasing the complete capabilities of the payroll system.
