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
        process(computerNumbers);
    }

    public void process(ComputerNumbers computerNumbers) {
        Numbers inputNumbers = requestNumbers();
        Result result = new Result(computerNumbers, inputNumbers);
        outputView.printlnStrikeAndBall(result);
        if (result.getResultType() != ResultType.THREE_STRIKE) {
            process(computerNumbers);
            return;
        }
        outputView.printlnThreeStrike();
        if (inputView.enterFinishType() == 1) {
            run();
        }
    }

    private Numbers requestNumbers() {
        outputView.printMessage(InputMessage.INPUT_NUMBERS.getMessage());
        try {
            Numbers numbers = new Numbers(inputView.enterNumbers());
            return numbers;
        } catch (CustomException e) {
            outputView.printlnMessage(e.getMessage());
            return requestNumbers();
        }
    }
}
