package ua.com.alevel;

import ua.com.alevel.reder.AbstractReader;
import ua.com.alevel.writer.AbstractWriter;

import java.io.BufferedReader;

public class StartApp implements Start {

    private String pathToFile;

    @Inject
    private BufferedReader bufferedReader;

    @Inject
    private AbstractReader consoleReader;

    @Inject
    private AbstractWriter consoleWriter;

    @Inject
    private AbstractReader customFileReader;

    @Inject
    private AbstractWriter customFileWriter;

    public void start() {
//        consoleToFile();
//        fileToConsole();
    }

    private void consoleToFile() {
        pathToFile = consoleReader.read();
        String text = consoleReader.read();
        customFileWriter.write(text);
    }

    private void fileToConsole() {
        String text = customFileReader.read();
        consoleWriter.write(text);
    }
}
