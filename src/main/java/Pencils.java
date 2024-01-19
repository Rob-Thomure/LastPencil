public class Pencils {
    private static final String PENCIL_SYMBOL = "|";
    private int numPencils;

    public Pencils(int numPencils) {
        this.numPencils = numPencils;
    }

    public boolean isGameOver() {
        return numPencils == 0;
    }

    public boolean takePencils(int num) {
        if (num > 0 && num < 4 && num <= numPencils) {
            numPencils -= num;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return PENCIL_SYMBOL.repeat(numPencils);
    }
}
