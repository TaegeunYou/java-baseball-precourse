package baseball.view;

import java.io.Console;
import java.util.Scanner;

public class InputView {
    public void enterNumbers() {
        String input = readLine();
    }

    private String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
