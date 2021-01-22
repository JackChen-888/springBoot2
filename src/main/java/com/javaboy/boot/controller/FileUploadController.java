package com.javaboy.boot.controller;

import com.documents4j.api.DocumentType;
import com.documents4j.api.IConverter;
import com.documents4j.job.LocalConverter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @author Chen
 * @description
 * @date 2021/1/21
 */
@RestController
public class FileUploadController {

    @PostMapping("/upload")

    public String upload(MultipartFile file) {
        File folder = new File(File.separator + "testupload");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String name = file.getOriginalFilename();
        try {
            file.transferTo(new File(folder, name));
//            File inputWord = new File("L:\\sss\\" + name);
            File inputWord = new File(File.separator + "testupload" + File.separator + name);
//            File outputFile = new File("L:\\sss\\Test_out2.pdf");
            File outputFile = new File(File.separator + "testupload" + File.separator + "Test_out2.pdf");
            InputStream docxInputStream = new FileInputStream(inputWord);
            OutputStream outputStream = new FileOutputStream(outputFile);
            IConverter converter = LocalConverter.builder().build();
            converter.convert(docxInputStream).as(DocumentType.DOCX).to(outputStream).as(DocumentType.PDF).execute();
            outputStream.close();
            System.out.println("success");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "2G";
    }
}
