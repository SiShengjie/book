package com.tongji.book.util;

import java.security.MessageDigest;

/**
 * Author: Shengjie Si
 * DateTime: 2019/11/20 9:29
 */
public class Md5Util {

    public static String md5Encrypt(String originString) {
        String encryptString;
        try {
            byte[] bytesInput = originString.getBytes();
            //获得MD5摘要算法的MessageDigest对象
            MessageDigest mDigest = MessageDigest.getInstance("MD5");
            //使用指定的字节更新摘要
            mDigest.update(bytesInput);
            //获取密文
            byte[] encrypts = mDigest.digest();
            //密文转换为十六进制字符串形式
            encryptString = bytesToHexString(encrypts);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return encryptString;
    }

    /**
     * 二进制字节数组转换为十六进制字符串
     *
     * @param bytes 二进制
     * @return 十六进制
     */
    private static String bytesToHexString(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        int temp;
        try {
            for (byte b : bytes) {
                temp = b;
                if (temp < 0)
                    temp += 256;
                if (temp < 16)
                    result.append("0");
                result.append(Integer.toHexString(temp));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    /**
     * 判断是否相同
     *
     * @param origin 加密后密文
     * @param input  加密前输入明文
     * @return true | false
     */
    public static boolean authorizePassword(String origin, String input) {
        return origin.equals(md5Encrypt(input));
    }
}
