package com.xmas.Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day1 {

    public static final String INPUT = "src/com/xmas/Day1/input.txt";

    public static void main(String[] args) {

        Map<Integer,Integer> calorieList = readFileInt(INPUT);

        // Answer 1
        System.out.println(maxUsingIteration(calorieList));

        List<Integer> keys = calorieList.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).limit(3).map(Map.Entry::getValue).collect(Collectors.toList());
        int sum = 0;
        for(Integer i: keys){
            sum += i;
        }

        // Answer two
        System.out.println(sum);
    }

    public static <K, V extends Comparable<V>> V maxUsingIteration(Map<K, V> map) {
        Map.Entry<K, V> maxEntry = null;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue()
                    .compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        return maxEntry.getValue();
    }


    public static Map<Integer, Integer> readFileInt(String string) {
        int sum = 0;
        Integer elfPosition = 1;
        // Todo: change to auto place correct file
        File file = new File(string);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Map<Integer, Integer> elfPerCals = new HashMap<>();
        while (true) {
            assert scanner != null;
            if (!scanner.hasNext()) break;
            String s = scanner.nextLine();
            if(!s.equals("")){
                sum += Integer.parseInt(s);
            }else{
                elfPerCals.put(elfPosition, sum);
                elfPosition++;
                sum = 0;
            }
        }
        return elfPerCals;
    }
}