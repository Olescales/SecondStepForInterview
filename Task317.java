import java.io.*;
import java.util.Arrays;

public class Task317 {
    public static void main(String[] args) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter("output.txt"))) {

            String lineWithDigits = fileReader.readLine();
            int[] numbers = Arrays.stream(lineWithDigits.split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = numbers[0];
            int y = numbers[1];
            int z = numbers[2];
            int w = numbers[3];

            int counter = 0;
            for (int i = 0; i <= w; i++) {
                for (int j = 0; j <= w; j++) {
                        if ((w - (x * i + y * j)) % z == 0 &&  ((w - x * i - y * j) >= 0) ) {
                            counter++;
                        }
                }
            }
            fileWriter.write(String.valueOf(counter));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
