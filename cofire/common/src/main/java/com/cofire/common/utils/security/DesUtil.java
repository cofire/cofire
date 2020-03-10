package com.cofire.common.utils.security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;
import java.text.ParseException;

/**
 * @author ly
 * @Description 配置文件加密解密工具
 * @date 2020/03/10
 **/
public class DesUtil {
    /**
     * 默认key key值需要16位
     */
    public final static String KEY = "0002010200220102";

    private static final String Algorithm = "DES"; // 定义 加密算法,可用

    // DES,DESede,Blowfish
    // src为被加密的数据缓冲区（源）
    public static byte[] encryptMode(byte[] keybyte, byte[] src) {
        try {
            // 生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
            // 加密
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.ENCRYPT_MODE, deskey);
            return c1.doFinal(src);
        } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    // keybyte为加密密钥，长度为24字节
    // src为加密后的缓冲区
    public static byte[] decryptMode(byte[] keybyte, byte[] src) {
        try {
            // 生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
            // 解密
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.DECRYPT_MODE, deskey);
            return c1.doFinal(src);
        } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    // 转换成十六进制字符串
    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
            if (n < b.length - 1) {
                hs = hs + "";
            }
        }
        return hs.toUpperCase();
    }

    // 16 进制 转 2 进制
    public static byte[] hex2byte(String hex) throws IllegalArgumentException {

        if (hex.length() % 2 != 0) {
            throw new IllegalArgumentException();
        }
        char[] arr = hex.toCharArray();
        byte[] b = new byte[hex.length() / 2];
        for (int i = 0, j = 0, l = hex.length(); i < l; i++, j++) {
            String swap = "" + arr[i++] + arr[i];
            int byteint = Integer.parseInt(swap, 16) & 0xFF;
            b[j] = new Integer(byteint).byteValue();
        }
        return b;
    }

    // 加密
    public static String Encrypt(String str, byte[] key) {
        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        byte[] encrypt = encryptMode(key, str.getBytes());
        return byte2hex(encrypt);
    }

    // 加密
    public static byte[] EncryptRetByte(byte[] src, byte[] key) {
        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        byte[] encrypt = encryptMode(key, src);
        return encrypt;
    }

    // 解密
    public static String Decrypt(String str, byte[] key) {
        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        byte[] decrypt = decryptMode(key, hex2byte(str));
        return new String(decrypt);
    }

    public static void main(String arg[]) throws ParseException {
//        String str = "jdbc:mysql://localhost:3306/cool_web?userUnicode=true&characterEncoding=UTF8&useSSL=false&serverTimezone=UTC";//要加密的信息
        String s3 = Encrypt("root", hex2byte(KEY));//加密
        String s4 = Decrypt(s3, hex2byte(KEY));//解密
        System.out.println("加密后的信息     " + s3);
        System.out.println("解密后的信息     " + s4);

    }


}

