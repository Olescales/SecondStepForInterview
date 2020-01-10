import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

//D:\олег\input.txt
public class Task99 {

    public static void main(String[] args) {

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream("INPUT.TXT"), StandardCharsets.UTF_8));
             BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("OUTPUT.TXT"), StandardCharsets.UTF_8))) {

            String[] levelWidthLength = fileReader.readLine().split("\\s+");
            int numberOfLevels = Integer.parseInt(levelWidthLength[0]);
            int widthOfLevel = Integer.parseInt(levelWidthLength[1]);
            int lenghtOfLevel = Integer.parseInt(levelWidthLength[2]);

            StringBuilder stringBuilder = new StringBuilder();
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                if (!line.isEmpty()) {
                    stringBuilder.append(line).append("\n");
                }
            }
            String[] lineArray = stringBuilder.toString().split("\n");
            int lineCounter = 0;
            Node prince = null;
            String[][][] gameField = new String[numberOfLevels][widthOfLevel][lenghtOfLevel];
            for (int i = 0; i < numberOfLevels; i++) {
                for (int j = 0; j < widthOfLevel; j++) {
                    int r = 0;
                    String[] pieces = lineArray[lineCounter].split("");
                    for (int k = 0; k < lenghtOfLevel; k++) {
                        if (pieces[r].equals("1")) {
                            prince = new Node(i, j, k);
                        }
                        gameField[i][j][k] = pieces[r];
                        r++;
                    }
                    lineCounter++;
                }
            }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            LinkedList<Node> prevNodes = new LinkedList<>();
            LinkedList<Node> nowNodes = new LinkedList<>();

            prevNodes.add(prince);
            int k = -1;
            int quit = 0;
            do {
                ++k;
                do {
                    Node currentNode = prevNodes.poll();

                    if (gameField[currentNode.z][currentNode.y][currentNode.x].equals("2")) {
                        ++quit;
                        break;
                    }

                    Node left = new Node(currentNode.z, currentNode.y, currentNode.x - 1);
                    if (left.z < numberOfLevels && left.y < widthOfLevel &&
                            left.y >= 0 && left.x < lenghtOfLevel && left.x >= 0) {
                        if (gameField[left.z][left.y][left.x].equals(".")) {
                            gameField[left.z][left.y][left.x] = "s";
                            nowNodes.add(left);
                        } else if (gameField[left.z][left.y][left.x].equals("2")) {
                            nowNodes.add(left);
                        }
                    }
                    Node up = new Node(currentNode.z, currentNode.y - 1, currentNode.x);
                    if (up.z < numberOfLevels && up.y < widthOfLevel &&
                            up.y >= 0 && up.x < lenghtOfLevel && up.x >= 0) {
                        if (gameField[up.z][up.y][up.x].equals(".")) {
                            gameField[up.z][up.y][up.x] = "s";
                            nowNodes.add(up);
                        } else if (gameField[up.z][up.y][up.x].equals("2")) {
                            nowNodes.add(up);
                        }
                    }
                    Node right = new Node(currentNode.z, currentNode.y, currentNode.x + 1);
                    if (right.z < numberOfLevels && right.y < widthOfLevel &&
                            right.y >= 0 && right.x < lenghtOfLevel && right.x >= 0) {
                        if (gameField[right.z][right.y][right.x].equals(".")) {
                            gameField[right.z][right.y][right.x] = "s";
                            nowNodes.add(right);
                        } else if (gameField[right.z][right.y][right.x].equals("2")) {
                            nowNodes.add(right);
                        }
                    }
                    Node down = new Node(currentNode.z, currentNode.y + 1, currentNode.x);
                    if (down.z < numberOfLevels && down.y < widthOfLevel &&
                            down.y >= 0 && down.x < lenghtOfLevel && down.x >= 0) {
                        if (gameField[down.z][down.y][down.x].equals(".")) {
                            gameField[down.z][down.y][down.x] = "s";
                            nowNodes.add(down);
                        } else if (gameField[down.z][down.y][down.x].equals("2")) {
                            nowNodes.add(down);
                        }
                    }

                    Node levelDown = new Node(currentNode.z + 1, currentNode.y, currentNode.x);
                    if (levelDown.z < numberOfLevels && levelDown.y < widthOfLevel &&
                            levelDown.y >= 0 && levelDown.x < lenghtOfLevel && levelDown.x >= 0) {
                        if (gameField[levelDown.z][levelDown.y][levelDown.x].equals(".")) {
                            gameField[levelDown.z][levelDown.y][levelDown.x] = "s";
                            nowNodes.add(levelDown);
                        } else if (gameField[levelDown.z][levelDown.y][levelDown.x].equals("2")) {
                            nowNodes.add(levelDown);
                        }
                    }
                } while (!prevNodes.isEmpty());
                prevNodes = nowNodes;
                nowNodes = new LinkedList<>();
            } while (quit!=1);

            fileWriter.write(String.valueOf(k * 5));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Node {
        private int z;
        private int y;
        private int x;

        public Node(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }

    }
}



