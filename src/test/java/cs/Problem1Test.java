package cs;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Problem1Test {

    @Test
    public void isCusip() throws Exception {
        String str1 = "ABCD1234";
        Assert.assertTrue(Problem1.isCusip(str1));

        str1 = "WXYZ1234";
        Assert.assertTrue(Problem1.isCusip(str1));

        str1 = "12345678";
        Assert.assertTrue(Problem1.isCusip(str1));

        str1 = "WXYZABCD";
        Assert.assertTrue(Problem1.isCusip(str1));

        str1 = "wxyzabcd";
        Assert.assertTrue(Problem1.isCusip(str1));

        str1 = "ABC";
        Assert.assertFalse(Problem1.isCusip(str1));
    }

    @Test
    public void convertToDouble() {
        String str1 = "123.123";
        Assert.assertEquals(123.123, Problem1.convertToDouble(str1, 123d), 0.000001);

        str1 = "ABC";
        Assert.assertEquals(123, Problem1.convertToDouble(str1, 123d), 0.000001);

    }

    @Test
    public void testAsExpectedFile() throws IOException {
        File f = File.createTempFile("FileTest" +System.currentTimeMillis(), ".txt");

        PrintWriter writer = new PrintWriter(f);

        writer.println("ABCD1234");

        writer.println("123.123");
        writer.println("123.120");
        writer.println("123.118");
        writer.close();

        Problem1.readFile(f.getPath());

        f.delete();

    }

    @Test
    public void testAsWithoutCusip() throws IOException {
        File f = File.createTempFile("FileTest" +System.currentTimeMillis(), ".txt");

        PrintWriter writer = new PrintWriter(f);

        writer.println("123.123");
        writer.println("123.120");
        writer.println("123.118");
        writer.close();

        Problem1.readFile(f.getPath());

        f.delete();

    }

    @Test
    public void testAsWithoutFirstLineIsNotCusip() throws IOException {
        File f = File.createTempFile("FileTest" +System.currentTimeMillis(), ".txt");

        PrintWriter writer = new PrintWriter(f);

        writer.println("123.123");
        writer.println("ABCD1234");
        writer.println("123.120");
        writer.println("123.118");
        writer.close();

        Problem1.readFile(f.getPath());

        f.delete();

    }


    @Test
    public void testWithOnlyCusip() throws IOException {
        File f = File.createTempFile("FileTest" +System.currentTimeMillis(), ".txt");

        PrintWriter writer = new PrintWriter(f);

        writer.println("ABCD1234");
        writer.close();

        Problem1.readFile(f.getPath());

        f.delete();

    }


    @Test
    public void testWithMultipleCusips() throws IOException {
        File f = File.createTempFile("FileTest" +System.currentTimeMillis(), ".txt");

        PrintWriter writer = new PrintWriter(f);

        writer.println("ABCD1234");

        writer.println("123.123");
        writer.println("123.120");
        writer.println("123.118");

        writer.println("WXYZ1234");

        writer.println("12.123");
        writer.println("12.120");
        writer.println("12.118");


        writer.close();

        Problem1.readFile(f.getPath());

        f.delete();

    }

    @Test
    public void testWithMultipleCusipsAndGarbageCusip() throws IOException {
        File f = File.createTempFile("FileTest" +System.currentTimeMillis(), ".txt");

        PrintWriter writer = new PrintWriter(f);

        writer.println("ABCD1234");

        writer.println("123.123");
        writer.println("123.120");
        writer.println("123.118");

        writer.println("WXYZ12341");

        writer.println("12.123");
        writer.println("12.120");
        writer.println("12.118");


        writer.close();

        Problem1.readFile(f.getPath());

        f.delete();

    }

    @Test
    public void testWithMultipleCusipsAndNoValueCusip() throws IOException {
        File f = File.createTempFile("FileTest" +System.currentTimeMillis(), ".txt");

        PrintWriter writer = new PrintWriter(f);

        writer.println("ABCD1234");

        writer.println("123.123");
        writer.println("123.120");
        writer.println("123.118");

        writer.println("WXYZ1233");
        writer.println("WXYZ1234");

        writer.println("12.123");
        writer.println("12.120");
        writer.println("12.118");


        writer.close();

        Problem1.readFile(f.getPath());

        f.delete();

    }

}