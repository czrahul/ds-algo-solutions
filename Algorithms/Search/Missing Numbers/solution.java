import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class solution {

    // Complete the missingNumbers function below.
    static int[] missingNumbers(int[] arr, int[] brr) {
TreeMap<Integer, Integer> integerFreqMap = new TreeMap<>();

    // Add elements of original list
    for (int i : brr) {
      int freq = integerFreqMap.getOrDefault(i, 0);
      freq++;
      integerFreqMap.put(i, freq);
    }

    // Remove elements of new list
    for (int i : arr) {
      int freq = integerFreqMap.get(i);
      freq--;
      if (freq == 0)
        integerFreqMap.remove(i);
      else
        integerFreqMap.put(i, freq);
    }

    // Create the result array
    int[] result = new int[integerFreqMap.size()];
    int i = 0;
    for (Map.Entry<Integer, Integer> integerIntegerEntry : integerFreqMap.entrySet()) {
      result[i++] = integerIntegerEntry.getKey();
    }

    return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] brr = new int[m];

        String[] brrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrItems[i]);
            brr[i] = brrItem;
        }

        int[] result = missingNumbers(arr, brr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
