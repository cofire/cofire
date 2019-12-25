/**
 *
 */
package com.cofire.common.utils.zip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author chl_seu
 * @date 2008-10-29
 */
public class ZipUtils {
    private ZipOutputStream outStream = null;
    private static final Logger logger = LoggerFactory.getLogger(ZipUtils.class);


    /**
     * 初始化
     */
    public ZipUtils(String fileName) {
        initOutStream(fileName);
    }

    /**
     *  函数名称  initOutStream
     *  功能     初始化out对象
     *  输入     outputFileName-输出的zip文件名（带路径）
     *  输出     true-success  false-fail
     *  author  chl_seu
     *  创建日期  08.10.27
     */
    public boolean initOutStream(String outputFileName) {
        try {
            outStream = new ZipOutputStream(new FileOutputStream(outputFileName));
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        }
    }

    /**
     *  函数名称  closeOutStream
     *  功能     关闭out对象
     *  输入
     *  输出     true-success  false-fail
     *  author  chl_seu
     *  创建日期  08.10.27
     */
    public boolean closeOutStream() {
        try {
            outStream.close();
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        }
    }

    /**
     *  函数名称  zipPath
     *  功能     压缩文件夹
     *  输入     inputFileName-要压缩的文件夹 outputFileName-输出的zip文件名（带路径）
     *  输出     true-success  false-fail
     *  author  chl_seu
     *  创建日期  08.10.27
     */
    public boolean zipPath(String inputFileName) {
        boolean bNodFoundFile = true;
        try {
            outStream.setMethod(ZipOutputStream.DEFLATED);
            zip(outStream, new File(inputFileName), "");
            /*注意当压缩文件夹为空时,将抛出异常*/
            outStream.flush();
        } catch (IOException e) {
            bNodFoundFile = false;
            logger.error(e.getMessage(), e);
        }
        return bNodFoundFile;
    }

    /**
     *  函数名称  zipAddFile
     *  功能      压缩文件夹
     *  输入      inputFileName-要压缩的文件夹 outputFileName-输出的zip文件名（带路径）
     *  输出      true-success  false-fail
     *  author  chl_seu
     *  创建日期  08.10.27
     */
    public boolean zipAddFile(String inputFileName) {
        boolean bNodFoundFile = true;
        try {
            zipFile(outStream, new File(inputFileName), "");
            outStream.flush();
        } catch (IOException e) {
            bNodFoundFile = false;
            logger.error(e.getMessage(), e);
        }
        return bNodFoundFile;
    }

    /**
     * 添加要压缩的文件。这里必须写全路径，可以同时支持多个文件和多个文件夹的混合压缩
     * @param srcFiles
     * @return
     */
    public boolean zip(String srcFiles[]) throws IOException {
        try {
            for (int i = 0; i < srcFiles.length; i++) {
                zip(this.outStream, new File(srcFiles[i]), "");
            }
        } catch (Exception e) {
            throw new IOException(e.getMessage(), e);
        } finally {
            closeOutStream();
        }
        return true;
    }


    private static void zip(ZipOutputStream out, File f, String base)
            throws IOException {
        FileInputStream in = null;
        try {
            if (f.isDirectory()) {
                File[] fl = f.listFiles();
                /*此处解决压缩未端数据不正确*/
                base = base.length() == 0 ? "" : base + "/";

                int indexSize = fl.length;
                for (int i = 0; i < indexSize; i++) {
                    zip(out, fl[i], fl[i].getName());
                }
            } else {
                out.putNextEntry(new ZipEntry(f.getName()));
                in = new FileInputStream(f);
                int b;
                byte[] buffer = new byte[4096];
                while ((b = in.read(buffer)) != -1) {
                    out.write(buffer, 0, b);
                }
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new IOException(e.getMessage(), e);
        } finally {
            try {
                out.flush();
                if (in != null) {
                    in.close();
                    in = null;
                }
            } catch (IOException e1) {
                logger.error(e1.getMessage(), e1);
            }
        }
    }

    private static void zipFile(ZipOutputStream out, File f, String base) {
        FileInputStream in = null;
        try {
            out.putNextEntry(new ZipEntry(f.getName()));
            in = new FileInputStream(f);
            int b;
            byte[] buffer = new byte[4096];
            while ((b = in.read(buffer)) != -1) {
                out.write(buffer, 0, b);
            }

        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            try {
                out.flush();
                if (in != null) {
                    in.close();
                    in = null;
                }
            } catch (IOException e1) {
            }
        }
    }

    /**
     * 删文件   
     * @param deleteFilePath
     *          删除文件路径   
     */
    public static void deleteFile(final String deleteFile) {
        File file = new File(deleteFile);
        deleteFile(file);
        file.delete();
    }

    /**
     * 实施删除文件   
     * @param file
     */
    private static void deleteFile(File file) {
        if (file.isDirectory()) {
            File[] fl = file.listFiles();
            int indexSize = fl.length;
            for (int i = 0; i < indexSize; i++) {
                deleteFile(fl[i]);
            }
            /*此处删除目录*/
            file.delete();
        } else {
            /*此处删除文件*/
            file.delete();
        }
    }

    /**
     * 名称 unZip
     * 功能 解压缩
     * @param inputZipName
     * @param sworkdate
     * @author wzf
     * 20081221
     */
    private static void unZipFile(String inputZipName, String sworkdate, String filePath) {
        try {
            filePath = filePath + sworkdate + "/";
            String fileName = filePath + inputZipName;

            ZipFile zipFile = new ZipFile(fileName);
            Enumeration emu = zipFile.entries();

            while (emu.hasMoreElements()) {
                ZipEntry entry = (ZipEntry) emu.nextElement();
                //会把目录作为一个file读出一次，所以只建立目录就可以，之下的文件还会被迭代到。
                if (entry.isDirectory()) {
                    new File(filePath + entry.getName()).mkdirs();
                    continue;
                }

                BufferedInputStream bis = new BufferedInputStream(zipFile.getInputStream(entry));
                File file = new File(filePath + entry.getName());
                //加入这个的原因是zipfile读取文件是随机读取的，这就造成可能先读取一个文件
                //而这个文件所在的目录还没有出现过，所以要建出目录来。
                File parent = file.getParentFile();
                if (parent != null && (!parent.exists())) {
                    parent.mkdirs();
                }
                FileOutputStream fos = new FileOutputStream(file);
                BufferedOutputStream bos = new BufferedOutputStream(fos, 4026);
                int count;
                byte data[] = new byte[4026];
                while ((count = bis.read(data, 0, 4026)) != -1) {
                    bos.write(data, 0, count);
                }
                bos.flush();
                bos.close();
                bis.close();
            }
            zipFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 遍历文件夹解压缩zip文件
     * @param sworkdate
     */
    public static void unZip(String sworkdate, String filePath) {
        filePath = filePath + sworkdate + "/";
        File dir = new File(filePath);
        File files[] = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                continue;
            } else {
                if ("zip".equalsIgnoreCase(file.getName().substring(file.getName().indexOf(".") + 1, file.getName().length()))) {
                    unZipFile(file.getName(), sworkdate, filePath);
                    deleteFile(file);
                }
            }
        }
    }
}
