package baseball.domain;

public class Result {

    private final ResultType resultType;
    private final int strike;
    private final int ball;

    public Result(ComputerNumbers computerNumbers, Numbers inputNumbers) {
        int strike = 0;
        int ball = 0;
        for (int idx = 0; idx < inputNumbers.size(); idx++) {
            Number number = inputNumbers.get(idx);
            if (computerNumbers.notContain(number)) {
                continue;
            }
            if (number.isSameValue(computerNumbers.get(idx))) {
                strike++;
                continue;
            }
            ball++;
        }
        this.strike = strike;
        this.ball = ball;
        this.resultType = ResultType.getResult(strike, ball);
    }

}
