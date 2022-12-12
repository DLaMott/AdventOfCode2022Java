package com.xmas.Day5;

public class Intructions {

    private int amountToMove;
    private int source;
    private int dest;

    public Intructions() {
        super();
    }

    public Intructions(int amountToMove, int source, int dest) {
        super();
        this.amountToMove = amountToMove;
        this.source = source;
        this.dest = dest;
    }

    @Override
    public String toString() {
        return "Instruction [amountToMove=" + amountToMove + ", source=" + source + ", dest=" + dest + "]";
    }

    public int getAmountToMove() {
        return amountToMove;
    }


    public int getSource() {
        return source;
    }


    public int getDest() {
        return dest;
    }




}
