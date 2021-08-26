package com.ivr.cafeback.controllers;

import com.ivr.cafeback.services.Utilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class MainController {
    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String simpleShow() {
        Utilities util = new Utilities();
        boolean file = util.fileSave("Hello world " + new Date());
        return "Hello this page updated\n" + file;
    }


    private void test(String content) {
        /*try {
            File filePath = new File(uploadPath);
            if (!filePath.exists()) {
                System.out.println(filePath.mkdir());
            }

            File file = new File(filePath.getPath() + "/" + new Date().getTime());

            FileWriter fileWriter = new FileWriter(file);
            fileWriter.append(content);
            fileWriter.flush();
            fileWriter.close();
            return file.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }*/
    }

}
