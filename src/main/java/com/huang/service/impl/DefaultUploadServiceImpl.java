package com.huang.service.impl;

import com.huang.service.UploadService;
import com.huang.utils.MinioUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.nio.file.Files;

/**
 * @Time 2022-05-24 16:30
 * Created by Huang
 * className: DefaultUploadServiceImpl
 * Description:
 */
@Service
@Slf4j
public class DefaultUploadServiceImpl implements UploadService {
    @Autowired
    private MinioUtil minioUtil;

    @Override
    public String upload(String filePath)  {
        File file = new File(filePath);
        String path = null;
        try {
            path = minioUtil.uploadFile(getMultipartFile(file), "typora");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }

    private MultipartFile getMultipartFile(File file) throws IOException {
        FileItem fileItem = new DiskFileItem("mainFile", Files.probeContentType(file.toPath()), false, file.getName(), (int) file.length(), file.getParentFile());
        try {
            InputStream input = new FileInputStream(file);
            OutputStream os = fileItem.getOutputStream();
            IOUtils.copy(input, os);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return  new CommonsMultipartFile(fileItem);
    }
}
