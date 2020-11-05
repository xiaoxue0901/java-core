package com.demo.base.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author:autumn
 * @date: 2019/12/1 12:01 PM
 * @description:
 */
public class FileReaderAndWriter {

    public static void readerAndWriter() {
        FileReader reader=null;
        FileWriter writer = null;
        try {
            reader = new FileReader(new File("dbcp.txt"));
             writer = new FileWriter(new File("dbcp2.txt"));
            char[] readerChars = new char[24];
            int len;
            while ((len = reader.read(readerChars)) != -1){
                writer.write(readerChars, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader !=null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        readerAndWriter();
    }
}
