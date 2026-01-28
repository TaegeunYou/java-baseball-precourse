package baseball.global.message;

public enum ErrorMessage {
    BLANK_INPUT("빈 문자열이 입력되었습니다."),
    INVALID_INPUT_LENGTH("3개를 입력해주세요"),
    NON_DIGIT_CHARACTER_FOUND("모두 숫자로 입력해주세요"),
    NON_POSITIVE_NUMBER_FOUND("모두 0보다 큰 양수로 입력해주세요."),
    DUPLICATE_NUMBER_FOUND("서로 다른 숫자로 입력해주세요."),
    ;

    private final static String PREFIX = "[ERROR]";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + " " + this.message;
    }
}
