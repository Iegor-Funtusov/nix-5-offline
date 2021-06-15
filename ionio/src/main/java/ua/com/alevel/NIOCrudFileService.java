package ua.com.alevel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NIOCrudFileService implements CrudFileService {

    @Override
    public void createFile(String pathName) {
        Path path = Paths.get(pathName);
        try {
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createDir(String pathName) {
        Path path = Paths.get(pathName);
        try {
            // /tmp
            if (!path.toFile().exists()) {
                Files.createDirectory(path);
            }
            Files.createTempDirectory(pathName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createDirs(String pathName) {
        Path path = Paths.get(pathName);
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void read(String pathName) {
        Set<String> files;
        try {
            Stream<Path> pathStream = Files.walk(Paths.get(pathName));
            files = pathStream
                    .map(Path::toFile)
                    .filter(File::isFile)
                    .map(File::getName)
                    .filter(n -> n.startsWith("eee"))
                    .collect(Collectors.toSet());

            System.out.println("files = " + files);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String pathName) {
        Path path = Paths.get(pathName);
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void move(String pathFrom, String pathTo) {
        Path from = Paths.get(pathFrom);
        Path to = Paths.get(pathTo);
        try {
            Files.move(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
