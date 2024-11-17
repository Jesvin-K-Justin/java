import java.util.Scanner;

class ShareTrader {

    
    static int maxProfit;

    // Static method to find the maximum profit with at most 2 transactions
    public static void findMaxProfit(int[] prices) {
        int n = prices.length;

        if (n == 0) {
            maxProfit = 0;
            return;
        }

        // Arrays to store the maximum profit from one transaction
        int[] profitLeft = new int[n];  // Max profit if selling on or before day i
        int[] profitRight = new int[n]; // Max profit if buying on or after day i

        // Step 1: Fill profitLeft[] (maximum profit before or on day i)
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]); // Keep track of the minimum price
            profitLeft[i] = Math.max(profitLeft[i - 1], prices[i] - minPrice); // Max profit till day i
        }

        // Step 2: Fill profitRight[] (maximum profit after or on day i)
        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]); // Keep track of the maximum price
            profitRight[i] = Math.max(profitRight[i + 1], maxPrice - prices[i]); // Max profit from day i
        }

        // Step 3: Calculate the maximum profit using both transactions
        maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, profitLeft[i] + profitRight[i]); // Combine the two transactions
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Enter the number of elements (N)
        System.out.println("Enter the number of stock prices:");
        int N = sc.nextInt();

        // Input: Enter the stock prices
        int[] prices = new int[N];
        System.out.println("Enter the stock prices:");
        for (int i = 0; i < N; i++) {
            prices[i] = sc.nextInt();
        }

        // Call the method to find the maximum profit
        findMaxProfit(prices);

        // Output the maximum profit
        System.out.println("Maximum Profit: " + maxProfit);
    }
}
