package com.java.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * 学习字节流， 包括节点09
 * InputStreamAndOutputStream
 * @Desc:
 * @Company: TigerZ
 * @author Wang Jingci
 * @date 2018年1月21日 下午3:32:46
 */
public class InputStreamAndOutputStream {
    public static void main (String[] args) {
        // 获取文件路径,大概有如下方法:
        // APP.class.getResource("TestFile.txt") 参数是相对路径或是绝对路径，返回绝对路径/E:/java/.../TestFile.txt
        // APP.class.getClassLoader.getResource("TestFile.txt") 只能输入相对路径，并且是相对的包根节点的相对路径
        URL url = InputStreamAndOutputStream.class.getResource("TestFile.txt");
        String path = url.getPath();
        try {
            // 创建节点流
            InputStream is = new FileInputStream(path);
            // 创建功能流
            BufferedInputStream  bis = new BufferedInputStream(is);
            byte[] buffer = new byte[100];
            try {
                int len = 0;
                StringBuffer sb = new StringBuffer();
                while ((len=bis.read(buffer)) > 0) {
                    String str = new String(buffer,"UTF-8");
                    sb.append(str);
                }
                System.out.println(sb.toString());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("文件没有找到");
            e.printStackTrace();
        }
    }

}
