package baseball.controller;

import baseball.domain.ComputerNumbers;
import baseball.domain.Numbers;
import baseball.domain.Result;
import baseball.domain.ResultType;
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
        ComputerNumbers computerNumbers = new ComputerNumbers();
        Numbers inputNumbers = requestNumbers();
    }

    private Numbers requestNumbers() {
        outputView.printlnMessage(InputMessage.INPUT_NUMBERS.getMessage());
        try {
            Numbers numbers = new Numbers(inputView.enterNumbers());
            outputView.printEmptyLine();
            return numbers;
        } catch (CustomException e) {
            outputView.printlnMessageWithEmptyLine(e.getMessage());
            return requestNumbers();
        }
    }

    private void checkResult(ComputerNumbers computerNumbers, Numbers inputNumbers) {
        Result result = new Result(computerNumbers, inputNumbers);
        outputView.printStrikeAndBall(result);
        if (result.getResultType() == ResultType.THREE_STRIKE) {
            outputView.printThreeStrikeResult(result);
            return;
        }
        if (result.getResultType() == ResultType.STRIKE_AND_BALL) {

            return;
        }

    }
}
