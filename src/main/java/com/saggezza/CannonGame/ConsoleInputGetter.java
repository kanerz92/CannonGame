package com.saggezza.CannonGame;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleInputGetter {
    private final Scanner scanner;
    private final PrintStream out;

    public ConsoleInputGetter(InputStream in, PrintStream out) {
        this.scanner = new Scanner(in);
        this.out = out;
    }

    public String ask(String message) {
        out.println(message);
        return scanner.nextLine();
    }
}
