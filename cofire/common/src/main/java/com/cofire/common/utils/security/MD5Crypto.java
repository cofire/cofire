package com.cofire.common.utils.security;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Crypto {
    /**
     * MD5方法
     * 
     * @param text 明文
     * @param key 密钥
     * @return 密文
     * @throws Exception
     */
    public static String encrypt(String text, String key) {
        // 加密后的字符串
        String encodeStr = DigestUtils.md5Hex(text + key);
        return encodeStr;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(encrypt("admin", "admin"));
        System.out.println(encrypt("admin", "admin"));
    }
}
