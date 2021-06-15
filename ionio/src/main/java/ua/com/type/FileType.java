package ua.com.type;

public enum FileType {

    FILE_PATH("test.txt"),
    HIDDEN_FILE_PATH(".test.txt"),
    COPY_FILE_PATH("test_new.txt"),
    DIR_PATH("test"),
    TEMP_DIR_PATH("temp_test"),
    DIRS_PATH("test/test1/test2");

    private final String path;

    FileType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
