package com.xmas.Day6;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Util {

    public static String parseFile(String fileName) throws IOException {

        Scanner scanner = new Scanner(new FileReader(fileName));
        String rawData = "";
        while (scanner.hasNext()) {

            rawData = scanner.nextLine();

        }
        scanner.close();

        return rawData;

    }
}
