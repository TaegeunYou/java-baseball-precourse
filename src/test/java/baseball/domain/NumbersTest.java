package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NumbersTest {

    @Test
    void size_returnsLengthOfInputArray() {
        Numbers numbers = new Numbers(new int[]{1, 2, 3});

        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    void get_returnsNumberAtIndex() {
        Numbers numbers = new Numbers(new int[]{1, 2, 3});

        Number number = numbers.get(0);

        assertThat(number.isSameValue(new Number(1))).isTrue();
    }

    @Test
    void notContain_returnsFalse_whenNumberExists() {
        Numbers numbers = new Numbers(new int[]{1, 2, 3});

        assertThat(numbers.notContain(new Number(2))).isFalse();
    }

    @Test
    void notContain_returnsTrue_whenNumberDoesNotExist() {
        Numbers numbers = new Numbers(new int[]{1, 2, 3});

        assertThat(numbers.notContain(new Number(9))).isTrue();
    }

    @Test
    void get_throwsIndexOutOfBounds_whenIndexIsInvalid() {
        Numbers numbers = new Numbers(new int[]{1, 2});

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> numbers.get(2))
                .withMessageMatching("Index[: ]\\d+.*(Size|length)[: ]\\d+");
    }
}
