package baseball.view;

import baseball.global.exception.CustomException;
import baseball.global.message.ErrorMessage;

import java.util.Scanner;

public class InputView {

    public int[] enterNumbers() {
        String input = readLine();
        validateStringFormat(input);
        int[] nums = validateNumberFormat(input);
        return nums;
    }

    public int enterFinishType() {
        String input = readLine();
        int num = parseFinishType(input);
        return num;
    }

    private int parseFinishType(String input) {
        if (input.length() != 1 || !Character.isDigit(input.charAt(0))) {
            throw CustomException.of(ErrorMessage.INVALID_FINISH_INPUT);
        }
        int num = input.charAt(0) - '0';
        if (num != 1 && num != 2) {
            throw CustomException.of(ErrorMessage.INVALID_FINISH_INPUT);
        }
        return num;
    }

    private void validateStringFormat(String str) {
        if (isEmptyOrBlank(str)) {
            throw CustomException.of(ErrorMessage.BLANK_INPUT);
        }
        if (str.length() != 3) {
            throw CustomException.of(ErrorMessage.INVALID_INPUT_LENGTH);
        }
    }

    private int[] validateNumberFormat(String str) {
        int[] nums = new int[3];
        for (int i = 0; i < 3; i++) {
            validateDigit(str.charAt(i));
            int num = str.charAt(i) - '0';
            validatePositiveNumber(num);
            nums[i] = num;
        }
        validateDuplicate(nums);
        return nums;
    }

    private void validateDigit(char c) {
        if (!Character.isDigit(c)) {
            throw CustomException.of(ErrorMessage.NON_DIGIT_CHARACTER_FOUND);
        }
    }

    private void validatePositiveNumber(int num) {
        if (num <= 0) {
            throw CustomException.of(ErrorMessage.NON_POSITIVE_NUMBER_FOUND);
        }
    }

    private void validateDuplicate(int[] arr) {
        if (hasDuplicate(arr)) {
            throw CustomException.of(ErrorMessage.DUPLICATE_NUMBER_FOUND);
        }
    }

    private boolean isEmptyOrBlank(String str) {
        return str == null || str.isBlank();
    }

    private static boolean hasDuplicate(int[] arr) {
        return arr[0] == arr[1] || arr[0] == arr[2] || arr[1] == arr[2];
    }

    private String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
