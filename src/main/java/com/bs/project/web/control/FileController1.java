package com.bs.project.web.control;

import com.bs.project.util.CustomFileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * Created by Nominal on 2018/3/22 0022.
 * 微博：@Mr丶Li_Anonym
 * 文件上传控制器
 */
@Controller
public class FileController1 {

    /*//跳转到上传文件的页面
    @RequestMapping(value="/upload")
    public String goUploadImg() {
        //跳转到 templates 目录下的 uploadimg.html
        return "index";
    }

    //处理文件上传
    @RequestMapping(value="/js", method = RequestMethod.POST)
    public @ResponseBody
    String uploadImg(@RequestParam("file") MultipartFile file,
                     HttpServletRequest request) {

        //判断文件是否为空
        if (file.isEmpty()) { return "文件为空"; }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //获取文件类型
        String filetype = file.getContentType();
        // 存储文件名
        String uploadName = UUID.randomUUID().toString().replaceAll("-","")+suffixName;
        //获取文件大小
        long size = file.getSize();
        // 文件上传后的路径
        System.out.println("当前url："+request.getContextPath());
        String filePath = request.getContextPath()+"/images";

        try {
            CustomFileUtil.uploadFile(file.getBytes(), filePath, uploadName);
            System.out.println(".."+fileName+"上传"+uploadName+"大小"+size);

        } catch (Exception e) {

        }
        //返回json
        return "uploadimg success";
    }*/
}
