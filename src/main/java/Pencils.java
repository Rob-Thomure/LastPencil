public class Pencils {
    private static final String PENCIL_SYMBOL = "|";
    private int numPencilsRemaining;

    public Pencils(int numPencils) {
        this.numPencilsRemaining = numPencils;
    }

    public boolean isGameOver() {
        return numPencilsRemaining == 0;
    }

    public boolean takePencils(int num) {
        if (num > 0 && num < 4 && num <= numPencilsRemaining) {
            numPencilsRemaining -= num;
            return true;
        } else {
            return false;
        }
    }

    public int getNumPencilsRemaining() {
        return numPencilsRemaining;
    }

    @Override
    public String toString() {
        return PENCIL_SYMBOL.repeat(numPencilsRemaining);
    }
}
