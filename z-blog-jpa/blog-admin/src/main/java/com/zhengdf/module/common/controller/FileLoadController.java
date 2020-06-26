package com.zhengdf.module.common.controller;

import com.zhengdf.common.Response;
import com.zhengdf.common.exception.GlobalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * @ClassName FileLoadController
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/6/26 17:11
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("/api/file")
public class FileLoadController {
    //上传文件路径
    @Value("${file.base.director}")
    private String fileBaseDirector;
    /**
     * 上传文件事件
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Response upload(@RequestParam("file") MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String path = String.join("\\",fileBaseDirector , fileName);
        try {
            File dest = new File(path);
            file.transferTo(dest);
            log.info("上传成功");
            return Response.getInstance(path);
        } catch (IOException e) {
            e.printStackTrace();
            throw new GlobalException("上传失败");
        }
    }
}
