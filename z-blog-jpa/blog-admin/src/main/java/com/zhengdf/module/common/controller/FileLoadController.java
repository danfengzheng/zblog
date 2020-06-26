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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
        /*获取上传原文件名*/
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        /*获取上传文件后缀*/
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        /* 生成上传目录 */
        String uploadFile = String.join("\\",fileBaseDirector , formDate());
//        String path = String.join("\\",fileBaseDirector , formDate(),System.currentTimeMillis()+suffix);
        String uploadFileName = System.currentTimeMillis()+suffix;
        try {
            File dest = new File(uploadFile,uploadFileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            file.transferTo(dest);
            Map<String,String> map = new HashMap<>();
            map.put("name",uploadFileName);
            map.put("url",String.join("\\",uploadFile , uploadFileName));
            log.info("上传成功");
            return Response.getInstance(map);
        } catch (IOException e) {
            e.printStackTrace();
            throw new GlobalException("上传失败");
        }
    }

    public static String formDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String s = sdf.format(new Date());
        System.out.println(s);
    }
}
