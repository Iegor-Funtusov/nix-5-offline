package ua.com.alevel.reder;

import java.io.BufferedReader;
import java.io.IOException;

public class ConsoleReader implements AbstractReader {

    private BufferedReader reader;

    public ConsoleReader(BufferedReader reader) {
        this.reader = reader;
    }

    public ConsoleReader() { }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public String read() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("console problem");
        }
    }
}
