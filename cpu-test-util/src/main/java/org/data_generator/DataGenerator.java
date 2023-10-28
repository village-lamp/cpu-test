package org.data_generator;

import java.util.Scanner;

public class DataGenerator {

    public static void main(String[] args) {
        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            args = new String[1];
            args[0] = scanner.nextLine();
        }
        Manager.getManager().work(args[0]);
    }
}
