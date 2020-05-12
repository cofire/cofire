package com.cofire.designPattern.Singleton;

/**
 * �Ƿ� Lazy ��ʼ������
 * 
 * �Ƿ���̰߳�ȫ����
 * 
 * ʵ���Ѷȣ���
 * 
 * ���������ַ�ʽ���������ʵ�ַ�ʽ������ʵ������������ǲ�֧�ֶ��̡߳���Ϊû�м��� synchronized�������ϸ��������������㵥��ģʽ�� ���ַ�ʽ
 * lazy loading �����ԣ���Ҫ���̰߳�ȫ���ڶ��̲߳�������������
 * 
 * @author ly
 * @date 2018��8��22��
 */
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

}
