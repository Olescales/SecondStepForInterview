import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;

public class Task654second {
    public static void main(String[] args) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter("output.txt"))) {

            int numberOfIntervals = Integer.parseInt(fileReader.readLine().trim());
            int[] amplFrequencyResponce;
            String lineWithDigits = fileReader.readLine();
            amplFrequencyResponce = Arrays.stream(lineWithDigits.split(" ")).mapToInt(Integer::parseInt).toArray();

            BigInteger counter = new BigInteger("0");

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < numberOfIntervals; i++) {
                if (amplFrequencyResponce[i] > max) {
                    max = amplFrequencyResponce[i];
                }
            }
            for (int i = 0; i < numberOfIntervals-1; i++) {
                if (amplFrequencyResponce[i+1] > amplFrequencyResponce[i]) {
                    counter = counter.add(new BigInteger(String.valueOf(amplFrequencyResponce[i+1] - amplFrequencyResponce[i])));
                }
            }
            counter = counter.add(new BigInteger(String.valueOf(max - amplFrequencyResponce[numberOfIntervals-1])));

            fileWriter.write(counter.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
