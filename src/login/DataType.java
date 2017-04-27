package login;

/**
 * Created by jakubinyi on 2017.04.27..
 */
public enum DataType {
    PASSWORD(0),
    NAME(1);

    private int value;
    private DataType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
