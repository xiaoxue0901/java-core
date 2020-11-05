package com.demo.base.io;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author:autumn
 * @date: 2019/12/1 10:52 AM
 * @description: FileInputStream的使用
 */
@Slf4j
public class FileInputStreamUtils {
    public static void fileInputStream2(){
        FileInputStream fis = null;
        try {
            File file = new File("hello.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            fis = new FileInputStream(file);
            byte[] b = new byte[5];
            int len;
            // read(): 读取文件的一个字节, 当执行到文件结尾时, 返回-1.
            while ((len = fis.read(b))!=-1) {
                /*for (int i = 0; i < len; i++) {
                    System.out.println((char) b[i]);
                }*/
                // 或者
                String str = new String(b, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 从硬盘存在的一个文件中, 读取其内容到程序中, 使用FileInputStream
     * 要读取的文件一定要存在, 否则抛FileNotFountException
     * @throws IOException
     */
    public static void fileInputStream1() throws IOException {
        File file = new File("hello.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileInputStream fis = new FileInputStream(file);
        int b;
        // read(): 读取文件的一个字节, 当执行到文件结尾时, 返回-1.
        while ((b=fis.read())!=-1) {
            log.info("{}",(char)b);
        }
        // 关闭流
        fis.close();
    }

    public static void main(String[] args) {
        try {
            fileInputStream1();
            fileInputStream2();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
