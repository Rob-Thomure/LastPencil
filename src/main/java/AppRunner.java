
public class AppRunner {
    private final Player playerJohn;
    private final Player playerJack;
    private Pencils pencils;
    private Player playerTurn;


    public AppRunner() {
        this.playerJohn = new PlayerJohn();
        this.playerJack = new PlayerJack();
    }

    public void execute() {
        setUpGame();
        takeTurnsRemovingPencils();
    }

    private void setUpGame() {
        CommandLine commandLine = new CommandLine();
        int numPencils = commandLine.getNumPencilsToUse();
        this.pencils = new Pencils(numPencils);
        String firstPlayer = commandLine.whoIsFirst();
        initializePlayerTurn(firstPlayer);
    }

    private void initializePlayerTurn(String name) {
        playerTurn = name.equals("John") ? playerJohn : playerJack;
    }

    private void takeTurnsRemovingPencils() {
        while (!pencils.isGameOver()) {
            System.out.println(pencils);
            printPlayersTurn();
            playerTurn.takeTurn(pencils);
            if (pencils.isGameOver()) {
                printWinner();
            } else {
                changePlayerTurn();
            }
        }
    }

    private void printPlayersTurn() {
        System.out.println(playerTurn.getPlayerName() + "'s turn!");
    }

    private void changePlayerTurn() {
        playerTurn = playerTurn.getPlayerName().equals("John") ? playerJack : playerJohn;
    }

    private void printWinner() {
        String winner = playerTurn.getPlayerName().equals("John") ? "Jack" : "John";
        System.out.println(winner + " won!");
    }

}