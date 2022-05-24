package com.huang.service;

import com.fasterxml.jackson.core.JsonProcessingException;
/**
 * @Time 2022-05-24 16:25
 * Created by Huang
 * className: UploadService
 * Description:
 */
public interface UploadService {

    String upload(String filePath) throws JsonProcessingException;
}
