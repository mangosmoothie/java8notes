package com.nlloyd.hacks;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class algos {

    /**
     * Given an integer, NN, traverse its digits (dd1,dd2,...,ddn) and determine how many digits evenly divide NN
     * (i.e.: count the number of times NN divided by each digit ddi has a remainder of 00).
     * Print the number of evenly divisible digits.
     */
    public static String findDigits(String number) {
        int num = Integer.parseInt(number);
        return Long.toString(
                number.chars()
                        .map(Character::getNumericValue)
                        .filter(c -> c != 0 && num % c == 0)
                        .count());
    }

//    //findDigits main
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Stream.generate(scanner::next).limit(scanner.nextInt()).forEach(x -> System.out.println(findDigits(x)));
//    }

    /**
     * Watson gives two integers (AA and BB) to Sherlock and asks if he can
     * count the number of square integers between AA and BB (both inclusive).
     */
    public static int sherlockAndSquares(int beg, int end) {
        double b = Math.sqrt((double) beg);
        double e = Math.sqrt((double) end);
        return ((int) Math.floor(e) - (int) Math.ceil(b)) + 1;
    }

//    //sherlockAndSquares main
//    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        int times = scanner.nextInt();
//        Collections.nCopies(times, null).forEach(x -> System.out.println(
//                Integer.toString(
//                        sherlockAndSquares(scanner.nextInt(), scanner.nextInt()))));
//    }

    /**
     * You are given NN sticks, where the length of each stick is a positive integer.
     * A cut operation is performed on the sticks such that all of them are reduced by the length of the smallest stick.
     */
    public static Collection<Integer> cutTheSticks(Collection<Integer> rods) {
        int min = rods.stream().min(Integer::compare).get();
        return rods.stream().map(x -> x - min).filter(x -> x > 0).collect(Collectors.toList());
    }

//    //cutTheSticks main
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Collection<Integer> in = Stream.generate(scanner::nextInt).limit(scanner.nextInt())
//                .collect(Collectors.toList());
//        while(in.size() > 0) {
//            System.out.println(in.size());
//            in = cutTheSticks(in);
//        }
//
//    }

    /**
     * Little Bob loves chocolate, and he goes to a store with $N$N in his pocket. The price of each chocolate is $C$C.
     * The store offers a discount: for every MM wrappers he gives to the store, he gets one chocolate for free.
     * How many chocolates does Bob get to eat?
     */
    public static int chocolateFeast(int cash, int cost, int free){
        int totalCandies = cash / cost;
        int wrappers = totalCandies;
        while(wrappers / free > 0){
            int newCandies = wrappers / free;
            totalCandies += newCandies;
            wrappers = wrappers % free + newCandies;
        }
        return totalCandies;
    }

//    //chocolateFeast main
//    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        Stream.generate(() -> new Integer[]{scanner.nextInt(), scanner.nextInt(), scanner.nextInt()})
//                .limit(scanner.nextInt())
//                .forEach(x -> System.out.println(chocolateFeast(x[0], x[1], x[2])));
//    }

}
