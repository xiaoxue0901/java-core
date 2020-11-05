package com.demo.java8.chap3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author:autumn
 * @date: 2019/12/18 10:37 PM
 * @description: 环绕执行模式
 */
public class ExecuteAround {


    /**
     * 1. 行为参数化:把processFile的行为参数化
     * @return
     * @throws IOException
     */
    public static String processFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        return br.readLine();
    }



    /**
     * 2.  定义BufferedReaderProcessFile函数式接口
     */
    @FunctionalInterface
    interface BufferedReaderProcessFile {
        String process(BufferedReader bufferedReader) throws IOException;
    }

    /**
     * 3. 执行一个行为
     * @param file
     * @return
     */
    public static String processFile(BufferedReaderProcessFile file) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("data.txt"));
            return file.process(br);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        // 4. 传递lambda: 可以传递不同的lambda
        String line = processFile((BufferedReader br) -> br.readLine()+br.readLine());
    }
}
