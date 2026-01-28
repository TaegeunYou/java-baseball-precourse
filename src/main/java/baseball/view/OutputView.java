package baseball.view;

import baseball.domain.Result;
import baseball.domain.ResultType;

public class OutputView {
    public void printlnMessage(String message) {
        System.out.println(message);
    }

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printEmptyLine() {
        System.out.println();
    }

    public void printlnMessageWithEmptyLine(String message) {
        printlnMessage(message);
        printEmptyLine();
    }

    public void printlnStrikeAndBall(Result result) {
        StringBuilder sb = new StringBuilder();
        appendStrike(result, sb);
        appendBall(result, sb);
        printlnMessage(sb.toString());
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

    public void printlnThreeStrike() {
        printlnMessage("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
        printlnMessage("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
