import java.util.Scanner;

class Book{
    int bookId;
    String title;
    String author;

    Book(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter book id: ");
        bookId = sc.nextInt();
        System.out.println("Enter Title: ");
        title = sc.next();
        System.out.println("Enter author: ");
        author = sc.next();
        
    }

    void displayData(){
        System.out.println("Book id: "+bookId);
        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
    }

}

class ReferenceBook extends Book{
    int edition;
    ReferenceBook(){
        super();
        Scanner sc = new Scanner(System.in);
        System.out.println("Edition: ");
        edition = sc.nextInt();

        
    } 

    void displayData(){
        super.displayData();
        System.out.println("edition: "+edition);

    }


}

class FictionBook extends Book{
    String genre;

    FictionBook(){
        super();
        Scanner sc = new Scanner(System.in);
        System.out.println("Genre: ");
        genre = sc.next();
    }

    void displayData(){
        super.displayData();
        System.out.println("genre: "+genre);

    }


}

class Periodical extends ReferenceBook{

    String issueFreq;
    Periodical(){
        super();
        Scanner sc = new Scanner(System.in);
        System.out.println("Issue Frequency(weekly,monthly): ");
        issueFreq=sc.next();
    }

    void displayData(){
        super.displayData();
        System.out.println("Issue Frequency: "+issueFreq);

    }
}

public class Library {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1. Reference Book");
            System.out.println("2. Fiction Book");
            System.out.println("3. Periodical");
            System.out.println("4. Borrow book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");

            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            if (choice == 1){
                ReferenceBook ref= new ReferenceBook();
                ref.displayData();
            }
            else if(choice==2){
                FictionBook fic = new FictionBook();
                fic.displayData();

            }
            else if(choice==3){
                Periodical per = new Periodical();
                per.displayData();
            }
            else{
                System.out.println("Exiting....");
                break;
            }
        }
        
        
        
        
    }
    
}



