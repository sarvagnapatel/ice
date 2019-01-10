package cs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem2 {

    private static int SUM = 7;

    public static void main(String[] args) {
        //mapping args to int array
        int[] array = Arrays.stream(args).mapToInt(Integer::parseInt).toArray();
        printPair(array);
    }

    static void printPair(int[] array) {
        int numElements = array.length;

        //no pair if num of elements < 2
        if (numElements < 2) {
            return;
        }

        Set set = new HashSet(numElements);

        // this set will hold lower of the paired variable, in case there are duplicates
        Set paired = new HashSet(numElements);

        for (int i : array) {
            int target = SUM - i;

            //Storing if there's no current target element
            if (!set.contains(target)) {
                set.add(i);
            } else {
                //hold lower of the paired element so do not print duplicated pair, if there are duplicate elements
                int pairedElement = i < target? i: target;
                if (paired.contains(pairedElement)) {
                    continue;
                } else {
                    paired.add(pairedElement);
                }
                System.out.printf("(%d, %d) %n", i, target);
            }
        }
    }

    class Pair {
        int first;
        int second;
        protected Pair(int i, int j) {
            if (i < j) {
                first = i;
                second = j;
            }
        }
    }
}
