package com.nlloyd.hacks;

import java.util.Collections;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class algos {

    /**
     * Given an integer, NN, traverse its digits (dd1,dd2,...,ddn) and determine how many digits evenly divide NN
     * (i.e.: count the number of times NN divided by each digit ddi has a remainder of 00).
     * Print the number of evenly divisible digits.
     */
    public static String findDigits(String number){
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
//        int times = scanner.nextInt();
//        Collections.nCopies(times, null).forEach(x -> System.out.println(findDigits(scanner.next())));
//    }

    /**
     * Watson gives two integers (AA and BB) to Sherlock and asks if he can
     * count the number of square integers between AA and BB (both inclusive).
     */
    public static int sherlockAndSquares(int beg, int end){
        return (int)IntStream.range(beg, end + 1)
                .filter(x -> Math.round(Math.sqrt((double)x)) == Math.sqrt((double)x))
                .count();
    }

    //sherlockAndSquares main
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        Collections.nCopies(times, null).forEach(x -> System.out.println(
                Integer.toString(
                        sherlockAndSquares(scanner.nextInt(), scanner.nextInt()))));
    }

}
