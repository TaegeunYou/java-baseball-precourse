package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultTypeTest {

    @Test
    void getResult_returnsThreeStrike_whenStrikeIsThree() {
        ResultType result = ResultType.getResult(3, 0);

        assertEquals(ResultType.THREE_STRIKE, result);
        assertThat(result).isEqualTo(ResultType.THREE_STRIKE);
    }

    @Test
    void getResult_returnsStrikeAndBall_whenAnyStrikeOrBall() {
        assertThat(ResultType.getResult(1, 0)).isEqualTo(ResultType.STRIKE_AND_BALL);
        assertThat(ResultType.getResult(0, 2)).isEqualTo(ResultType.STRIKE_AND_BALL);
    }

    @Test
    void getResult_returnsNothing_whenNoStrikeAndNoBall() {
        ResultType result = ResultType.getResult(0, 0);

        assertEquals(ResultType.NOTHING, result);
    }
}
