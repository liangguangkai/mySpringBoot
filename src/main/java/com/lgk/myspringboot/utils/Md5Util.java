package com.lgk.myspringboot.utils;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.UUID;

/**
 * @author liangguangkai
 * @version 1.0
 * @date 2022/9/19
 */
public class Md5Util {

    /**
     * 计算签名值
     *
     * @param content  请求报文体
     * @param secretKey   from_appkey 配置的私钥
     * @return
     */
    public static String calculateDigest(String content, String secretKey) {
        String text = content + secretKey;
        byte[] md5 = DigestUtils.md5(text);
        return Base64.encodeBase64String(md5);
    }

    public static void main(String[] args) {
        String content = "{\n" +
                "  \"requestUUID\": \"1c5b188e05e54411845831ab330dfaf2\",\n" +
                "  \"customerName\": \"申通-开放平台\",\n" +
                "  \"sendAddress\": {\n" +
                "    \"provinceName\": \"湖南省\",\n" +
                "    \"cityName\": \"长沙市\",\n" +
                "    \"areaName\": \"岳麓区\",\n" +
                "    \"townName\": \"含浦镇\",\n" +
                "    \"detailAddress\": \"学士府收费站\"\n" +
                "  },\n" +
                "  \"consigneeAddress\": {\n" +
                "    \"provinceName\": \"上海\",\n" +
                "    \"cityName\": \"上海市\",\n" +
                "    \"areaName\": \"青浦区\",\n" +
                "    \"townName\": \"重固镇\",\n" +
                "    \"detailAddress\": \"意邦国际写字楼\"\n" +
                "  },\n" +
                "  \"cpSellerId\": \"商家ID\",\n" +
                "  \"sendBranchCode\": \"300386\"\n" +
                "}";
        String secretKey ="LdM84oQHJHAP8VNRSrkWliM0ApPQrmd9";
        String s = calculateDigest(content, secretKey);
        System.out.println(s);
        UUID uuid = UUID.randomUUID();
        String s1 = uuid.toString();
        System.out.println(s1);


    }
}
