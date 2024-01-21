public class PlayerJohn implements Player {
    private static final String PLAYER_NAME = "John";


    public void takeTurn(Pencils pencils) {
        CommandLine commandLine = new CommandLine();
        int numPencilsToTake = commandLine.numPencilsToTake();
        while (!pencils.takePencils(numPencilsToTake)) {
            System.out.println("Too many pencils were taken");
            numPencilsToTake = commandLine.numPencilsToTake();
        }
    }

    public String getPlayerName() {
        return PLAYER_NAME;
    }
}
