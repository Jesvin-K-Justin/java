public class D1 {
    private int value;

    public D1(int val) {
        value = val;
    }

    public void printValue() {
        System.out.println("Value: " + value);
    }

    public static void main(String[] args) {
        D1 obj = new D1(4); 
        obj.printValue();   
    }
}