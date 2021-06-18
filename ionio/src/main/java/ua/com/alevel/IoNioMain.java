package ua.com.alevel;

import ua.com.type.FileType;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class IoNioMain {

    public static void main(String[] args) {

        CsvTest csvTest = new CsvTest();
        csvTest.test();
//        new JsonTest().oneObject();
//        new JsonTest().someJson();

//        InputStream inputStream;       Reader reader;
//        OutputStream outputStream;     Writer writer;
//
//        FileInputStream fileInputStream;             BufferedReader bufferedReader;
//        FileOutputStream fileOutputStream;           BufferedWriter bufferedWriter;
//        ObjectInputStream objectInputStream;         FileReader fileReader;
//        ObjectOutputStream objectOutputStream;       FileWriter fileWriter;
//        ByteArrayInputStream byteArrayInputStream;
//        ByteArrayOutputStream byteArrayOutputStream;
//        DataInputStream dataInputStream;
//        DataOutputStream dataOutputStream;
//        BufferedInputStream bufferedInputStream;
//        BufferedOutputStream bufferedOutputStream;

//        CrudFileService service = new NIOCrudFileService();
//        service.createFile(FileType.FILE_PATH.getPath());
//        service.createDir(FileType.TEMP_DIR_PATH.getPath());
//        service.delete(FileType.DIR_PATH.getPath());
//        service.move(FileType.FILE_PATH.getPath(), FileType.COPY_FILE_PATH.getPath());
//        service.read(FileType.DIR_PATH.getPath());
//        service.delete(FileType.DIR_PATH.getPath());
//        service.move(FileType.DIR_PATH.getPath(), FileType.TEMP_DIR_PATH.getPath());
    }
}
