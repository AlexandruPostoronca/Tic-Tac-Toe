import java.util.Arrays;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        char[][] arrays = enterCells();
        enterCoordinates(scanner, arrays);
    }

    private static void enterCoordinates(Scanner scanner, char[][] arrays) {
        boolean counter = false;
        char character = 'O';
        int counterFinalGame=0;
        do {
            boolean fieldWinsX = false;
            boolean fieldWinsO = false;
            System.out.print("Enter the coordinates: ");
            String text = scanner.nextLine().trim();
            String[] inputText = text.split(" ");
            char[][] grid = Arrays.copyOf(arrays, arrays.length);

            if (inputText.length != 2 || inputText[0].length() != 1 || inputText[1].length() != 1 ||
                    !Character.isDigit(inputText[0].charAt(0)) || !Character.isDigit(inputText[1].charAt(0))) {
                System.out.println("You should enter numbers!");
                continue;
            }

            int x = Integer.parseInt(inputText[0]);
            int y = Integer.parseInt(inputText[1]);

            if (x >= 1 && x <= 3 && y >= 1 && y <= 3) {
                if (grid[x][y]=='_') {
                    character = character=='X' ? 'O' : 'X';
                    counterFinalGame++;
                    grid[x][y] = character;
                    showGrid(grid);
                    fieldWinsX = fieldWins(grid, 'X');
                    fieldWinsO = fieldWins(grid, 'O');
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            } else {
                System.out.println("Coordinates should be from 1 to 3!");
            }

            if (fieldWinsX) {
                System.out.println("X wins");
                counter=true;
            }
            if (fieldWinsO){
                System.out.println("O wins");
                counter=true;
            }if(counterFinalGame>8){
                System.out.println("Draw");
                counter=true;
            }
        } while (!counter);
    }

    private static char[][] enterCells() {
        char[][] grid = new char[4][4];
        char strings = '_';
        int conter = 0;

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                grid[i][j] = strings;
                conter++;
            }
        }
        showGrid(grid);
        return grid;
    }

    private static void showGrid(char[][] grid) {
        System.out.println("---------");
        System.out.println("| " + grid[1][1] + " " + grid[1][2] + " " + grid[1][3] + " |");
        System.out.println("| " + grid[2][1] + " " + grid[2][2] + " " + grid[2][3] + " |");
        System.out.println("| " + grid[3][1] + " " + grid[3][2] + " " + grid[3][3] + " |");
        System.out.println("---------");
    }

    private static boolean fieldWins(char[][] grid, char n) {
        return (gameRow(grid, n) || gameColumn(grid, n) || gameDeagonal(grid, n)) ? true : false;
    }

    private static boolean gameDeagonal(char[][] ticTac, char n) {
        return ticTac[1][1]==n && ticTac[2][2]==n && ticTac[3][3]==n ||
                ticTac[1][3]==n && ticTac[2][2]==n && ticTac[3][1]==n;
    }

    private static boolean gameColumn(char[][] ticTac, char n) {
        return ticTac[1][1]==n && ticTac[2][1]==n && ticTac[3][1]==n ||
                ticTac[1][2]==n && ticTac[2][2]==n && ticTac[3][2]==n ||
                ticTac[1][3]==n && ticTac[2][3]==n && ticTac[3][3]==n;
    }

    public static boolean gameRow(char[][] ticTac, char n) {
        return ticTac[1][1]==n && ticTac[1][2]==n && ticTac[1][3]==n ||
                ticTac[2][1]==n && ticTac[2][2]==n && ticTac[2][3]==n ||
                ticTac[3][1]==n && ticTac[3][2]==n && ticTac[3][3]==n;
    }
}
