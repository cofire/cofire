package com.cofire.basic.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * @author ly
 * @date 2018��8��17��
 */
public class ScannerDemo {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(new File("hello.txt")); // ��������ΪSystem.in���ԴӼ�������
        // �ļ����ݣ�hello 123 31313.111
        while (in.hasNext()) {
            System.out.println(in.next()); // hello
            System.out.println(in.nextInt()); // 123
            System.out.println(in.nextDouble()); // 31313.111
        }

        int data = 1234;
        double hello = -1234.13214134;
        System.out.printf("������%d\n", data); // 1234
        System.out.printf("��������%7.3f\n", hello); // -1234.132

        String outName = "out.txt"; // ����hello : world
        File outFile = new File(outName);
        System.out.println(outFile.getAbsolutePath());

        PrintWriter printer = new PrintWriter(outFile); // FileNotFoundException
        printer.printf("%s : %s\n", "hello", "world");
        printer.close();
    }
}
