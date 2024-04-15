import java.util.Arrays;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[][] arrays = enterCells(scanner);
        enterCoordinates(scanner, arrays);
    }

    private static void enterCoordinates(Scanner scanner, String[][] arrays) {
        boolean counter = false;
        do {
            System.out.print("Enter the coordinates: ");
            String text = scanner.nextLine().trim();
            String[] inputText = text.split(" ");

            if (inputText.length != 2 || inputText[0].length() != 1 || inputText[1].length() != 1 ||
                    !Character.isDigit(inputText[0].charAt(0)) || !Character.isDigit(inputText[1].charAt(0))) {
                System.out.println("You should enter numbers!");
                continue;
            }

            int x = Integer.parseInt(inputText[0]);
            int y = Integer.parseInt(inputText[1]);
            String character = "X";

            if (x >= 1 && x <= 3 && y >= 1 && y <= 3) {
                counter = analyzeInputCell(x, y, character, arrays, counter);
            } else {
                System.out.println("Coordinates should be from 1 to 3!");
            }
        } while (!counter);
    }

    private static boolean analyzeInputCell(int x, int y, String character, String[][] arrays, boolean counter) {
        String[][] grid = Arrays.copyOf(arrays, arrays.length);
        if (grid[x][y].equalsIgnoreCase("_")) {
            grid[x][y] = character;
            showGrid(grid);
            counter = true;
        } else {
            System.out.println("This cell is occupied! Choose another one!");
        }
        return counter;
    }

    private static String[][] enterCells(Scanner scanner) {
        System.out.print("Enter cells: ");
        String[][] grid = new String[4][4];
        String[] strings = scanner.nextLine().split("");
        int conter = 0;

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                grid[i][j] = strings[conter];
                conter++;
            }
        }
        showGrid(grid);
        return grid;
    }

    private static void showGrid(String[][] grid) {
        System.out.println("---------");
        System.out.println("| " + grid[1][1] + " " + grid[1][2] + " " + grid[1][3] + " |");
        System.out.println("| " + grid[2][1] + " " + grid[2][2] + " " + grid[2][3] + " |");
        System.out.println("| " + grid[3][1] + " " + grid[3][2] + " " + grid[3][3] + " |");
        System.out.println("---------");
    }
}