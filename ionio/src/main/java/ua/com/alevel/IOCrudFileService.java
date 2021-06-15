package ua.com.alevel;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class IOCrudFileService implements CrudFileService {

    @Override
    public void createFile(String pathName) {
        File file = new File(pathName);
        if (pathName.startsWith(".")) {
            setHiddenAttrib(file);
        }
        String absolutePath = file.getAbsolutePath();
        String path1 = file.getPath();
        System.out.println("absolutePath = " + absolutePath);
        System.out.println("path1 = " + path1);
        boolean isFile = false;
        try {
            boolean newFile = file.createNewFile();
            System.out.println("newFile = " + newFile);
            isFile = file.isFile();
            System.out.println("isFile = " + isFile);
            boolean hidden = file.isHidden();
            System.out.println("hidden = " + hidden);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createDir(String pathName) {
        File file = new File(pathName);
        boolean mkdir = file.mkdir();
        System.out.println("mkdir = " + mkdir);
    }

    @Override
    public void createDirs(String pathName) {
        File file = new File(pathName);
        boolean mkdir = file.mkdirs();
        System.out.println("mkdir = " + mkdir);
    }

    @Override
    public void read(String pathName) {
        File file = new File(pathName);
        readAllFile(file);
    }

    @Override
    public void delete(String pathName) {
        try {
            FileUtils.deleteDirectory(new File(pathName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void move(String pathFrom, String pathTo) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        File fileFrom = new File(pathFrom);
        File fileTo = new File(pathTo);
        boolean isRenamed = fileFrom.renameTo(fileTo);
        System.out.println("isRenamed = " + isRenamed);
    }

    private void readAllFile(File file) {
        System.out.println("dir = " + file.getAbsolutePath());
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()) {
                readAllFile(file1);
            } else {
                System.out.println("file = " + file1.getName());
            }
        }
    }

    // only for windows
    private void setHiddenAttrib(File file) {
        try {
            Process p = Runtime.getRuntime().exec("attrib +H " + file.getPath());
            p.waitFor();
            if (file.isHidden()) {
                System.out.println(file.getName() + " hidden attribute is set to true");
            } else {
                System.out.println(file.getName() + " hidden attribute not set to true");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
