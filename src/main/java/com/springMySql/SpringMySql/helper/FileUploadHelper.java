package com.springMySql.SpringMySql.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


@Component
public class FileUploadHelper {

    private final String UPLOAD_DIR;

    public FileUploadHelper() throws IOException {
        // Fallback to create directory if the classpath resource doesn't exist
        this.UPLOAD_DIR = Paths.get("src/main/resources/static/images").toAbsolutePath().toString();

        // Ensure the directory exists
        Files.createDirectories(Paths.get(UPLOAD_DIR));
    }

    public boolean uploadFile(MultipartFile file) {
        boolean flag = false;

        try {
            Files.copy(file.getInputStream(),
                    Paths.get(UPLOAD_DIR + "/" + file.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            flag = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return flag;
    }
}

