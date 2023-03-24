package com.prashant.todo.contollers;

import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;

@RestController
@RequestMapping("/file")
public class FileController {

    Logger logger = LoggerFactory.getLogger(FileController.class);

    @PostMapping("/single")
    public String uploadSingleFile(@RequestParam("image") MultipartFile file){

        logger.info("Name :{}",file.getName());
        logger.info("ContentType {}",file.getContentType());
        logger.info("Original File Name {}",file.getOriginalFilename());
        logger.info("File size {}",file.getSize());

        return "file test";


    }
    @PostMapping("/multiple")
    public String uploadMultipleFile(@RequestParam("image") MultipartFile[] files){
        Arrays.stream(files).forEach(file->{
            logger.info("Name {}",file.getName());
            logger.info("Size {}",file.getSize());
        });
        return "multiple file";
    }

    @GetMapping("/serve-image")
    public void serveImageHandler(HttpServletResponse response)
    {
        try{
            InputStream is= new FileInputStream("images/39025837-ganesha-or-ganesh-stylized-in-black-and-white-.jpg");
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            StreamUtils.copy(is,response.getOutputStream());
        }catch(Exception e){
            e.printStackTrace();

    }
    }


}
