package baseball.view;

import baseball.domain.Result;
import baseball.domain.ResultType;

public class OutputView {
    public void printlnMessage(String message) {
        System.out.println(message);
    }

    public void printEmptyLine() {
        System.out.println();
    }

    public void printlnMessageWithEmptyLine(String message) {
        printlnMessage(message);
        printEmptyLine();
    }

    public void printStrikeAndBall(Result result) {
        if (result.getResultType() == ResultType.STRIKE_AND_BALL) {
            StringBuilder sb = new StringBuilder();
            appendStrike(result, sb);
            appendBall(result, sb);
            printlnMessage(sb.toString());
        }
    }

    private void appendStrike(Result result, StringBuilder sb) {
        if (result.getStrike() != 0) {
            sb.append(result.getStrike()).append("스트라이크");
        }
    }

    private void appendBall(Result result, StringBuilder sb) {
        if (result.getBall() != 0) {
            if (!sb.isEmpty()) {
                sb.append(" ");
            }
            sb.append(result.getBall()).append("볼");
        }
    }
}
