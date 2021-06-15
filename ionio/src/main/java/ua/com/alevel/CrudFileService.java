package ua.com.alevel;

public interface CrudFileService {

    void createFile(String pathName);
    void createDir(String pathName);
    void createDirs(String pathName);
    void read(String pathName);
    void delete(String pathName);
    void move(String pathFrom, String pathTo);
}
