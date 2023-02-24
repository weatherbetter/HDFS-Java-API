// ListStatus.java
package com.test.hadoop;

import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;

public class ListStatus {
    public static void main(String[] args) throws IOException {
        // 읽을 입력 위치 받기
        String url = args[0];
        // 하둡 conf 설정
        Configuration conf = new Configuration();
        // 입력위치로 부터 파일 얻기
        FileSystem fs = FileSystem.get(URI.create(url), conf);
        
        Path path = new Path(url);
        // 파일 리스트 배열 받기
        FileStatus[] status = fs.listStatus(path);
        Path[] listPaths = FileUtil.stat2Paths(status);
        for (Path p : listPaths){
            System.out.println(p);
        }  
    }
}
