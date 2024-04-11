import java.util.Locale;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        String ticTac = scanner.nextLine();
        int numberLine = 0;

        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|" + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(ticTac.charAt(numberLine)+" ");
                ++numberLine;
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}