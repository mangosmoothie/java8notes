package com.nlloyd.hacks;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Collections;
import java.util.function.Function;

public class algosTest {

    @Test
    public void can_findDigits(){
        String in1 = "12";
        String in2 = "1012";

        String out1 = algos.findDigits(in1);
        String out2 = algos.findDigits(in2);

        assertEquals("2", out1);
        assertEquals("3", out2);
    }

    @Test
    public void test_sherlockAndSquares(){
        int beg1 = 3;
        int end1 = 9;
        int beg2 = 17;
        int end2 = 24;

        int out1 = algos.sherlockAndSquares(beg1, end1);
        int out2 = algos.sherlockAndSquares(beg2, end2);

        assertEquals(2, out1);
        assertEquals(0, out2);
    }

}
