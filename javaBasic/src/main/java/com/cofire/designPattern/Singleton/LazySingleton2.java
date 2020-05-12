package com.cofire.designPattern.Singleton;

/**
 * �Ƿ� Lazy ��ʼ������
 * 
 * �Ƿ���̰߳�ȫ����
 * 
 * ʵ���Ѷȣ���
 * 
 * ���������ַ�ʽ�߱��ܺõ� lazy loading���ܹ��ڶ��߳��кܺõĹ��������ǣ�Ч�ʺܵͣ�99% ����²���Ҫͬ���� �ŵ㣺��һ�ε��òų�ʼ���������ڴ��˷ѡ�
 * ȱ�㣺������� synchronized ���ܱ�֤��������������Ӱ��Ч�ʡ�
 * 
 * @author ly
 * @date 2018��8��22��
 */
public class LazySingleton2 {
    private static LazySingleton2 instance;

    private LazySingleton2() {
    }

    public static synchronized LazySingleton2 getInstance() {
        if (instance == null) {
            instance = new LazySingleton2();
        }
        return instance;
    }
}
