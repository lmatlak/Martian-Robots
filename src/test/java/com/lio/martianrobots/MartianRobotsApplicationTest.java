package com.lio.martianrobots;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MartianRobotsApplicationTest {

    @Test
    public void test() throws IOException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        MartianRobotsApplication.main(new String[]{"./src/main/resources/input_instructions_file.txt"});
        String output = outContent.toString();

        assertEquals(true, output.contains("1 1 E"));
        assertEquals(true, output.contains("3 3 N LOST"));
        assertEquals(true, output.contains("2 3 S"));
    }
}
