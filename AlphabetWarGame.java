import java.util.Scanner;

public class AlphabetWarGame {
    int w, p, b, s, m, q, d, z;

    
    AlphabetWarGame() {
        w = 4;
        m = 4;
        p = 3;
        q = 3;
        b = 2;
        d = 2;
        s = 1;
        z = 1;
    }

   
    AlphabetWarGame(int choice) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the strength of the word w:");
        w = sc.nextInt();

        System.out.println("Enter the strength of the word p:");
        p = sc.nextInt();

        System.out.println("Enter the strength of the word b:");
        b = sc.nextInt();

        System.out.println("Enter the strength of the word s:");
        s = sc.nextInt();

        System.out.println("Enter the strength of the word m:");
        m = sc.nextInt();

        System.out.println("Enter the strength of the word q:");
        q = sc.nextInt();

        System.out.println("Enter the strength of the word d:");
        d = sc.nextInt();

        System.out.println("Enter the strength of the word z:");
        z = sc.nextInt();
    }

    
    void play(String word) {
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);  
            switch (ch) {
                case 'w':
                    count1 += w;
                    break;
                case 'p':
                    count1 += p;
                    break;
                case 'b':
                    count1 += b;
                    break;
                case 's':
                    count1 += s;
                    break;
                case 'm':
                    count2 += m;
                    break;
                case 'q':
                    count2 += q;
                    break;
                case 'd':
                    count2 += d;
                    break;
                case 'z':
                    count2 += z;
                    break;
                default:
                    break;
            }
        }

        if (count1 > count2) {
            System.out.println("Left team won!");
        } else if (count1 < count2) {
            System.out.println("Right team won!");
        } else {
            System.out.println("It's a tie, play again!");
        }
    }

    
    void play(String left_word, String right_word) {
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < left_word.length(); i++) {
            char ch = left_word.charAt(i);
            switch (ch) {
                case 'w':
                    count1 += w;
                    break;
                case 'p':
                    count1 += p;
                    break;
                case 'b':
                    count1 += b;
                    break;
                case 's':
                    count1 += s;
                    break;
                default:
                    break;
            }
        }

        for (int i = 0; i < right_word.length(); i++) {
            char ch = right_word.charAt(i);
            switch (ch) {
                case 'm':
                    count2 += m;
                    break;
                case 'q':
                    count2 += q;
                    break;
                case 'd':
                    count2 += d;
                    break;
                case 'z':
                    count2 += z;
                    break;
                default:
                    break;
            }
        }

        if (count1 > count2) {
            System.out.println("Left team won!");
        } else if (count1 < count2) {
            System.out.println("Right team won!");
        } else {
            System.out.println("It's a tie, play again!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Do you want to enter the strengths manually? Type 1 for Yes, 0 for No:");
        int choice = sc.nextInt();
        sc.nextLine();  

        if (choice == 1) {
            AlphabetWarGame obj = new AlphabetWarGame(choice);

            System.out.println("Enter the Left word:");
            String left_word = sc.nextLine();

            System.out.println("Enter the Right word:");
            String right_word = sc.nextLine();

            obj.play(left_word, right_word);
        } else if (choice == 0) {
            AlphabetWarGame obj = new AlphabetWarGame();

            System.out.println("Enter the word:");
            String word = sc.nextLine();

            obj.play(word);
        } else {
            System.out.println("Invalid Choice");
        }
    }
}
