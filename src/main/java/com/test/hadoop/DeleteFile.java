// DeleteFile.java
package com.test.hadoop;

import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class DeleteFile {
    public static void main(String[] args) throws IOException {
        // 읽을 입력 위치 받기
        String url = args[0];
        // 하둡 conf 설정
        Configuration conf = new Configuration();
        // 입력위치로 부터 파일 얻기
        FileSystem fs = FileSystem.get(URI.create(url), conf);

        Path path = new Path(url);
        // 파일 존재시, 
        if (fs.exists(path)) {
            fs.delete(path, false); 
        }

    }
}
