import java.util.Scanner;

public class AppRunner {
    private static final String JACK = "Jack";
    private static final String JOHN = "John";
    private final Scanner keyboard;
    private String playersTurn;
    private Pencils pencils;


    public AppRunner() {
        this.keyboard = new Scanner(System.in);
    }

    public void execute() {
        setUpGame();
        takeTurnsRemovingPencils();
    }

    private void setUpGame() {
        CommandLine commandLine = new CommandLine();
        int numPencils = commandLine.getNumPencilsToUse();
        this.pencils = new Pencils(numPencils);
        playersTurn = commandLine.whoIsFirst();
    }

    private void takeTurnsRemovingPencils() {
        CommandLine commandLine = new CommandLine();
        while (!pencils.isGameOver()) {
            System.out.println(pencils);
            printPlayersTurn();
            int numPencilsToTake = commandLine.numPencilsToTake();
            while (pencils.takePencils(numPencilsToTake) == false) {
                System.out.println("Too many pencils were taken");
                numPencilsToTake = commandLine.numPencilsToTake();
            }
            if (pencils.isGameOver()) {
                printWinner();
            } else {
                changePlayerTurn();
            }
        }
    }

    private void printPlayersTurn() {
        System.out.println(playersTurn + "'s turn!");
    }

    private void changePlayerTurn() {
        playersTurn = playersTurn.equals(JACK) ? JOHN : JACK;
    }

    private void printWinner() {
        String winner = playersTurn.equals("John") ? "Jack" : "John";
        System.out.println(winner + " won!");
    }

}