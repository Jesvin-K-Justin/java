interface BankInterface{
    void getbalance(int balance);
    void getInterestRate(int balance);
}

class BankA implements BankInterface{
    public void getbalance(int balance){
        System.out.println("Balance Amount is:"+ balance);
    }
    public void getInterestRate(int balance){
        System.out.println("Interest Rate is: 7% ");
        System.out.println("Interest Amount is: "+ balance*0.07);

    }
}

class BankB implements BankInterface{
    public void getbalance(int balance){
        System.out.println("Balance Amount is:"+ balance);
    }
    public void getInterestRate(int balance){
        System.out.println("Interest Rate is: 7.4% ");
        System.out.println("Interest Amount is: "+ balance*0.074);

    }
}

class BankC implements BankInterface{
    public void getbalance(int balance){
        System.out.println("Balance Amount is:"+ balance);
    }
    public void getInterestRate(int balance){
        System.out.println("Interest Rate is: 7.9% ");
        System.out.println("Interest Amount is: "+ balance*0.079);

    }
}

public class Bank {
    public static void main(String[] args) {
        BankA bankA = new BankA();
        BankB bankB = new BankB();
        BankC bankC = new BankC();
        bankA.getbalance(10000);
        bankA.getInterestRate(1000);

        bankB.getbalance(150000);
        bankB.getInterestRate(150000);

        bankC.getbalance(200000);
        bankC.getInterestRate(200000);

        
    
    }
    
}
