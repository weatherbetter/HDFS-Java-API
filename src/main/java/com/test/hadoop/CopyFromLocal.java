// CopuFromLocal.java
package com.test.hadoop;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class CopyFromLocal {
    public static void main(String[] args) throws IOException {
        // 로컬 파일 위치
        String localSrc = args[0];
        // 목적지
        String dst = args[1];

        // 하둡 conf 설정
        Configuration conf = new Configuration();
        // 입력위치로 부터 파일 얻기
        FileSystem fs = FileSystem.get(URI.create(dst), conf);
        InputStream in = new BufferedInputStream(new FileInputStream(localSrc));
        OutputStream out = fs.create(new Path(dst));

        IOUtils.copyBytes(in, out, 4096, true);

    }
}
