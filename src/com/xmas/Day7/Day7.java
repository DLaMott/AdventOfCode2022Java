package com.xmas.Day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class Day7 {

    static long total = 0;
    static Long smallestDirSize;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/com/xmas/Day7/input7.txt"));
        String line;
        Directory directory = new Directory("home", null);


        // Gross but it works

        while ((line = reader.readLine()) != null) {
            if (line.startsWith("$ cd")) {
                String nextDir = line.split(" ")[2];
                if (Objects.equals(nextDir, "/")) {
                    while (directory.getHeadDirectory() != null) {
                        directory = directory.getHeadDirectory();
                    }
                } else if (Objects.equals(nextDir, "..")) {
                    directory = directory.getHeadDirectory();
                } else {
                    directory = directory.findDir(line.split(" ")[2]);
                }
            } else if (line.startsWith("dir ")) {
                directory.addDirectory(new Directory(line.substring("dir ".length()), directory));
            } else if (!line.startsWith("$")) {
                int size = Integer.parseInt(line.split(" ")[0]);
                directory.addFile(new File(size));
            }
        }

        while (directory.getHeadDirectory() != null)
            directory = directory.getHeadDirectory();

        directory.setSize();
        directory.findSmallDirs(100000);
        System.out.println("Total size of dirs with size >= 100000: " + total);
        total = directory.getSize();
        System.out.println("Total size: " + total);
        directory.getRidOfSmallestDir(70000000 - total);
        System.out.println("Smallest dir to get rid of: " + smallestDirSize);

    }


}



