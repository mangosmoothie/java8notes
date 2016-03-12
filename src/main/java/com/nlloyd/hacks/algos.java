package com.nlloyd.hacks;

import java.util.Collection;
import java.util.stream.Collectors;

public class algos {

    /**
     * Given an integer, NN, traverse its digits (dd1,dd2,...,ddn) and determine how many digits evenly divide NN
     * (i.e.: count the number of times NN divided by each digit ddi has a remainder of 00).
     * Print the number of evenly divisible digits.
     */
    public static String findDigits(String number) {
        final int num = Integer.parseInt(number);
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
    public static int sherlockAndSquares(final int beg, final int end) {
        final double b = Math.sqrt((double) beg);
        final double e = Math.sqrt((double) end);
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
    public static Collection<Integer> cutTheSticks(final Collection<Integer> rods) {
        final int min = rods.stream().min(Integer::compare).get();
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
    public static int chocolateFeast(final int cash, final int cost, final int free){
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

    //65 - 90 caps 97 - 122 z

    /**
     * Julius Caesar protected his confidential information by encrypting it in a cipher.
     * Caesar's cipher rotated every letter in a string by a fixed number, KK, making it unreadable by his enemies.
     * Given a string, SS, and a number, KK, encrypt SS and print the resulting string.
     */
    public static String caesarCipher(final String in, final int offset){
        int[] out = in.chars().map(x -> encode(x, offset % 26)).toArray();
        return new String(out, 0, out.length);
    }

    public static int encode(final int charCd, final int offset){
        if(charCd < 91 && charCd > 64){
            final int out = (charCd + offset) % 91;
            return out < 65 ? out + 65 : out;
        }else if(charCd < 123 && charCd > 96){
            final int out = (charCd + offset) % 123;
            return out < 97 ? out + 97 : out;
        }else{
            return charCd;
        }
    }

//    //caesarCipher main
//    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        scanner.nextInt();
//        String in = scanner.next();
//        int offset = scanner.nextInt();
//        System.out.println(caesarCipher(in, offset));
//    }

}
