package com.ctsi.service;

import com.ctsi.config.MinioProp;
import com.ctsi.util.UUIDUtil;
import io.minio.MinioClient;
import io.minio.ObjectStat;
import io.minio.PutObjectOptions;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @ClassName : MinioService
 * @Description :
 * @Author : Xiaotianyu  //作者
 * @Date: 2020-12-09 10:28
 */
@Service
public class MinioService {

    @Autowired
    private MinioClient minioClient;
    private static final String MINIO_BUCKET = "appweb";

    @Value("${minio.endpoint}")
    private String minioEndPoint;

    //根据文件名获取文件url
    public String getFileUrl(String fileName) throws Exception{
        return minioClient.getObjectUrl(MINIO_BUCKET,fileName);
    }

    //获取前缀
    public String getFileUrlFont() {
        return minioEndPoint+MINIO_BUCKET+"/";
    }


    //下载文件
    public void download(HttpServletResponse response, @PathVariable("fileName") String fileName) {
        InputStream in = null;
        try {
            ObjectStat stat = minioClient.statObject(MINIO_BUCKET, fileName);
            response.setContentType(stat.contentType());
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

            in = minioClient.getObject(MINIO_BUCKET, fileName);
            IOUtils.copy(in, response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //上传文件
    public Map<String,List> upload(@RequestParam(name = "file", required = false) MultipartFile[] file) {

        //realName,uuidName
        //有序的map
        Map<String,List> result = new LinkedHashMap<>();

        if (file == null || file.length == 0) {
            return null;
        }

        List<String> orgfileNameList = new ArrayList<>(file.length);
        List<String> uuidNameList = new ArrayList<>(file.length);

        for (MultipartFile multipartFile : file) {
            //原始名称
            String orgfileName = multipartFile.getOriginalFilename();
            //扩展名
            String extName = orgfileName.substring(orgfileName.lastIndexOf("."));
            String uuid = UUIDUtil.generateShortUuid();

            //uuidName
            String uuidName =uuid+extName;

            orgfileNameList.add(orgfileName);
            uuidNameList.add(uuidName);

            try {
                InputStream in = multipartFile.getInputStream();
                minioClient.putObject(MINIO_BUCKET, uuidName, in, new PutObjectOptions(in.available(), -1));
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        result.put("realName",orgfileNameList);
        result.put("uuidName",uuidNameList);

        return result;
    }

    //格式转换
    private static String formatFileSize(long fileS) {
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        String wrongSize = "0B";
        if (fileS == 0) {
            return wrongSize;
        }
        if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + " B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + " KB";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + " MB";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + " GB";
        }
        return fileSizeString;
    }

}
