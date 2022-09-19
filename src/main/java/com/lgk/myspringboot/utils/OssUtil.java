package com.lgk.myspringboot.utils;


import io.minio.MinioClient;
import io.minio.ObjectStat;
import lombok.SneakyThrows;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * Class OssHelper
 * <p>
 *
 * @author shunhong
 * @since 1.0.0
 * </p>
 */
@Component
public class OssUtil implements InitializingBean {

    private MinioClient client;

    private static final int EXPIRE = 60 * 60;

    @Value("${oss.secretKey}")
    private String secretKey;   // wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY

    @Value("${oss.accessKey}")
    private String accessKey;   //    AKIAIOSFODNN7EXAMPLE



    @Value("${oss.endpoint}")
    private String endpoint;    //    http://120.26.240.150:19000




    @Override
    public void afterPropertiesSet() throws Exception {
        this.client = new MinioClient(endpoint, accessKey, secretKey);
    }

    @SneakyThrows
    public String getObjectUrl(String bucketName, String objectName) {
        if (!client.bucketExists(bucketName)) {
            throw new Exception();
        }
        return client.presignedGetObject(bucketName, objectName, EXPIRE);
    }

    /**
     * 获取图片的永久链接
     *
     * <p>慎用！图片设置好过期时间以防盗链为主，该方法需要经过上级主管批准才允许使用！</p>
     *
     * @param bucketName 桶名称
     * @param objectName 文件名称
     * @return 图片的永久链接
     */
    @SneakyThrows
    public String getObjectForeverUrl(String bucketName, String objectName) {
        if (!client.bucketExists(bucketName)) {
            throw new Exception();
        }
        return client.getObjectUrl(bucketName, objectName);
    }

    /**
     * 上传文件
     *
     * @param bucketName bucket名称
     * @return ObjectStat
     */
    @SneakyThrows
    public ObjectStat putObject(String bucketName, MultipartFile file) {
        String objectName = this.getObjectName(file);

        if (!client.bucketExists(bucketName)) {
            throw new Exception();
        }

        client.putObject(bucketName, objectName, file.getInputStream(), file.getSize(), file.getContentType());

        return client.statObject(bucketName, objectName);
    }

    /**
     * 生成上传对象名称
     *
     * @param file 文件
     * @return 文件名称
     */
    private String getObjectName(MultipartFile file) {

        String uuid = java.util.UUID.randomUUID().toString().replace("-", "");

        // 获得文件原始名称
        String fileName = file.getOriginalFilename();

        // 获得文件后缀名称
        assert fileName != null;
        String suffixName = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();

        // 生成最新的uuid文件名称
        return uuid + "." + suffixName;
    }

}
