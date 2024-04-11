import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] array = new char[3][3];
        for (char[] chars : array) {
            Arrays.fill(chars, '_');
        }


        coordinationChecking(array, scanner);
    }

    private static void checkEndOfGame(char[][] array) {
        boolean xWon = hasWon(array, 'X');
        boolean oWon = hasWon(array, 'Y');


        int numberOfX = counterCheck(array, 'X');
        int numberOfO = counterCheck(array, 'O');
        int dif = Math.abs(numberOfX - numberOfO);


        if (dif > 1) {
            System.out.println("Impossible");
        } else if (xWon && oWon) {
            System.out.println("Impossible");
        } else if (xWon) {
            System.out.println("X wins");

        } else if (oWon) {
            System.out.println("O wins");
        } else if (numberOfX + numberOfO == 9) {
            System.out.println("Draw");
        }
    }

    public static boolean diagonal(char[][] array, char ch) {
        return array[0][0] == ch && array[1][1] == ch && array[2][2] == ch || array[0][2] == ch && array[1][1] == ch && array[2][0] == ch;
    }

    public static boolean vertical(char[][] array, char ch) {
        return array[0][0] == ch && array[0][1] == ch && array[0][2] == ch ||
               array[1][0] == ch && array[1][1] == ch && array[1][2] == ch ||
               array[2][0] == ch && array[2][1] == ch && array[2][2] == ch;

    }

    public static boolean horizontal(char[][] array, char ch) {
        return array[0][0] == ch && array[1][0] == ch && array[2][0] == ch ||
               array[0][1] == ch && array[1][1] == ch && array[2][1] == ch ||
               array[0][2] == ch && array[1][2] == ch && array[2][2] == ch;
    }

    public static int counterCheck(char[][] array, char ch) {
        int number = 0;
        for (char[] chars : array) {
            for (char aChar : chars) {
                if (aChar == ch) {
                    number++;
                }
            }

        }
        return number;
    }

    public static void writeChar(int number1, int number2, char[][] array, char ch) {
        array[number1][number2] = ch;
    }

    public static void print(char[][] array) {
        System.out.println("---------");
        System.out.println("| " + array[0][0] + " " + array[0][1] + " " + array[0][2] + " |");
        System.out.println("| " + array[1][0] + " " + array[1][1] + " " + array[1][2] + " |");
        System.out.println("| " + array[2][0] + " " + array[2][1] + " " + array[2][2] + " |");

        System.out.println("---------");
    }

    public static void coordinationChecking(char[][] array, Scanner scanner) {
        int number = 0;
        while (number < 9) {
            try {
                System.out.print("Enter the coordinates: ");
                int numberInput1 = scanner.nextInt();
                int numberInput2 = scanner.nextInt();
                scanner.nextLine();
                numberInput2--;
                numberInput1--;


                if ((numberInput1 < 0 || numberInput1 > 2) || (numberInput2 < 0 || numberInput2 > 2)) {
                    System.out.println("Coordinates should be from 1 to 3!");

                } else if (number % 2 == 0) {

                    if (array[numberInput1][numberInput2] == '_') {
                        writeChar(numberInput1, numberInput2, array, 'X');
                        number++;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }

                } else {
                    if (array[numberInput1][numberInput2] == '_') {
                        writeChar(numberInput1, numberInput2, array, 'O');
                        number++;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }

                }


                print(array);
                checkEndOfGame(array);

            } catch (InputMismatchException ex) {
                System.out.println("You should enter numbers!");
                scanner.nextLine();
                print(array);
            }
        }

    }

    public static boolean hasWon(char[][] array, char ch) {
        return diagonal(array, ch) || vertical(array, ch) || horizontal(array, ch);
    }
}