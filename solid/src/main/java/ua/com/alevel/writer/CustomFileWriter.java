package ua.com.alevel.writer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CustomFileWriter implements AbstractWriter {

    private String pathToFile;

    public CustomFileWriter(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public CustomFileWriter() { }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    @Override
    public void write(String text) {
        try(PrintWriter printWriter = new PrintWriter(pathToFile)) {
            printWriter.write(text);
            printWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("can not write to file");
        }
    }
}
