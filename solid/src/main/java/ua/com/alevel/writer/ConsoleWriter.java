package ua.com.alevel.writer;

public class ConsoleWriter implements AbstractWriter {

    @Override
    public void write(String text) {
        System.out.println("text = " + text);
    }
}
