package ua.com.alevel.reder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomFileReader implements AbstractReader {

    private String file;

    public CustomFileReader(String file) {
        this.file = file;
    }

    public CustomFileReader() { }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public String read() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("file not found");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
