package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    private ComputerNumbers fixedComputerNumbers(int[] values) {
        Numbers numbers = new Numbers(values);
        return new ComputerNumbers() {
            @Override
            public Number get(int idx) {
                return numbers.get(idx);
            }

            @Override
            public boolean notContain(Number number) {
                return numbers.notContain(number);
            }
        };
    }

    @Test
    void result_countsThreeStrike_whenAllMatchInPosition() {
        ComputerNumbers computerNumbers = fixedComputerNumbers(new int[]{1, 2, 3});
        Numbers inputNumbers = new Numbers(new int[]{1, 2, 3});

        Result result = new Result(computerNumbers, inputNumbers);

        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.getResultType()).isEqualTo(ResultType.THREE_STRIKE);
    }

    @Test
    void result_countsStrikeAndBall_whenValuesMatchDifferentPositions() {
        ComputerNumbers computerNumbers = fixedComputerNumbers(new int[]{1, 2, 3});
        Numbers inputNumbers = new Numbers(new int[]{1, 3, 2});

        Result result = new Result(computerNumbers, inputNumbers);

        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(2);
        assertThat(result.getResultType()).isEqualTo(ResultType.STRIKE_AND_BALL);
    }

    @Test
    void result_countsNothing_whenNoValuesMatch() {
        ComputerNumbers computerNumbers = fixedComputerNumbers(new int[]{1, 2, 3});
        Numbers inputNumbers = new Numbers(new int[]{4, 5, 6});

        Result result = new Result(computerNumbers, inputNumbers);

        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.getResultType()).isEqualTo(ResultType.NOTHING);
    }
}
