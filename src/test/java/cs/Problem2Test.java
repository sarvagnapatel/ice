package cs;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Problem2Test {
    @Test
    public void printPair() throws Exception {
        pprint(10);
        pprint(5);
        pprint(15);
        pprint(20);
    }


    private int[] getRandomIntArray(int size) {
        int[] randoms = new int[size];

        for (int i = 0; i < size; i++) {
            randoms[i] = (int) (Math.random()*15);
        }
        return randoms;
    }

    private void pprint(int size) {
        int[] random = getRandomIntArray(size);
        System.out.println("Array : " + Arrays.toString(random));
        Problem2.printPair(random);
    }

}