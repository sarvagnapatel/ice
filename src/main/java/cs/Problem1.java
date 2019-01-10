package cs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Problem1 {

    //check for alpha numeric and 8 character long pattern
    private static Pattern CUSIP_PATTERN = Pattern.compile("^[a-zA-Z0-9]{8}$");

    //args[0] = path of the file
    public static void main(String[] args) {
        readFile(args[0]);
    }

    static void readFile(final String path) {
        String currentCusip = null;
        String previousCusip = null;
        double currentTick = 0D;

        //This could have been easier with Scanner, but it is a heavier object.
        // So BufferedReaders seems like a good solution here for what we need.
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            //read file line one by one. File can be large so this would prevent getting out of memory error

            for (String currentLine; (currentLine = br.readLine()) != null; ) {
                if (isCusip(currentLine)) {
                    //swap the previous cusip with current cusip
                    previousCusip = currentCusip;
                    if (previousCusip != null) {
                        print(currentCusip, currentTick);
                        //swapping current tick to 0 for the new cusip
                        currentTick = 0d;
                    }
                    currentCusip = currentLine;
                } else { //if not cusip then it's tick
                    currentTick = convertToDouble(currentLine, currentTick);
                }
            }
            //at the end of the file print the latest tick for the last cusip
            if (currentCusip != null) {
                print(currentCusip, currentTick);
            }
        } catch (IOException e) {
            System.out.println("Problem processing file");
        }
    }

    static void print(String currentCusip, double currentTick) {
        System.out.println("Cusip " + currentCusip + " Tick " + currentTick);
    }

    //Check if string passes cusip pattern
    static boolean isCusip(final String value) {
        return CUSIP_PATTERN.matcher(value).matches();
    }

    //convert string to double. Use default value in case of exception
    static double convertToDouble(final String value, final double defaultValue) {
        try {
            return Double.parseDouble(value);
        } catch (Exception ex) {
            System.out.println("Error occured converting to double. Using default value");
            return defaultValue;
        }
    }
}
