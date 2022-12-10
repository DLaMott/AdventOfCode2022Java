package com.xmas.Day3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Day3 {

    //Median of String separation... List<Characters> firstHalf, List<Characters> secondHalf

    //Lowercase item types a through z have priorities 1 through 26.
    //Uppercase item types A through Z have priorities 27 through 52.

    //Find the item type that appears in both compartments of each rucksack.
    //What is the sum of the priorities of those item types?

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("src/com/xmas/Day3/input3.txt"));


        List<char[]> firstHalf = new ArrayList<>();
        List<char[]> secondHalf = new ArrayList<>();
        List<String> idk = new ArrayList<>();

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            idk.add(line);

            final int mid = line.length() / 2; //get the middle of the String
            String[] parts = {line.substring(0, mid), line.substring(mid)};
            firstHalf.add(parts[0].toCharArray()); //first part
            secondHalf.add(parts[1].toCharArray());


        }
        // sfDRhjhHsHhgW          PJvPmmQnmPqnW
        System.out.println(firstHalf.size() + secondHalf.size());
        int sum = 0;
        for (int i = 0; i < firstHalf.size(); i++) {
            char[] one = firstHalf.get(i);
            char[] two = secondHalf.get(i);

            Set<Character> set1 = new HashSet<>();
            Set<Character> set2 = new HashSet<>();

            for (char c : one) {
                set1.add(c);

            }

            for (char c : two) {
                set2.add(c);

            }
            set1.retainAll(set2);
            char c = set1.toArray(new Character[0])[0];
            sum += calcWeight(c);

        }

        int sum2 = 0;

        for(int i = 0; i < idk.size(); i = i +3){

            Set<Character> set1 = new HashSet<>();
            Set<Character> set2 = new HashSet<>();
            Set<Character> set3 = new HashSet<>();

            for (char c : idk.get(i).toCharArray()) {
                set1.add(c);

            }

            for (char c : idk.get(i+1).toCharArray()) {
                set2.add(c);

            }

            for (char c : idk.get(i+2).toCharArray()) {
                set3.add(c);

            }
            set1.retainAll(set2);
            set1.retainAll(set3);

            sum2 += calcWeight(set1.toArray(new Character[0])[0]);

        }

        System.out.println(sum);
        System.out.println(sum2);
    }


    private static int calcWeight(char c) {

        int value = (int) c;
        // lowercase
        if (value > 97) {
            return c - 96; // a==1
        }
        // uppercase
        else {
            return c - 38; // A=27

        }
    }

}
