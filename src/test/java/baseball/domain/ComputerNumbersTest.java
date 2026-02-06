package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ComputerNumbersTest {

    @Test
    void notContain_returnsFalse_forExistingNumberInstance() {
        ComputerNumbers computerNumbers = new ComputerNumbers();

        Number existingNumber = computerNumbers.get(0);

        assertThat(computerNumbers.notContain(existingNumber)).isFalse();
    }

    @Test
    void get_throwsIndexOutOfBounds_whenIndexIsInvalid() {
        ComputerNumbers computerNumbers = new ComputerNumbers();

        assertThatThrownBy(() -> computerNumbers.get(3))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageMatching("Index[: ]\\d+.*(Size|length)[: ]\\d+");
    }
}
