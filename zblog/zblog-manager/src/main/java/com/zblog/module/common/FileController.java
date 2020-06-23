package com.zblog.module.common;

import com.zblog.common.base.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: zblog
 * @description:
 * @author: xxx
 * @create: 2020-06-03 18:22
 */
@Slf4j
@RestController
@RequestMapping("/admin/common/file")
public class FileController {

    @PostMapping("/upload")
    public Response upload(@RequestParam("file") MultipartFile file){
        log.info("Name : {} , {}",file.getOriginalFilename(),file.getName());
        return Response.getInstance();
    }
}
