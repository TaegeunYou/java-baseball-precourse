package baseball.domain;

public enum ResultType {
    THREE_STRIKE,
    STRIKE_AND_BALL,
    NOTHING
    ;

    public static ResultType getResult(int strike, int ball) {
        if (strike == 3) {
            return THREE_STRIKE;
        }
        if (strike != 0 || ball != 0) {
            return STRIKE_AND_BALL;
        }
        return NOTHING;
    }
}
