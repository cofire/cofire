package com.cofire.common.utils.security;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * <p>
 * Title: Util
 * </p>
 * <p>
 * Description: Java加密解密公共方法
 * </p>
 *
 * @author Dumbbell Yang
 * @version 1.0
 * @Date 2010-01-11
 */

public class Util {
    private final static Logger logger = LoggerFactory.getLogger(Util.class);

    public static String getFileName(String strFilePath) {
        return strFilePath.substring(strFilePath.lastIndexOf("\\") + 1);
    }

    // 字串寫入二進制文件
    public static void saveToFile(String strString, String strFile) {
        try {
            FileOutputStream file = new FileOutputStream(strFile);
            file.write(strString.getBytes());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 根據指定字符集生成隨機字符串
    private static final String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_+/";

    public static String getRandomString(int length) {
        Random rand = new Random(System.currentTimeMillis());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int pos = rand.nextInt(charset.length());
            sb.append(charset.charAt(pos));
        }
        return sb.toString();
    }

    // 從UUID生成隨機字符串
    public static String getRandomUUID(int length) {
        String strUUID = UUID.randomUUID().toString();
        System.out.println("UUID length:" + strUUID.length());
        while (strUUID.length() < length) {
            strUUID += UUID.randomUUID().toString();
        }

        return strUUID.substring(0, length);
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    // 剔除文本中的換行符
    public static String replaceNewLine(String strText) {
        String strResult = "";
        int intStart = 0;
        int intLoc = strText.indexOf("\n", intStart);
        while (intLoc != -1) {
            strResult += strText.substring(intStart, intLoc - 1);
            intStart = intLoc + 1;
            intLoc = strText.indexOf("\n", intStart);
        }
        strResult += strText.substring(intStart, strText.length());
        return strResult;
    }

    // 字節到十六進制串轉換
    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0xFF);
            if (stmp.length() == 1) {
                hs += ("0" + stmp);
            } else {
                hs += stmp;
            }
        }
        return hs.toUpperCase();
    }

    // 十六進制串到字節轉換
    public static byte[] hex2byte(byte[] b) {
        if ((b.length % 2) != 0) {
            throw new IllegalArgumentException("长度不是偶数!");
        }
        byte[] b2 = new byte[b.length / 2];

        for (int n = 0; n < b.length; n += 2) {
            String item = new String(b, n, 2);
            b2[n / 2] = (byte) Integer.parseInt(item, 16);
        }
        return b2;
    }

    public static byte[] Base64Encode(byte[] bytes) throws UnsupportedEncodingException {
        BASE64Encoder base64encoder = new BASE64Encoder();
        String encode = base64encoder.encode(bytes);

        return encode.getBytes();
    }

    public static byte[] Base64Decode(byte[] bytes) throws IOException {
        BASE64Decoder base64decoder = new BASE64Decoder();
        return base64decoder.decodeBuffer(new String(bytes));
    }

    public static byte[] getFromBase64(String s) {
        byte[] b = null;
        String result = null;
        if (s != null) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(s);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return b;
    }

    public static String getCurrentDate() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMdd");
        return sDateFormat.format(new java.util.Date());
    }

    public static String getCurrentDateTime() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sDateFormat.format(new java.util.Date());
    }

    public static String getCurrentDateTimeString() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return sDateFormat.format(new java.util.Date());
    }

    private static String zipFiles(String[] files, String zipToFile) {
        // Create a buffer for reading the files
        byte[] buf = new byte[1024];
        File file = new File(zipToFile);
        if (file.exists()) {
            file.delete();
        }

        try {
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipToFile));

            // Compress the files
            for (int i = 0; i < files.length; i++) {
                if (new File(files[i]).exists()) {
                    FileInputStream in = new FileInputStream(files[i]);

                    // Add ZIP entry to output stream.
                    out.putNextEntry(new ZipEntry(getFileName(files[i])));

                    // Transfer bytes from the file to the ZIP file
                    int len;
                    while ((len = in.read(buf)) > 0) {
                        out.write(buf, 0, len);
                    }

                    // Complete the entry
                    out.closeEntry();
                    in.close();
                }
            }

            // Complete the ZIP file
            out.close();

            return zipToFile;
        } catch (IOException e) {
            logger.debug(e.getMessage(), e);
            return "";
        }
    }

    @SuppressWarnings("unused")
    private static String zipFolder(String strFolder, String zipToFile) {
        File folder = new File(strFolder);

        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            String[] arrFiles = new String[files.length];
            for (int i = 0; i < files.length; i++) {
                arrFiles[i] = files[i].getAbsolutePath();
            }
            return zipFiles(arrFiles, zipToFile);
        } else {
            return zipFiles(new String[]{strFolder}, zipToFile);
        }
    }

    public static String unzipFile(String zippedFile, String unzipToFolder) {
        if (new File(zippedFile).exists()) {
            try {
                InputStream in = new BufferedInputStream(new FileInputStream(zippedFile));
                ZipInputStream zin = new ZipInputStream(in);

                File file = new File(unzipToFolder);
                if (file.exists() == false) {
                    file.mkdirs();
                }

                ZipEntry e;
                while ((e = zin.getNextEntry()) != null) {
                    String s = e.getName();
                    File f = new File(unzipToFolder, s);

                    FileOutputStream out = new FileOutputStream(f);
                    byte[] b = new byte[512];
                    int len = 0;
                    while ((len = zin.read(b)) != -1) {
                        out.write(b, 0, len);
                    }
                    out.close();
                }
                zin.close();

                return unzipToFolder;
            } catch (IOException e) {
                logger.debug(e.getMessage(), e);
                return "";
            }
        } else {
            return "";
        }
    }

    public static String getDayMinTimeStr(String workDate) {
        // Calendar calendar = Calendar.getInstance();
        // String year = String.valueOf(calendar.get(Calendar.YEAR));
        // String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        // String date = String.valueOf(calendar.get(Calendar.DATE));
        return workDate + "00" + "00" + "00";
    }

    public static String getDayMaxTimeStr(String workDate) {
        // Calendar calendar = Calendar.getInstance();
        // String year = String.valueOf(calendar.get(Calendar.YEAR));
        // String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        // String date = String.valueOf(calendar.get(Calendar.DATE));
        return workDate + "23" + "59" + "59";
    }

    public static String getWorkDate() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (hour < 6) {
            calendar.add(Calendar.DAY_OF_MONTH, -1);
        }
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date startDate = calendar.getTime();
        return sDateFormat.format(startDate);
    }

    public static String getPreWorkDate(String workDate) {
        if (workDate == null || workDate.length() < 6) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        try {
            Date date = simpleDateFormat.parse(workDate);
            Calendar calendar = Calendar.getInstance();// 日历对象
            calendar.setTime(date);// 设置当前日期
            calendar.add(Calendar.DAY_OF_MONTH, -1);// 加、减
            return simpleDateFormat.format(calendar.getTime());
        } catch (ParseException px) {
            px.printStackTrace();
        }
        return null;
    }

    public static String parseURLPair(Object o) throws Exception {
        Class<? extends Object> c = o.getClass();
        Field[] fields = c.getDeclaredFields();
        Map<String, Object> map = new TreeMap<String, Object>();
        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            Object value = field.get(o);
            if (value != null) {
                map.put(name, value);
            }
        }
        Set<Entry<String, Object>> set = map.entrySet();
        Iterator<Entry<String, Object>> it = set.iterator();
        StringBuffer sb = new StringBuffer();
        while (it.hasNext()) {
            Entry<String, Object> e = it.next();
            sb.append(e.getKey()).append("=").append(URLEncoder.encode((String) e.getValue(), "utf-8")).append("&");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static <T> T mapToBean(HashMap<String, String> map, Class<T> class1) {
        T bean = null;
        try {
            bean = class1.newInstance();
            org.apache.commons.beanutils.BeanUtils.populate(bean, map);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    // public static String getWorkDate() {
    // Calendar calendar = Calendar.getInstance();
    // int year = calendar.get(Calendar.YEAR);
    // int month = calendar.get(Calendar.MONTH) + 1;
    // int date = calendar.get(Calendar.DATE);
    // int hour = calendar.get(Calendar.HOUR_OF_DAY);
    // if (hour < 6) {
    // date = date - 1;
    // }
    // return String.valueOf(year) + String.valueOf(month) + String.valueOf(date);
    // }

    public static String createMerchId() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMdd");
        String dateString = sDateFormat.format(new java.util.Date());
        String randomNum = String.valueOf((int) ((Math.random() * 9 + 1) * 10000));
        return dateString + randomNum;
    }

}
