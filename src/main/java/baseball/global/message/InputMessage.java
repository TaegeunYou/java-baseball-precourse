package baseball.global.message;

public enum InputMessage {

    INPUT_NUMBERS("숫자를 입력해주세요 : ")
    ;

    private String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
