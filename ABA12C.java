import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ABA12C {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numTests = Integer.parseInt(reader.readLine());

        for(int i = 0; i < numTests; i++) {
            StringTokenizer string = new StringTokenizer(reader.readLine());
            int numFriends = Integer.parseInt(string.nextToken());
            int numApplesToBuy = Integer.parseInt(string.nextToken());

            int[] price = new int[numApplesToBuy];
            string = new StringTokenizer(reader.readLine());

            for(int j = 0; j < numApplesToBuy; j++) {
                price[j] = Integer.parseInt(string.nextToken());
            }

            int[] dp = new int[numApplesToBuy + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;

            for(int j = 1; j <= numApplesToBuy; j++) {
                for(int k = 1; k <= j; k++) {
                    if(price[k - 1] != -1 && dp[j - k] != Integer.MAX_VALUE) {
                        dp[j] = Math.min(dp[j], dp[j - k] + price[k - 1]);
                    }
                }
            }

            System.out.println(dp[numApplesToBuy] == Integer.MAX_VALUE ? -1 : dp[numApplesToBuy]);
        }
    }
}
