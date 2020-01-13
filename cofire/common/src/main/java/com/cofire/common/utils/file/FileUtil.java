package com.cofire.common.utils.file;

import java.io.File;
import java.util.Arrays;
import java.util.Calendar;

import org.apache.commons.lang.StringUtils;

/**
 * @author ly
 * @version V1.0
 * @ClassName: FileUtil
 * @Description:文件操作工具类
 * @date 2019年12月4日
 */
public class FileUtil {
    /**
     * 常用图片格式
     */
    private static final String[] PIC_SUFFIX = {"bmp", "jpg", "jpeg", "png"};

    public static final String FILE_SPLITTER = ".";

    /**
     * @param @param  baseName
     * @param @return 参数
     * @return String 返回类型
     * @Title: getPath
     * @author ly
     * @Description:获取图片保存路径 base/yyyy/mm/dd
     */
    public static String getAbsolutePath(String baseName) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String path = baseName + "/" + year + "/" + month + "/" + day + "/";
        return path;
    }

    /**
     * @param @param  baseName
     * @param @return 参数
     * @return String 返回类型
     * @Title: getPath
     * @author ly
     * @Description:获取图片保存路径 base/yyyy/mm/dd
     */
    public static String getRelatPath() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String path = "/" + year + "/" + month + "/" + day + "/";
        return path;
    }

    /**
     * @param @param  fileName
     * @param @return 参数
     * @return String 返回类型
     * @Title: getSuffix
     * @author ly
     * @Description:获取图片扩展名，如果不是常用扩展名，返回null（不区分大小写）
     */
    public static String getSuffix(String fileName) {
        if (StringUtils.isEmpty(fileName)) {
            return null;
        }
        if (-1 == fileName.lastIndexOf(FILE_SPLITTER)) {
            return null;
        }
        String suffix = fileName.substring(fileName.lastIndexOf(FILE_SPLITTER) + 1);
        suffix = suffix.toLowerCase();
        int index = Arrays.binarySearch(PIC_SUFFIX, suffix);
        if (index == -1) {
            return null;
        }
        return suffix;
    }

    /**
     * @param @param path
     * @param @param filename 参数
     * @return void 返回类型
     * @Title: delFile
     * @author ly
     * @Description: 文件删除
     * @示例D:\\data\\upload\\2010\\1.txt
     */
    public static void delFile(String filePath) {
        if (StringUtils.isEmpty(filePath)) {
            return;
        }
        File file = new File(filePath);
        file.delete();
    }

    /**
     * @param @param path 参数
     * @return void 返回类型
     * @Title: delDir
     * @author ly
     * @Description:删除文件夹
     * @示例 D:\\data\\upload\\2010
     */
    public static void delDir(String path) {
        File dir = new File(path);
        if (dir.exists()) {
            File[] tmp = dir.listFiles();
            // 如果为空文件夹 则直接删除
            if (tmp.length == 0) {
                dir.delete();
            } else {
                for (int i = 0; i < tmp.length; i++) {
                    if (tmp[i].isDirectory()) {
                        delDir(path + "/" + tmp[i].getName());
                    }
                }
            }

        }
    }

}
