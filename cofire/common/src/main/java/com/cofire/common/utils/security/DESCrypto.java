package com.cofire.common.utils.security;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * <p>
 * Title: DESCrypto
 * </p>
 * <p>
 * Description: 實現EDS算法對字符串和文件的加密解密 1. DES算法對字符串的加密解密 2. DES算法對文件的加密解密
 * 
 * 3. Triple DES算法對字符串的加密解密 4. Triple DES算法對文件的加密解密
 * </p>
 * 
 * @author Dumbbell Yang
 * @Date 2010-01-11
 * @version 1.0
 */

public class DESCrypto {
    private final static Logger logger = LoggerFactory.getLogger(DESCrypto.class);
    /**
     * 密钥，長度必須為8的倍數
     */
    private static final String DES_KEY = "CMMSGIBIITSSDEV1";
    private static final String DES = "DES";

    private static final String TRIPLE_DES_KEY = "321321000000000000000000";
    private static final String TRIPLE_DES = "TripleDES";

    // 密鑰
    private static final String DES_KEY_FILE = "C:\\des.key";
    private static final String TRIPLE_DES_KEY_FILE = "C:\\tripledes.key";
    public static DESKeySpec DESKeySpec;
    public static SecretKeySpec tripleDESKeySpec;

    // 取得DES Key
    @SuppressWarnings("resource")
    public static DESKeySpec getDESKeySpec() throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        // DES 128位
        byte[] bytes = new byte[8];
        File f = new File(DES_KEY_FILE);
        SecretKey key = null;
        DESKeySpec spec = null;

        // 如果存在Key文件，讀取
        if (f.exists()) {
            new FileInputStream(f).read(bytes);
        }
        // 如果不存在，重新生成Key，并寫入Key文件
        else {
            KeyGenerator kgen = KeyGenerator.getInstance(DES);
            kgen.init(56);
            key = kgen.generateKey();
            bytes = key.getEncoded();
            new FileOutputStream(f).write(bytes);
        }

        spec = new DESKeySpec(bytes);

        return spec;
    }

    // 取得Triple DES Key
    @SuppressWarnings("resource")
    public static SecretKeySpec getTripleDESKeySpec() throws IOException, NoSuchAlgorithmException {
        // Triple DES
        byte[] bytes = new byte[24];
        File f = new File(TRIPLE_DES_KEY_FILE);
        SecretKey key = null;
        SecretKeySpec spec = null;

        // 如果存在Key文件，讀取
        if (f.exists()) {
            new FileInputStream(f).read(bytes);
        }
        // 如果不存在，重新生成Key，并寫入Key文件
        else {
            KeyGenerator kgen = KeyGenerator.getInstance(TRIPLE_DES);
            kgen.init(168);
            key = kgen.generateKey();
            bytes = key.getEncoded();
            new FileOutputStream(f).write(bytes);
        }

        spec = new SecretKeySpec(bytes, TRIPLE_DES);

        return spec;
    }

    // 從字符串生成DES Key
    public static DESKeySpec getDESKeySpecFromString(String strKey) throws NoSuchAlgorithmException, InvalidKeyException {
        DESKeySpec spec = new DESKeySpec(strKey.getBytes());
        return spec;
    }

    // 從十六進制字節串生成DES Key
    public static DESKeySpec getDESKeySpecFromBytes(String strBytes) throws NoSuchAlgorithmException, InvalidKeyException {
        DESKeySpec spec = new DESKeySpec(Util.hex2byte(strBytes.getBytes()));
        return spec;
    }

    // 從字符串生成DES Key
    public static DESKeySpec getDESKeySpecFromOCString(String strKey) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        String strKeyString = new String(Util.hex2byte(strKey.getBytes()));
        DESKeySpec spec = new DESKeySpec(strKeyString.getBytes());
        return spec;
    }

    // 從十六進制字節串生成Triple DES Key
    public static SecretKeySpec getTripleDESKeySpecFromBytes(String strBytes) throws NoSuchAlgorithmException {
        SecretKeySpec spec = new SecretKeySpec(Util.hex2byte(strBytes.getBytes()), TRIPLE_DES);
        return spec;
    }

    // 從字符串生成Triple DES Key
    public static SecretKeySpec getTripleDESKeySpecFromString(String strKey) throws NoSuchAlgorithmException {
        // SecretKeySpec spec = new SecretKeySpec(strKey.getBytes(),TRIPLE_DES);
        SecretKeySpec spec = new SecretKeySpec(strKey.getBytes(), "DESede");
        return spec;
    }

    public static SecretKeySpec getJSTripleDESKeySpecFromString(String strKey) throws NoSuchAlgorithmException {
        SecretKeySpec spec = new SecretKeySpec(strKey.getBytes(), TRIPLE_DES);
        return spec;
    }

    // 取得DES Key對應的字符串,此為傳給Objective C的密碼字串
    public static String getDESKeyString() {
        return Util.byte2hex(DESKeySpec.getKey());
    }

    // 取得Triple DES Key對應的字符串,此為傳給Objective C的密碼字串
    public static String getTripleDESKeyString() {
        return Util.byte2hex(tripleDESKeySpec.getEncoded());
    }

    /**
     * 加密
     * 
     * @param src 明文(字节)
     * @param key 密钥，长度必须是8的倍数
     * @return 密文(字节)
     * @throws Exception
     */

    public static byte[] encrypt(byte[] src) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 创建一个密匙工厂，然后用它把DESKeySpec转换成
        // 一个SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(DESKeySpec);

        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);
        // Cipher cipher = Cipher.getInstance("DES/CBC/PKCS7Padding", new BouncyCastleProvider());

        // AlgorithmParameterSpec iv = new IvParameterSpec("abcdefgh".getBytes("UTF-8"));
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

        // 现在，获取数据并加密
        // 正式执行加密操作
        return cipher.doFinal(src);
    }

    public static byte[] tripleDESEncrypt(byte[] src) throws Exception {
        // SecureRandom sr = new SecureRandom();

        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(TRIPLE_DES);

        // 用密匙初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, tripleDESKeySpec);

        // 现在，获取数据并加密
        // 正式执行加密操作
        return cipher.doFinal(src);
    }

    /**
     * 解密
     * 
     * @param src 密文(字节)
     * @param key 密钥，长度必须是8的倍数
     * @return 明文(字节)
     * @throws Exception
     */
    public static byte[] decrypt(byte[] src) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 创建一个密匙工厂，然后用它把DESKeySpec转换成
        // 一个SecretKey对象
        // SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(DESKeySpec);

        // Cipher对象实际完成解密操作
        // AlgorithmParameterSpec iv = new IvParameterSpec("abcdefgh".getBytes("UTF-8"));
        // Cipher cipher = Cipher.getInstance("DES/CBC/PKCS7Padding", new BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance(DES);

        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

        // 现在，获取数据并解密
        // 正式执行解密操作
        return cipher.doFinal(src);
    }

    public static byte[] tripleDESDecrypt(byte[] src) throws Exception {
        // SecureRandom sr = new SecureRandom();

        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(TRIPLE_DES);

        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, tripleDESKeySpec);

        // 现在，获取数据并解密
        // 正式执行解密操作
        return cipher.doFinal(src);
    }

    /**
     * 加密
     * 
     * @param src 明文(字符串)
     * @return 密文(16进制字符串)
     * @throws Exception
     */
    public final static String encrypt(String src) {
        try {
            return Util.byte2hex(encrypt(src.getBytes()));
        } catch (Exception e) {
            logger.debug(e.getMessage(), e);
        }
        return null;
    }

    public final static String tripleDESEncrypt(String src) {
        try {
            return Util.byte2hex(tripleDESEncrypt(src.getBytes()));
        } catch (Exception e) {
            logger.debug(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 解密
     * 
     * @param src 密文(字符串)
     * @return 明文(字符串)
     * @throws Exception
     */
    public final static String decrypt(String src) {
        try {
            return new String(decrypt(Util.hex2byte(src.getBytes())));
        } catch (Exception e) {
            logger.debug(e.getMessage(), e);
        }
        return null;
    }

    public final static String tripleDESDecrypt(String src) {
        try {
            return new String(tripleDESDecrypt(Util.hex2byte(src.getBytes())));
        } catch (Exception e) {
            logger.debug(e.getMessage(), e);
        }
        return null;
    }

    // ============================把文件进行解密加密===================================
    public static File encryptFile(File file, String path, boolean isTripleDES) {
        File EncFile = new File(path);
        if (!EncFile.exists()) {
            try {
                EncFile.createNewFile();
            } catch (Exception e) {
                logger.debug(e.getMessage(), e);
            }
        }

        try {
            FileInputStream fin = new FileInputStream(file);
            ByteArrayOutputStream bout = new ByteArrayOutputStream(fin.available());
            byte b[] = new byte[fin.available()];

            while ((fin.read(b)) != -1) {
                byte temp[];
                if (isTripleDES) {
                    temp = tripleDESEncrypt(b);
                } else {
                    temp = encrypt(b);
                }
                bout.write(temp, 0, temp.length);
            }
            fin.close();
            bout.close();
            FileOutputStream fout = new FileOutputStream(EncFile);
            BufferedOutputStream buffout = new BufferedOutputStream(fout);

            buffout.write(bout.toByteArray());
            buffout.close();
            fout.close();
        }

        catch (Exception e) {
            logger.debug(e.getMessage(), e);
        }

        return EncFile;
    }

    public static File decryptFile(File file, String path, boolean isTripleDES) {
        File desFile = new File(path);
        if (!desFile.exists()) {
            try {
                desFile.createNewFile();
            } catch (Exception e) {
                logger.debug(e.getMessage(), e);
            }
        }
        try {
            FileInputStream fin = new FileInputStream(file);
            int i = fin.available() - fin.available() % 8;

            ByteArrayOutputStream bout = new ByteArrayOutputStream(i);
            byte b[] = new byte[i];

            while (fin.read(b) != -1) {
                byte temp[];
                if (isTripleDES) {
                    temp = tripleDESDecrypt(b);
                } else {
                    temp = decrypt(b);
                }
                bout.write(temp, 0, temp.length);
            }

            fin.close();
            bout.close();
            FileOutputStream fout = new FileOutputStream(desFile);
            BufferedOutputStream buffout = new BufferedOutputStream(fout);
            buffout.write(bout.toByteArray());
            buffout.close();
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return desFile;
    }

    //
    public static void testDESStringKeyForJS() throws InvalidKeyException, NoSuchAlgorithmException, IOException {
        System.out.println("測試DES String Key加密解密 for JavaScript");
        // DESKeySpec = getDESKeySpecFromString("UeD3m+Df");//DES_KEY);
        DESKeySpec = getDESKeySpecFromString("12345678");

        String[] javaString = new String[] { "Genius is one percent inspiration and ninety-nine percent perspiration", "Where there is a will there is a way",
                "He who laughs last laughs best", "abcdefgh", "12345" };

        logger.info(getDESKeyString());
        for (int i = 0; i < javaString.length; i++) {
            String cipherText = encrypt(javaString[i]);
            logger.info("密文：");
            logger.info(cipherText);
            String plainText = decrypt(cipherText);
            logger.info("明文：");
            logger.info(plainText);
        }
    }

    public static void test3DESStringKeyForJS() throws InvalidKeyException, NoSuchAlgorithmException, IOException {
        logger.info("測試DES String Key加密解密 for JavaScript");
        // DESKeySpec = getDESKeySpecFromString("UeD3m+Df");//DES_KEY);
        // tripleDESKeySpec = getTripleDESKeySpecFromString(TRIPLE_DES_KEY);
        tripleDESKeySpec = getTripleDESKeySpecFromString("cZzvzmbjZRWkdjZwj2BNWT1P");
        logger.info(getTripleDESKeyString());
        String[] javaString = new String[] { "Genius is one percent inspiration and ninety-nine percent perspiration", "Where there is a will there is a way",
                "He who laughs last laughs best", "abcdefgh", "12345" };

        for (int i = 0; i < javaString.length; i++) {
            String cipherText = tripleDESEncrypt(javaString[i]);
            logger.info("密文：");
            logger.info(cipherText);
            String plainText = tripleDESDecrypt(cipherText);
            logger.info("明文：");
            logger.info(plainText);
        }
    }

    // ECB模式
    // 因為DES和3DES算法算法，javascript和java加密的結果只有最后十六位不同，
    // javascript可以解密java加密的結果，只是需要剔除最后的不可見字符
    // 但是java不能解密javascript的加密結果
    // 所以，javascript加密時，明文后補充8個空格，生成密文，
    // java解密時，用java加密8個空字符的密文最后16位替換javascript密文的最后16位
    // 最后對解密的密文剔除結尾的空格
    public static String getRandomSuffix() {
        String strRandom = encrypt("        ");
        return strRandom.substring(strRandom.length() - 16);
    }

    public static String get3DESRandomSuffix() {
        String strRandom = tripleDESEncrypt("        ");
        // System.out.println(strRandom);
        return strRandom.substring(strRandom.length() - 16);
    }

    // 測試JS生成的3DES加密的文本用Java解密
    public static void testJS3DESEncryption() throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
        String jsKey = "cZzvzmbjZRWkdjZwj2BNWT1P";
        String[] jsEncrypted = new String[] { "0f3d0b698abf4282b4d073ea2c41e1bc", "7095ed2b7b548762c2c11d3df9fa94ca",
                "7095ed2b7b54876285f9de50059fd23f81802b4a44f0a6bc", "7095ed2b7b548762c9609433f7a0556dc2c11d3df9fa94ca",
                "0dfde5f919fc981cce019abac80931b2c713438900350886ce019abac80931b2383d64c1dd6e8092b4d073ea2c41e1bc",
                "785611930ad1c793e6f65d15c47565eccdfc84295edc1c0854513f607797dc827ef1d547a8a0f6ef" };

        logger.info("測試DES Load JavaScript 3DES Key and Encrypted text 加密解密");
        tripleDESKeySpec = getJSTripleDESKeySpecFromString(jsKey);

        String strSuffix = get3DESRandomSuffix();
        logger.info(strSuffix);
        for (int i = 0; i < jsEncrypted.length; i++) {
            String cipherText = jsEncrypted[i].toUpperCase().substring(0, jsEncrypted[i].length() - 16) + strSuffix;
            logger.info("密文：");
            logger.info(cipherText);
            String plainText = tripleDESDecrypt(cipherText);
            logger.info("明文：");
            logger.info(plainText);
        }
    }

    /**
     * 解密JS的3des密文
     */
    public static String JS3DESEncryption(String jsKey, String value) {
        try {
            if (jsKey.length() > 24) {
                jsKey = jsKey.substring(0, 23);

            } else {
                for (int i = jsKey.length(); i < 24; i++) {
                    jsKey += "0";
                }
            }
            tripleDESKeySpec = getJSTripleDESKeySpecFromString(jsKey);

            String strSuffix = get3DESRandomSuffix();
            String cipherText = value.toUpperCase().substring(0, value.length() - 16) + strSuffix;
            // System.out.println("密文：");
            // System.out.println(cipherText);
            String plainText = tripleDESDecrypt(cipherText);
            // System.out.println("明文：");
            // System.out.println(plainText);
            return plainText.trim();
        } catch (Exception e) {
            logger.debug(e.getMessage(), e);
            return "";
        }
    }

    public static void main(String[] args) {
        String key = "admin";
        String passwd = "393fe4caa7d797d48ba15dd4549cfba3";
        System.out.println("解密：" + JS3DESEncryption(key, passwd));

    }

}
