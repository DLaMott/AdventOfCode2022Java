package com.xmas.Day2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.logging.Logger;

public class Day2 {

    public static void main(String[] args) throws FileNotFoundException {

        int part1=0;
        int part2=0;
        Scanner scanner=new Scanner(new FileReader("src/com/xmas/Day2/input2.txt"));
        ArrayList<Game> games= new ArrayList<>();

        while(scanner.hasNext()) {
            String line=scanner.nextLine();
            String[] data=line.split(" ");
            Game round=new Game(data[0],data[1]);
            games.add(round);

        }

        for(Game game:games) {
            part1+=game.calculateScore1();
            part2+=game.calculateScore2();

        }
        System.out.println("Round one: " + part1);
        System.out.println("Round two " + part2);
        scanner.close();

    }

}

