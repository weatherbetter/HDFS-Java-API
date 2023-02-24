// FileSystemPrint.java
package com.test.hadoop;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class FileSystemPrint {
    public static void main(String[] args) throws IOException {
        // 읽을 입력 위치 받기
        String url = args[0];
        // 하둡 conf 설정
        Configuration conf = new Configuration(); 
        // 입력위치로 부터 파일 얻기
        FileSystem fs = FileSystem.get(URI.create(url), conf);
        // 파일 열기
        try (InputStream in = fs.open(new Path(url))) {
            // 출력
            IOUtils.copyBytes(in, System.out, 4096 , false);
        }
        
    }
}
