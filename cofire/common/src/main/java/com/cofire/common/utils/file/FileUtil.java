package com.cofire.common.utils.file;

import java.io.File;
import java.util.Arrays;
import java.util.Calendar;

import org.apache.commons.lang.StringUtils;

public class FileUtil {
    // 常用图片格式
    public static final String[] picSuffix = { "bmp", "jpg", "jpeg", "png" };

    /**
     * 
     * @Title: getPath
     * @author ly
     * @Description:获取图片保存路径 base/yyyy/mm/dd
     * @param @param p_baseName
     * @param @return 参数
     * @return String 返回类型
     */
    public static String getAbsolutePath(String p_baseName) {
        Calendar m_calendar = Calendar.getInstance();
        int m_year = m_calendar.get(Calendar.YEAR);
        int m_month = m_calendar.get(Calendar.MONTH) + 1;
        int m_day = m_calendar.get(Calendar.DAY_OF_MONTH);
        String m_path = p_baseName + "/" + m_year + "/" + m_month + "/" + m_day + "/";
        return m_path;
    }

    /**
     * 
     * @Title: getPath
     * @author ly
     * @Description:获取图片保存路径 base/yyyy/mm/dd
     * @param @param p_baseName
     * @param @return 参数
     * @return String 返回类型
     */
    public static String getRelatPath() {
        Calendar m_calendar = Calendar.getInstance();
        int m_year = m_calendar.get(Calendar.YEAR);
        int m_month = m_calendar.get(Calendar.MONTH) + 1;
        int m_day = m_calendar.get(Calendar.DAY_OF_MONTH);
        String m_path = "/" + m_year + "/" + m_month + "/" + m_day + "/";
        return m_path;
    }

    /**
     * 
     * @Title: getSuffix
     * @author ly
     * @Description:获取图片扩展名，如果不是常用扩展名，返回null（不区分大小写）
     * @param @param p_fileName
     * @param @return 参数
     * @return String 返回类型
     */
    public static String getSuffix(String p_fileName) {
        if (StringUtils.isEmpty(p_fileName)) {
            return null;
        }
        if (-1 == p_fileName.lastIndexOf(".")) {
            return null;
        }
        String m_suffix = p_fileName.substring(p_fileName.lastIndexOf(".") + 1);
        m_suffix = m_suffix.toLowerCase();
        int c_index = Arrays.binarySearch(picSuffix, m_suffix);
        if (c_index == -1) {
            return null;
        }
        return m_suffix;
    }

    /**
     * 
     * @Title: delFile
     * @author ly
     * @Description: 文件删除
     * @param @param path
     * @param @param filename 参数
     * @return void 返回类型
     * @示例D:\\data\\upload\\2010\\1.txt
     */
    public static void delFile(String filePath) {
        if (StringUtils.isEmpty(filePath)) {
            return;
        }
        File file = new File(filePath);
        if (file.exists() && file.isFile()) {
            file.delete();
        } else {
            return;
        }
        return;
    }

    /**
     * 
     * @Title: delDir
     * @author ly
     * @Description:删除文件夹
     * @param @param path 参数
     * @return void 返回类型
     * @示例 D:\\data\\upload\\2010
     */
    public static void delDir(String path) {
        File dir = new File(path);
        if (dir.exists()) {
            File[] tmp = dir.listFiles();
            //如果为空文件夹 则直接删除
            if (tmp.length == 0){
                dir.delete();
            }else{
                for (int i = 0; i < tmp.length; i++) {
                    if (tmp[i].isDirectory()) {
                        delDir(path + "/" + tmp[i].getName());
                    }
                }
            }

        }
    }

}
