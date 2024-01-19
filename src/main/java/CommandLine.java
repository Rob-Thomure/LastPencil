import java.util.List;
import java.util.Scanner;

public class CommandLine {
    Scanner keyboard;

    public CommandLine() {
        this.keyboard = new Scanner(System.in);
    }

    public int getNumPencilsToUse() {
        System.out.println("How many pencils would you like to use:");
        boolean isValidInput = false;
        String input = "";
        while (!isValidInput) {
            input = keyboard.nextLine();
            isValidInput = isValidNumPencilsToUse(input);
        }
        return Integer.parseInt(input);
    }

    private boolean isValidNumPencilsToUse(String input) {
        if (!inputIsNumeric(input)) {
            System.out.println("The number of pencils should be numeric");
        } else {
            int numPencils = Integer.parseInt(input);
            if (!numIsPositive(numPencils)) {
                System.out.println("The number of pencils should be positive");
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean inputIsNumeric(String input) {
        return input.matches("\\d+");
    }

    private boolean numIsPositive(int num) {
        return num > 0;
    }

    public String whoIsFirst() {
        System.out.println("Who will be the first (John, Jack):");
        String input = keyboard.nextLine();
        while (!isValidName(input)) {
            System.out.println("Choose between 'John' and 'Jack'");
            input = keyboard.nextLine();
        }
        return input;
    }

    private boolean isValidName(String input) {
        List<String> validNames = List.of("John", "Jack");
        return validNames.contains(input);
    }

    public int numPencilsToTake() {
        String input = keyboard.nextLine();
        while (!isValidNumPencilsToTake(input)) {
            System.out.println("Possible values: '1', '2' or '3'");
            input = keyboard.nextLine();
        }
        return Integer.parseInt(input);
    }

    private boolean isValidNumPencilsToTake(String input) {
        if (!inputIsNumeric(input)) {
            return false;
        } else {
            int num = Integer.parseInt(input);
            return num > 0 && num < 4;
        }
    }

}
