package baseball.view;

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
}
