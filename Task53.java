import java.io.*;
import java.nio.charset.StandardCharsets;

public class Task53 {
    public static void main(String[] args) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream("INPUT.TXT"), StandardCharsets.UTF_8));
             BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("OUTPUT.TXT"), StandardCharsets.UTF_8))) {

            String[] widthAndLength = fileReader.readLine().split("\\s+");
            int width = Integer.parseInt(widthAndLength[0]);
            int lenght = Integer.parseInt(widthAndLength[1]);
            int[][] multArray = new int[width][lenght];
            int blackCounter = width * lenght;
            int greenCounter = 0;
            int redCounter = 0;
            int blueCounter = 0;


            for (int i = 0; i < multArray.length; i++) {
                for (int j = 0; j < multArray[i].length; j++) {
                    multArray[i][j] = (i + 1) * (j + 1);
                    if (multArray[i][j] % 2 == 0) {
                        redCounter++;
                        blackCounter--;
                        if (multArray[i][j] % 3 == 0) {
                            greenCounter++;
                            redCounter--;
                            if (multArray[i][j] % 5 == 0) {
                                blueCounter++;
                                greenCounter--;
                            }
                        } else if (multArray[i][j] % 5 == 0) {
                            blueCounter++;
                            redCounter--;
                        }
                    } else
                    if (multArray[i][j] % 3 == 0) {
                        greenCounter++;
                        blackCounter--;
                        if (multArray[i][j] % 5 == 0) {
                            blueCounter++;
                            greenCounter--;
                        }
                    } else
                    if (multArray[i][j] % 5 == 0) {
                        blueCounter++;
                        blackCounter--;
                    }
                }
            }
            String red = "RED : " + redCounter + System.lineSeparator();
            String green = "GREEN : " + greenCounter + System.lineSeparator();
            String blue = "BLUE : " + blueCounter + System.lineSeparator();
            String black = "BLACK : " + blackCounter + System.lineSeparator();
            StringBuilder output = new StringBuilder(red).append(green).append(blue).append(black);

            fileWriter.write(output.toString());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
