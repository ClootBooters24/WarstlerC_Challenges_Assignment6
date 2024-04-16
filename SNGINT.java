import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SNGINT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numTests = Integer.parseInt(reader.readLine());
        int[] array = new int[numTests];

        for(int i = 0; i < numTests; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        for(int i = 0; i < numTests; i++) {
            System.out.println(findSmallestNumber(array[i]));
        }
    }

    public static int findSmallestNumber(int num) {
        if(num == 0) {
            return 10;
        }
        if(num < 10) {
            return num;
        }

        StringBuilder string = new StringBuilder();
        
        for(int i = 9; i > 1; i--) {
            while(num % i == 0) {
                num /= i;
                string.insert(0,i);
            }
        }
        if(num != 1) {
            return -1;
        }

        return Integer.parseInt(string.toString());
    }
}