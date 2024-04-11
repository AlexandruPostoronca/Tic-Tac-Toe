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
        String[][] grid = Arrays.copyOf(arrays, arrays.length);
        System.out.println("Enter the coordinates:");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        String character= scanner.next();
        grid[x][y]=character;
        showGrid(grid);
    }

    private static String[][] enterCells(Scanner scanner) {
        String[][] grid = new String[4][4];
        String[] strings = scanner.next().split("");
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