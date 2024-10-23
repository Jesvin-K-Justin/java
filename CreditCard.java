import java.util.Scanner;

class CC {
    CC(int c_num) {
        
        int len = String.valueOf(c_num).length();

        if (len == 8 || len == 9) {
            int lastDigit = c_num % 10; 
            int cc_number = c_num / 10; 
            System.out.println("Last digit: " + lastDigit);

            int rev = 0;
            int num = 0;

            
            while (cc_number != 0) {
                num = cc_number % 10;
                rev = rev * 10 + num;
                cc_number = cc_number / 10;
            }
            System.out.println("Reversed (without last digit): " + rev);

            String ccStr = String.valueOf(rev);
            int sum = 0;

            
            for (int i = 0; i < ccStr.length(); i++) {
                int digit = Character.getNumericValue(ccStr.charAt(i)); 

                
                if ((i + 1) % 2 != 0) {
                    digit *= 2; 

                    
                    if (digit >= 10) {
                        digit = (digit % 10) + (digit / 10); 
                    }
                }

                sum += digit; 
            }

            System.out.println("Sum of digits after processing: " + sum);
            int sum_lastDigit = sum % 10;
            int checkDigit = 10 - sum_lastDigit;

            
            if (checkDigit == lastDigit) {
                System.out.println("Valid credit card");
            } else {
                System.out.println("Invalid credit card");
            }
        } else {
            System.out.println("Invalid credit card number length");
        }
    }
}

public class CreditCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the credit card number:");
        int c_num = sc.nextInt();
        CC obj = new CC(c_num);
    }
}
