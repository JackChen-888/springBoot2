package com.javaboy.boot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author Chen
 * @description
 * @date 2021/1/21
 */
@RestController
public class FileUploadController {

    @PostMapping("/upload")

    public String upload(MultipartFile file, HttpServletRequest request) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("/yyyy/MM/dd/");
        String format = simpleDateFormat.format(new Date());
        String s = request.getServletContext().getRealPath("/img") + format;
        File folder = new File("Y:\\1");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String old = file.getOriginalFilename();
        String name = UUID.randomUUID().toString() + old.substring(old.lastIndexOf("."));
        try {
            file.transferTo(new File(folder, name));
            String url = request.getScheme() + ("://") + request.getServerName() + ":" + request.getServerPort() + "/img" + format + name;
            return url;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
