import java.util.Locale;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        String ticTac = scanner.nextLine();
        int numberLine = 0;
        boolean fieldWin = false;

        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|" + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(ticTac.charAt(numberLine) + " ");
                ++numberLine;
            }
            System.out.println("|");
        }
        System.out.println("---------");

        boolean fieldWinsX = fieldWins(ticTac, 'X');
        boolean fieldWinsO = fieldWins(ticTac, 'O');

        if (fieldWinsX && fieldWinsO) System.out.println("Impossible");
        else if (fieldWinsX) System.out.println("X wins");
        else if (fieldWinsO) System.out.println("O wins");
        else if (fieldWinsXO(ticTac)) System.out.println("Impossible");
        else if (pointEmpty(ticTac)) System.out.println("Game not finished");
        else if (!fieldWinsX && !fieldWinsO) System.out.println("Draw");
    }

    private static boolean fieldWinsXO(String ticTac) {
        String[] numbersXO = ticTac.split("");
        int x = 0;
        int o = 0;
        for (int i = 0; i < numbersXO.length; i++) {
            if (numbersXO[i].equalsIgnoreCase("X")) {
                ++x;
            } else if (numbersXO[i].equalsIgnoreCase("O")) {
                ++o;
            }
        }
        int result = (x + o) / 2;
        return (x >= result && o >= result) ? false : true;
    }

    private static boolean fieldWins(String ticTac, char n) {

        return (gameRow(ticTac, n) || gameColumn(ticTac, n) || gameDeagonal(ticTac, n)) ? true : false;
    }

    private static boolean gameDeagonal(String ticTac, char n) {
        return ticTac.charAt(0) == n && ticTac.charAt(4) == n && ticTac.charAt(8) == n ||
                ticTac.charAt(2) == n && ticTac.charAt(4) == n && ticTac.charAt(6) == n;
    }

    private static boolean gameColumn(String ticTac, char n) {
        return ticTac.charAt(0) == n && ticTac.charAt(3) == n && ticTac.charAt(6) == n ||
                ticTac.charAt(1) == n && ticTac.charAt(4) == n && ticTac.charAt(7) == n ||
                ticTac.charAt(2) == n && ticTac.charAt(5) == n && ticTac.charAt(8) == n;
    }

    public static boolean gameRow(String ticTac, char n) {
        return ticTac.charAt(0) == n && ticTac.charAt(1) == n && ticTac.charAt(2) == n ||
                ticTac.charAt(3) == n && ticTac.charAt(4) == n && ticTac.charAt(5) == n ||
                ticTac.charAt(6) == n && ticTac.charAt(7) == n && ticTac.charAt(8) == n;
    }

    private static boolean pointEmpty(String ticTac) {
        boolean pointEmpty = false;
        for (int i = 0; i < ticTac.length(); i++) {
            char letter = ticTac.charAt(i);
            if (letter == '_') {
                pointEmpty = true;
                break;
            }
        }
        return pointEmpty;
    }
}