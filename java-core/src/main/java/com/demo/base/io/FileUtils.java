package com.demo.base.io;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

/**
 * @author:autumn
 * @date: 2019/11/27 8:44 PM
 * @description:
 */
@Slf4j
public class FileUtils {



    private static void test3() throws IOException {
        File file = new File("/Users/xql/workspace/github/java-core/src/main/java/com/demo/base/io/abstext1.txt");
        // 删除文件
        if(file.exists()) {
            boolean result = file.delete();
            log.info("删除结果:{}", result);
        }

        // 创建文件
        if(!file.exists()) {
            boolean result = file.createNewFile();
            log.info("创建结果:{}", result);
        }

        // 创建文件夹
        File file1 = new File("/Users/xql/workspace/github/java-core/src/main/java/com/demo/base/io/io2");
        if (!file1.exists()) {
            boolean result = file1.mkdir();
            log.info("创建文件夹:{}", result);
            // 上层目录不存在则创建上层目录
            boolean result2 = file1.mkdirs();
            log.info("创建文件夹:{}", result2);
        }

        // 读目录下所有文件
        File[] files = file1.listFiles();

        // 查看文件目录下的文件名
        String[] strings = file1.list();

    }
    private static void test2() {
        File absFile = new File("/Users/xql/workspace/github/java-core/src/main/java/com/demo/base/io/abstext1.txt");
        log.info("文件是否存在{}",absFile.exists());
        log.info("文件是否可写:{}", absFile.canWrite());
        log.info("文件是否可读:{}", absFile.canRead());
        log.info("是否是一个文件:{}",absFile.isFile());
        log.info("是否是一个目录:{}", absFile.isDirectory());
        log.info("最后一次修改:{}", absFile.lastModified());
        log.info("文件长度:{}", absFile.length());
    }

    /**
     * 1
     */
    private static void visitFileName() {
        // 绝对路径
        File absFile = new File("/Users/xql/workspace/github/java-core/src/main/java/com/demo/base/io/abstext1.txt");
        log.info("获取文件名称:{}", absFile.getName());
        log.info("获取文件:{}", absFile.getPath());
        log.info("获取文件绝对路径:{}", absFile.getAbsoluteFile());
        log.info("获取文件相对路径:{}", absFile.getAbsolutePath());
        log.info("获取文件父类:{}", absFile.getParent());
        // 相对路径
        File relFile = new File("com/demo/base/io/relativeText2.txt");
        log.info("获取文件名称:{}", relFile.getName());
        log.info("获取文件:{}", relFile.getPath());
        log.info("获取文件绝对路径:{}", relFile.getAbsoluteFile());
        log.info("获取文件相对路径:{}", relFile.getAbsolutePath());
        log.info("获取文件父类:{}", relFile.getParent());

        // renameTo
        File oldName = new File("com/demo/base/io/oldFile.txt");
        boolean flag = oldName.renameTo(new File("com/demo/base/io/newFile.txt"));
        log.info("更名结果:{}", flag);
    }

    public static void main(String[] args) throws IOException {
        visitFileName();
        test2();
        test3();
    }

}
