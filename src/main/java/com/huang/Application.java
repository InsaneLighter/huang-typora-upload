package com.huang;

import com.huang.config.Config;
import com.huang.service.UploadService;
import com.huang.service.impl.DefaultUploadServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;

/**
 * @Time 2022-05-24 16:21
 * Created by Huang
 * className: Application
 * Description:
 */
@Slf4j
public class Application {
    public static void main(String[] args) {
        try {
            if (!checkArgs(args)) {
                return;
            }
            AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
            ctx.register(Config.class);
            ctx.refresh();
            UploadService service = ctx.getBean(DefaultUploadServiceImpl.class);
            for (String filePath : args) {
                String upload = service.upload(filePath);
                System.out.println(upload);
            }
        } catch (Exception e) {
            System.out.println("上传失败，失败原因：" + e.getMessage());
        }
    }

    private static boolean checkArgs(String[] args) {
        boolean checkResult = true;
        if (args.length == 0) {
            System.out.println("输入参数不能为空");
            checkResult = false;
        }
        for (String filePath : args) {
            if (!new File(filePath).exists()) {
                System.out.println(filePath + " 文件不存在");
                checkResult = false;
            }
        }
        return checkResult;
    }
}
