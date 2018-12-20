package top.shownmmp.spring.enhance.project.java.base.knowledge.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author 吴启欢
 * @version 1.0
 * @date 2018-12-20 19:57
 */
public class FileSystemResourceTestDemo {
    public static void main(String[] args) throws Exception {
        String path = "E:/wuqihuan/project/SVN-test/spring_enhance_project/src/main/java/top/shownmmp/spring/enhance/project/java/base/knowledge/resource/read.txt";
        /*
         * 使用系统文件形式加载文件
         */
        FileSystemResource fileSystemResource = new FileSystemResource(path);
        /*
         *使用类路径加载文件
         */
        String path1 = "conf/read.txt";
        ClassPathResource classPathResource = new ClassPathResource(path1);
        OutputStream outputStream = fileSystemResource.getOutputStream();
        outputStream.write("spring,resource测试".getBytes());
        outputStream.close();

        /*
         *resource 接口读资源
         */
        InputStream inputStream = fileSystemResource.getInputStream();
        InputStream inputStream1 = classPathResource.getInputStream();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i;
        while ((i = inputStream.read()) != -1) {
            byteArrayOutputStream.write(i);
        }
        System.out.println(byteArrayOutputStream.toString());
        System.out.println("使用FileSystemResource：" + fileSystemResource.getFilename());
        System.out.println("使用ClassPathResource：" + classPathResource.getFilename());
        /*
         *还有一个ServletContextResource，用于web应用中
         */

    }


}
