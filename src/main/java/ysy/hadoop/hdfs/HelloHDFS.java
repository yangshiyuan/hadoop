package ysy.hadoop.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;

import java.io.FileInputStream;
import java.net.URL;

public class HelloHDFS {

    public static void main(String[] args) throws Exception {
        /*URL url = new URL("http://www.baidu.com");
        IOUtils.copyBytes(url.openStream(), System.out, 4096, true);*/

        /*URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
        URL url = new URL("hdfs://192.168.56.100:9000/hello.txt");
        IOUtils.copyBytes(url.openStream(), System.out, 4096, true);*/

        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://master:9000");
        FileSystem fileSystem = FileSystem.get(conf);

        /*System.out.println(fileSystem.mkdirs(new Path("/dirs")));

        System.out.println(fileSystem.exists(new Path("/dirs")));

        System.out.println(fileSystem.exists(new Path("/hello.txt")));

        System.out.println(fileSystem.delete(new Path("/dirs"), true));

        System.out.println(fileSystem.exists(new Path("/dirs")));

        FSDataOutputStream outputStream = fileSystem.create(new Path("/test.txt"));
        FileInputStream inputStream = new FileInputStream("D:\\BaiduNetdiskDownload\\马老师公开课.txt");
        IOUtils.copyBytes(inputStream, outputStream, 4096, true);*/

        FileStatus[] fileStatuses = fileSystem.listStatus(new Path("/"));
        for (FileStatus status : fileStatuses) {
            System.out.println(status);
        }
    }
}
