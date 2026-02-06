package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberTest {

    @Test
    void isSameValue_returnsTrue_whenValuesMatch() {
        Number number = new Number(5);
        Number sameValue = new Number(5);

        assertThat(number.isSameValue(sameValue)).isTrue();
    }

    @Test
    void isSameValue_returnsFalse_whenValuesDoNotMatch() {
        Number number = new Number(5);
        Number differentValue = new Number(7);

        assertThat(number.isSameValue(differentValue)).isFalse();
    }
}
