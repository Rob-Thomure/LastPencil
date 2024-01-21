import java.util.Random;

public class PlayerJack implements Player {
    private static final int ORIGIN_INDEX_FOUR = 4;
    private static final int ORIGIN_INDEX_THREE = 3;
    private static final int ORIGIN_INDEX_TWO = 2;
    private static final String PLAYER_NAME = "Jack";

    @Override
    public void takeTurn(Pencils pencils) {
        int numPencilsRemaining = pencils.getNumPencilsRemaining();
        int numPencilsToTake = calculateHoeManyPencilsToTake(numPencilsRemaining);
        System.out.println(numPencilsToTake);
        pencils.takePencils(numPencilsToTake);
    }

    private int calculateHoeManyPencilsToTake(int numPencilsRemaining) {
        if (shouldTakeThreePencils(numPencilsRemaining)) return 3;
        else if (shouldTakeTwoPencils(numPencilsRemaining)) return 2;
        else if (numPencilsRemaining == 1 || shouldTakeOnePencil(numPencilsRemaining)) return 1;
        else return new Random().nextInt(1, 4);
    }

    private boolean shouldTakeThreePencils(int num) {
        return forLoopCalculateOneTwoThreePencils(num, ORIGIN_INDEX_FOUR);
    }

    private boolean shouldTakeTwoPencils(int num) {
        return forLoopCalculateOneTwoThreePencils(num, ORIGIN_INDEX_THREE);
    }

    private boolean shouldTakeOnePencil(int num) {
        return forLoopCalculateOneTwoThreePencils(num, ORIGIN_INDEX_TWO);
    }

    private boolean forLoopCalculateOneTwoThreePencils(int num, int origin_index) {
        for (int i = origin_index; i <= num; i += 4) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }

    public String getPlayerName() {
        return PLAYER_NAME;
    }
}
