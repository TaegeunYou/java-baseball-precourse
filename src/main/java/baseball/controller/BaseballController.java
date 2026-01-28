package baseball.controller;

import baseball.global.exception.CustomException;
import baseball.global.message.InputMessage;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        requestNumbers();
    }

    private void requestNumbers() {
        outputView.printlnMessage(InputMessage.INPUT_NUMBERS.getMessage());
        try {
            inputView.enterNumbers();
        } catch (CustomException e) {

        }
    }
}
