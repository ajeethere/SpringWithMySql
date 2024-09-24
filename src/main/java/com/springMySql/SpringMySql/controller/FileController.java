package com.springMySql.SpringMySql.controller;

import com.springMySql.SpringMySql.errors.ErrorResponse;
import com.springMySql.SpringMySql.helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Objects;

@RestController
public class FileController {

    @Autowired
    FileUploadHelper fileUploadHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return new ResponseEntity<>(new ErrorResponse(HttpStatus.NO_CONTENT, "No file selected!"), HttpStatus.NO_CONTENT);
            } else if (fileUploadHelper.uploadFile(file)) {
                return new ResponseEntity<>(new ErrorResponse(HttpStatus.OK,"File uploaded successfully!"),HttpStatus.OK);
//                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(Objects.requireNonNull(file.getOriginalFilename())).toUriString());
            } else {
                return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to upload file!"), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to upload file!:-" + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping("/upload-video")
    public ResponseEntity<?> uploadVideo(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return new ResponseEntity<>(new ErrorResponse(HttpStatus.NO_CONTENT, "No file selected!"), HttpStatus.NO_CONTENT);
            } else if (fileUploadHelper.uploadVideoFile(file)) {
//                return new ResponseEntity<>(new ErrorResponse(HttpStatus.OK,"File uploaded successfully!"),HttpStatus.OK);
                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(Objects.requireNonNull(file.getOriginalFilename())).toUriString());
            } else {
                return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to upload file!"), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to upload file!:-" + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
