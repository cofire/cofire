package com.cofire.common.utils.sftp;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SftpUtil {
    private final static Logger logger = LoggerFactory.getLogger(SftpUtil.class);

    public static void main(String[] args) throws Exception {
        SftpUtil sftpUtil = new SftpUtil();
        ChannelSftp channel = sftpUtil.connectSFTP("192.168.202.128", "mysftp", "", 22, "C:/Temp/udavat.ppk");
        File file = new File("D:/111.txt");
        sftpUtil.upload("/upload/", file, channel, "aaa.txt");
        sftpUtil.disconnected(channel);
    }

    public ChannelSftp connectSFTP(String host, String username, String password, int port, String privateKey) throws JSchException {
/*    	Properties prop= BaseSupport.CommonUtil.getProperties("/configs/sftp.properties");
    	String host = prop.getProperty("host");
    	String username = prop.getProperty("username");
    	String password = prop.getProperty("password");
    	int port = Integer.valueOf(prop.getProperty("port"));*/
        JSch jsch = new JSch();
        Channel channel = null;
        try {
            if (privateKey != null && !"".equals(privateKey)) {
/*                //使用密钥验证方式，密钥可以使有口令的密钥，也可以是没有口令的密钥
                if (passphrase != null && "".equals(passphrase)) {
                    jsch.addIdentity(privateKey, passphrase);
                } else {*/
                jsch.addIdentity(privateKey);
                //}
            }
            Session session = jsch.getSession(username, host, port);
            if (password != null && !"".equals(password)) {
                session.setPassword(password);
            }
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");// do not verify host key
            session.setConfig(sshConfig);
            // session.setTimeout(timeout);
            session.setServerAliveInterval(92000);
            session.connect();
            //参数sftp指明要打开的连接是sftp连接
            channel = session.openChannel("sftp");
            channel.connect();
        } catch (JSchException e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
        return (ChannelSftp) channel;
    }

    /**
     * 获取连接
     * host;//sftp服务器ip
     * username;//用户名
     * password;//密码
     * privateKey;//密钥文件路径
     * passphrase;//密钥口令
     * port = 22;//默认的sftp端口号是22
     *
     * @return channel
     * @throws JSchException
     */
    public ChannelSftp connectSFTP(String host, int port, String username, String password, String privateKey) throws JSchException {
        JSch jsch = new JSch();
        Channel channel = null;
        try {
            if (privateKey != null && !"".equals(privateKey)) {
                //使用密钥验证方式，密钥可以使有口令的密钥，也可以是没有口令的密钥
            	/* if (passphrase != null && "".equals(passphrase)) {
                    jsch.addIdentity(privateKey, passphrase);
                } else {*/
                jsch.addIdentity(privateKey);
                //}
            }
            Session session = jsch.getSession(username, host, port);
            if (password != null && !"".equals(password)) {
                session.setPassword(password);
            }
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");// do not verify host key
            session.setConfig(sshConfig);
            // session.setTimeout(timeout);
            session.setServerAliveInterval(92000);
            session.connect();
            //参数sftp指明要打开的连接是sftp连接
            channel = session.openChannel("sftp");
            channel.connect();
        } catch (JSchException e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
        return (ChannelSftp) channel;
    }

    /**
     * 上传文件
     *
     * @param directory   上传的目录
     * @param uploadFile  要上传的文件
     * @param sftp
     * @param newFileName
     * @throws Exception
     */
    public void upload(String directory, File file, ChannelSftp sftp, String newFileName) throws Exception {
        try {
            sftp.cd(directory);
            sftp.put(new FileInputStream(file), newFileName);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
    }

    /**
     * 下载文件
     *
     * @param directory    下载目录
     * @param downloadFile 下载的文件
     * @param saveFile     存在本地的路径
     * @param sftp
     * @throws Exception
     */
    public void download(String directory, String downloadFile,
                         String saveFile, ChannelSftp sftp) throws Exception {
        try {
            sftp.cd(directory);
            sftp.get(downloadFile, saveFile);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
    }

    /**
     * 下载文件
     *
     * @param directory    下载目录
     * @param downloadFile 下载的文件
     * @param saveFile     存在本地的路径
     * @param sftp
     */
    public void download(String directory, String downloadFile, ChannelSftp sftp, String dst) {
        try {
            sftp.cd(directory);
            sftp.get(downloadFile, dst);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * 删除文件
     *
     * @param directory  要删除文件所在目录
     * @param deleteFile 要删除的文件
     * @param sftp
     * @throws Exception
     */
    public void delete(String directory, String deleteFile, ChannelSftp sftp) throws Exception {
        try {
            sftp.cd(directory);
            sftp.rm(deleteFile);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
    }

    public void disconnected(ChannelSftp sftp) throws JSchException {
        if (sftp != null) {
            try {
                sftp.getSession().disconnect();
            } catch (JSchException e) {
                logger.error(e.getMessage(), e);
                throw e;
            } finally {
                sftp.disconnect();
            }
        }
    }
}
