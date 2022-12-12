package com.xmas.Day4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day4 {

    // One line contains two pairs each of a certain range. Determine if the pair engulfs the other
    // Return a sum of how many times this occurs

    // Grab data split by , and individual by -
    // Inspect the section to determine if engulfed

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("src/com/xmas/Day4/input4.txt"));
        List<String> elf1Job = new ArrayList<>();
        List<String> elf2Job = new ArrayList<>();
        int sum = 0;

        while(scanner.hasNext()){

            String line = scanner.nextLine();
            String[] pair = line.split(",");
            elf1Job.add(pair[0]);
            elf2Job.add(pair[1]);

        }

        sum = isEngulfed(elf1Job, elf2Job);

        System.out.println(sum);
    }



    public static int isEngulfed(List<String> elf1, List<String> elf2){

        int sum = 0;
        for(int i = 0; i < elf1.size(); i++){

            String[] section1  = elf1.get(i).split("-");
            int lower1 = Integer.parseInt(section1[0]);
            int upper1 = Integer.parseInt(section1[1]);

            String[] section2  = elf2.get(i).split("-");
            int lower2 = Integer.parseInt(section2[0]);
            int upper2 = Integer.parseInt(section2[1]);

            if(checkRange(lower1, upper1, lower2, upper2)){
                sum++;
            }
        }
        return sum;
    }

    public static boolean checkRange(int lower1, int upper1, int lower2, int upper2){
       // (s1 <= e2) && (s2 <= e1)

        // first 6-95 second 6-94
        return (lower1 <= lower2) && (upper1 <= upper2) || (lower2 >= lower1) && (upper2 >= lower1) ;

    }


}
