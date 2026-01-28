package baseball.domain;

public class Number {
    private final int num;

    public Number(int num) {
        this.num = num;
    }

    public boolean isSameValue(Number number) {
        return this.num == number.num;
    }
}
