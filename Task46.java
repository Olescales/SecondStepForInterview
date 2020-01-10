import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class Task46 {
    public static void main(String[] args) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter("output.txt"))) {

            int scale = Integer.parseInt(fileReader.readLine());
            String e = "2.7182818284590452353602875";

            BigDecimal bigDecimal = new BigDecimal(e);
            bigDecimal = bigDecimal.setScale(scale,RoundingMode.HALF_UP);

            fileWriter.write(bigDecimal.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
