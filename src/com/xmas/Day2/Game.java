package com.xmas.Day2;

public class Game {

    private static final int ROCK = 1;
    private static final int PAPER = 2;
    private static final int SCISSORS = 3;

    private String elf;
    private String me;

    public Game(String villain, String hero) {
        super();
        this.elf = villain;
        this.me = hero;
    }

    // 0lose,3 point draw,6 winning
    private int result(int elf, int me) {

        if (me - elf == 1 || me - elf == -2) {
            return 6;
        }

        if (elf - me == 1 || elf - me == -2) {
            return 0;
        }

        return 3;

    }

    private int result2(int elf, String me) {
        int result = 0;
        if (me.equals("X")) {
            if (elf != 1) {
                result = elf - 1;
            } else {
                result = 3;
            }
        }
        if (me.equals("Y")) {
            result = elf + 3;
        }
        if (me.equals("Z")) {
            result = 6;
            if (elf != 3) {
                result += elf + 1;
            } else {
                result += 1;
            }

        }

        return result;
    }

    private int pointFromString(String symbol) {
        if (symbol.equals("A") || symbol.equals("X"))
            return ROCK;
        if (symbol.equals("B") || symbol.equals("Y"))
            return PAPER;
        if (symbol.equals("C") || symbol.equals("Z"))
            return SCISSORS;
        return 0;
    }

    public int calculateScore1() {

        return pointFromString(me) + result(pointFromString(elf), pointFromString(me));
    }

    public int calculateScore2() {

        return result2(pointFromString(elf), me);
    }
}
