package com.xmas.Day6;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day6 {
    //the start of a packet is indicated by a sequence of four characters that are all different.
    //Identify the first position where the four most recently received characters were all different.

    public static final String file = "src/com/xmas/Day6/input6.txt";

    public static void main(String[] args) throws IOException {

        int part1 = 0;
        int part2 = 0;

        String data = Util.parseFile(file);

        for (int i = 0; i < data.length(); i++) {

            String substring = data.substring(i, i + 4);
            if (!isRepeated(substring)) {
                part1 = i + 4;
                break;
            }
        }

        for (int i = 0; i < data.length(); i++) {

            String substring = data.substring(i, i + 14);
            if (!isRepeated(substring)) {
                part2 = i + 14;
                break;
            }


        }
        System.out.println(part1);
        System.out.println(part2);

    }

    public static boolean isRepeated(String packet) {
        return packet.length() != packet.chars().mapToObj(c -> c).collect(Collectors.toSet()).size();

    }
}
