package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputerNumbers {
    private final Numbers numbers;

    public ComputerNumbers() {
        int[] randomNumbers = generateRandomNumbers();
        this.numbers = new Numbers(randomNumbers);
    }

    private int[] generateRandomNumbers() {
        List<Integer> allNumbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            allNumbers.add(i);
        }
        Collections.shuffle(allNumbers);
        int[] result = {allNumbers.get(0), allNumbers.get(1), allNumbers.get(2)};
        return result;
    }

    public Number get(int idx) {
        return numbers.get(idx);
    }

    public boolean notContain(Number number) {
        return numbers.notContain(number);
    }
}
