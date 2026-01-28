package baseball.domain;

public enum ResultType {
    STRIKE_AND_BALL,
    NOTHING
    ;

    public static ResultType getResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return NOTHING;
        }
        return STRIKE_AND_BALL;
    }
}
