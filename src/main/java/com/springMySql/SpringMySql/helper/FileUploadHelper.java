package com.springMySql.SpringMySql.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


@Component
public class FileUploadHelper {

    public final String UPLOAD_DIR = "/Users/ajeetgathala/WorkSpace/SpringBoot/MySqlFirst/src/main/resources/static/images";

    public boolean uploadFile(MultipartFile file) {
        boolean flag = false;

        try {
//            InputStream inputStream = file.getInputStream();
//            byte data[] = new byte[inputStream.available()];
//            inputStream.read(data);
//            FileOutputStream fileOutputStream = new FileOutputStream(UPLOAD_DIR+"/" + file.getOriginalFilename());
//            fileOutputStream.write(data);
//            fileOutputStream.close();
//
            Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR + "/" + file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);

            flag = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return flag;
    }
}
