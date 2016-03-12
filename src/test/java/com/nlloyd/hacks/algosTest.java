package com.nlloyd.hacks;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void test_cutTheSticks(){
        Collection<Integer> in = Arrays.asList(5, 4, 4, 2, 2, 8);

        Collection<Integer> out1 = algos.cutTheSticks(in);
        Collection<Integer> out2 = algos.cutTheSticks(out1);
        Collection<Integer> out3 = algos.cutTheSticks(out2);
        Collection<Integer> out4 = algos.cutTheSticks(out3);

        assertEquals(6, in.size());
        assertEquals(4, out1.size());
        assertEquals(2, out2.size());
        assertEquals(1, out3.size());
        assertEquals(0, out4.size());
    }

    @Test
    public void test_chocolateFeast(){

        int out1 = algos.chocolateFeast(10, 2, 5);
        int out2 = algos.chocolateFeast(12, 4, 4);
        int out3 = algos.chocolateFeast(6, 2, 2);

        assertEquals(6, out1);
        assertEquals(3, out2);
        assertEquals(5, out3);
    }

    @Test
    public void test_caeserCipher(){
        String in1 = "middle-Outz";
        int off1 = 2;
        String in2 = "www.abc.xy";
        int off2 = 87;

        String out = algos.caesarCipher(in1, off1);
        String out2 = algos.caesarCipher(in2, off2);

        assertEquals("okffng-Qwvb", out);
        assertEquals("fff.jkl.gh", out2);
    }

}
