package com.xmas.Day5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Day5 {

        /*
[W] [V]     [P]
[B] [T]     [C] [B]     [G]
[G] [S]     [V] [H] [N] [T]
[Z] [B] [W] [J] [D] [M] [S]
[R] [C] [N] [N] [F] [W] [C]     [W]
[D] [F] [S] [M] [L] [T] [L] [Z] [Z]
[C] [W] [B] [G] [S] [V] [F] [D] [N]
[V] [G] [C] [Q] [T] [J] [P] [B] [M]
 1   2   3   4   5   6   7   8   9

     */


    public static String[] one = {"V", "C", "D", "R", "Z", "G", "B", "W"};
    public static Stack<String> stack1 = new Stack<>();
    public static String[] two = {"G", "W", "F", "C", "B", "S", "T", "V"};
    public static Stack<String> stack2 = new Stack<>();
    public static String[] three = {"C", "B", "S", "N", "W"};
    public static Stack<String> stack3 = new Stack<>();
    public static String[] four = {"Q", "G", "M", "N", "J", "V", "C", "P"};
    public static Stack<String> stack4 = new Stack<>();
    public static String[] five = {"T", "S", "L", "F", "D", "H", "B"};
    public static Stack<String> stack5 = new Stack<>();
    public static String[] six = {"J", "V", "T", "W", "M", "N"};
    public static Stack<String> stack6 = new Stack<>();
    public static String[] seven = {"P", "F", "L", "C", "S", "T", "G"};
    public static Stack<String> stack7 = new Stack<>();
    public static String[] eight = {"B", "D", "Z"};
    public static Stack<String> stack8 = new Stack<>();
    public static String[] nine = {"M", "N", "Z", "W"};
    public static Stack<String> stack9 = new Stack<>();


    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Intructions> instructions = new ArrayList<>();
        Scanner scanner = new Scanner(new FileReader("src/com/xmas/Day5/input5.txt"));

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.contains("move")) {

                instructions.add(generateInstr(line));
            }
        }

        stack1.addAll(Arrays.stream(one).toList());
        stack2.addAll(Arrays.stream(two).toList());
        stack3.addAll(Arrays.stream(three).toList());
        stack4.addAll(Arrays.stream(four).toList());
        stack5.addAll(Arrays.stream(five).toList());
        stack6.addAll(Arrays.stream(six).toList());
        stack7.addAll(Arrays.stream(seven).toList());
        stack8.addAll(Arrays.stream(eight).toList());
        stack9.addAll(Arrays.stream(nine).toList());

        List<Stack<String>> stacks = new ArrayList<>();
        stacks.add(stack1);
        stacks.add(stack2);
        stacks.add(stack3);
        stacks.add(stack4);
        stacks.add(stack5);
        stacks.add(stack6);
        stacks.add(stack7);
        stacks.add(stack8);
        stacks.add(stack9);

        // Part 1
        //reArrange(stacks, instructions);

        // Part 2
        reArrangeTwo(stacks, instructions);

        System.out.println(result(stacks));

    }

    public static Intructions generateInstr(String instructions) {

        instructions = instructions.replaceAll("[^0-9]+", " ");
        String[] number = instructions.split(" ");
        int amountToMove = Integer.parseInt(number[1]);
        int source = Integer.parseInt(number[2]);
        source = source - 1;
        int dest = Integer.parseInt(number[3]);
        dest = dest - 1;
        return new Intructions(amountToMove, source, dest);
    }

    public static void reArrange(List<Stack<String>> Stacks, ArrayList<Intructions> intructions){

        for(Intructions inst : intructions){
            int move = inst.getDest();
            int amount = inst.getAmountToMove();
            int stack = inst.getSource();


            for(int i = 1; i <= amount; i++){
               String crate = Stacks.get(stack).pop();
               Stacks.get(move).add(crate);
            }
        }
    }

    public static void reArrangeTwo(List<Stack<String>> Stacks, ArrayList<Intructions> intructions){

        for(Intructions inst : intructions){
            int move = inst.getDest();
            int amount = inst.getAmountToMove();
            int stack = inst.getSource();


            String[] deleted = new String[amount];
            for (int i = 1; i <= amount; i++) {

                deleted[i - 1] = Stacks.get(stack).pop();

            }
            for (int i = deleted.length - 1; i >= 0; i--) {
                Stacks.get(move).push(deleted[i]);
            }
        }
    }

    public static String result(List<Stack<String>> stacks) {
        String result = "";
        for (Stack e : stacks) {
            result += e.peek();
        }
        return result;
    }
}
