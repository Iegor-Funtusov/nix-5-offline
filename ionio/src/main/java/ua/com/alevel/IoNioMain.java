package ua.com.alevel;

import ua.com.type.FileType;

public class IoNioMain {

    public static void main(String[] args) {
        CrudFileService service = new NIOCrudFileService();
//        service.createFile(FileType.FILE_PATH.getPath());
//        service.createDir(FileType.TEMP_DIR_PATH.getPath());
//        service.delete(FileType.DIR_PATH.getPath());
//        service.move(FileType.FILE_PATH.getPath(), FileType.COPY_FILE_PATH.getPath());
//        service.read(FileType.DIR_PATH.getPath());
//        service.delete(FileType.DIR_PATH.getPath());
        service.move(FileType.DIR_PATH.getPath(), FileType.TEMP_DIR_PATH.getPath());
    }
}
