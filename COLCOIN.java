import java.io.*;
import java.util.*;

public class COLCOIN {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numTests = Integer.parseInt(reader.readLine());

        for(int i = 0; i < numTests; i++) {
            int numCoins = Integer.parseInt(reader.readLine());
            String[] coinStrings = reader.readLine().split(" ");
            Integer[] coins = new Integer[numCoins];

            for(int j = 0; j < numCoins; j++) {
                coins[j] = Integer.parseInt(coinStrings[j]);
            }

            Arrays.sort(coins, Collections.reverseOrder());
            long sum = coins[0];
            int maxCoins = 1;

            for(int j = 1; j < numCoins; j++) {
                if (sum + coins[j] <= sum) {
                    sum += coins[j];
                    maxCoins++;
                } else {
                    break;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + maxCoins);
        }
    }    
}