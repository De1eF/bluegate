package com.backend.bluegate.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/download")
@CrossOrigin
@RequiredArgsConstructor
public class DownloadController {


    @GetMapping("/{fileName}")
    public ResponseEntity<byte[]> downloadZipFile(@PathVariable String fileName) {
        try {
            String filePath = "src/main/resources/downloadable/" + fileName + ".zip";
            byte[] zipBytes = readFileIntoByteArray(filePath);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDisposition(ContentDisposition.attachment().filename(fileName + ".zip").build());
            return ResponseEntity.ok().headers(headers).body(zipBytes);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    private static byte[] readFileIntoByteArray(String filePath) throws IOException {
        File file = new File(filePath);
        byte[] buffer = new byte[(int) file.length()];
        try (FileInputStream fis = new FileInputStream(file)) {
            fis.read(buffer);
        }
        return buffer;
    }
}
