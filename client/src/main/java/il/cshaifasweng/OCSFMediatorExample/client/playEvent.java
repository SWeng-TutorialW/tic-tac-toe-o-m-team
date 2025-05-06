package il.cshaifasweng.OCSFMediatorExample.client;

public class playEvent {
    private final int rows ;
    private final int cols ;
    private final char sign ;

    public playEvent(int rows, int cols,char sign) {
        this.rows = rows;
        this.cols = cols;
        this.sign = sign;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
    public char getSign() {
        return sign;
}
}