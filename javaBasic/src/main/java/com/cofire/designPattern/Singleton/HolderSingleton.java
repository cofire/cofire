package com.cofire.designPattern.Singleton;

/**
 * �Ƿ� Lazy ��ʼ������
 * 
 * �Ƿ���̰߳�ȫ����
 * 
 * ʵ���Ѷȣ�һ��
 * 
 * ���������ַ�ʽ�ܴﵽ˫������ʽһ���Ĺ�Ч����ʵ�ָ��򵥡��Ծ�̬��ʹ���ӳٳ�ʼ����Ӧʹ�����ַ�ʽ������˫������ʽ�����ַ�ʽֻ�����ھ�̬��������˫������ʽ����ʵ������Ҫ�ӳٳ�ʼ��ʱʹ�á�
 * 
 * @author ly
 * @date 2018��8��22��
 */
public class HolderSingleton {
    private static class SingletonHolder {
        private static final HolderSingleton INSTANCE = new HolderSingleton();
    }

    private HolderSingleton() {
    }

    public static final HolderSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
