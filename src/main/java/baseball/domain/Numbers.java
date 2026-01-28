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

    public Number get(int idx) {
        return numbers.get(idx);
    }

    public boolean notContain(Number inputNumber) {
        for (Number number: numbers) {
            if (number.isSameValue(inputNumber)) {
                return false;
            }
        }
        return true;
    }

    public int size() {
        return numbers.size();
    }
}
