package com.demo.base.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author:autumn
 * @date: 2019/12/1 7:59 PM
 * @description:
 */
public class OtherStreamUtil {
    /**
     * 标准输入输出流
     */
    public static void stdStream() {

        BufferedReader bufferedReader = null;
        try {
            InputStream inputStream = System.in;
            InputStreamReader reader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(reader);
            String str = null;
            while (true) {
                System.out.println("请输入字符串:");
                str = bufferedReader.readLine();
                if (str.equalsIgnoreCase("e") || str.endsWith("exit")) {
                    break;
                }
                System.out.println(str.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
