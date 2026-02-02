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
        if (result.getResultType() == ResultType.NOTHING) {
            printlnMessage("낫싱");
            return;
        }
        StringBuilder sb = new StringBuilder();
        appendStrike(result.getStrike(), sb);
        appendBall(result.getBall(), sb);
        printlnMessage(sb.toString());
    }

    public void printlnThreeStrike() {
        printlnMessage("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
        printlnMessage("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private void appendStrike(int strike, StringBuilder sb) {
        if (strike != 0) {
            sb.append(strike).append("스트라이크");
        }
    }

    private void appendBall(int ball, StringBuilder sb) {
        if (ball != 0) {
            if (!sb.isEmpty()) {
                sb.append(" ");
            }
            sb.append(ball).append("볼");
        }
    }
}
