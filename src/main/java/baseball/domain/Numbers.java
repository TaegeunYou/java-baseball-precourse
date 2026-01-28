package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    public Numbers(int[] arr) {
        numbers = new ArrayList<>();
        for (int num : arr) {
            numbers.add(new Number(num));
        }
    }

    private void result() {

    }
}
