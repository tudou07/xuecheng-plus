package com.xuecheng.media;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 * @description 测试大文件的上传方法
 * @date 2023/3/23 23:41
 */
public class BigFileTest {
    @Test
    public void testChunk() throws IOException {
        File sourceFile = new File("D:\\Java\\fileTest\\1跳舞.mp4");
        String chunkFilePath = "D:\\Java\\fileTest\\chunk\\";
        File chunkFolder = new File(chunkFilePath);
        if (!chunkFolder.exists()){
            chunkFolder.mkdirs();
        }
        int chunkSize = 1024*1024*1;
        int chunkNum = (int) Math.ceil(sourceFile.length()*1.0 / chunkSize);
        byte[] bytes = new byte[1024];
        RandomAccessFile raf_r = new RandomAccessFile(sourceFile, "r");
        for (int i = 0; i < chunkNum; i++) {
            File chunkFile = new File(chunkFilePath + i);
            RandomAccessFile raf_rw = new RandomAccessFile(chunkFile, "rw");
            int len = -1;
            while ((len = raf_r.read(bytes)) != -1){
                raf_rw.write(bytes, 0, len);
                if (chunkFile.length() >= chunkSize){
                    break;
                }
            }
            raf_rw.close();
        }
        raf_r.close();
    }

    @Test
    public void testMerge() throws IOException {
        File chunkFolder = new File("D:\\Java\\fileTest\\chunk\\");
        File sourceFile = new File("D:\\Java\\fileTest\\1跳舞.mp4");
        File mergeFile = new File("D:\\Java\\fileTest\\2跳舞.mp4");
        File[] files = chunkFolder.listFiles();
        List<File> fileList = Arrays.asList(files);
        Collections.sort(fileList, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return Integer.parseInt(o1.getName()) - Integer.parseInt(o2.getName());
            }
        });
        RandomAccessFile raf_rw = new RandomAccessFile(mergeFile, "rw");
        byte[] bytes = new byte[1024];
        for (File file : fileList) {
            RandomAccessFile raf_r = new RandomAccessFile(file, "r");
            int len = -1;
            while ((len = raf_r.read(bytes)) != -1){
                raf_rw.write(bytes, 0, len);
            }
            raf_r.close();
        }
        raf_rw.close();
        FileInputStream fileInputStream_merge = new FileInputStream(mergeFile);
        FileInputStream fileInputStream_source = new FileInputStream(sourceFile);
        String md5_merge = DigestUtils.md5Hex(fileInputStream_merge);
        String md5_source = DigestUtils.md5Hex(fileInputStream_source);
        if (md5_merge.equals(md5_source)){
            System.out.println("文件合并完成");
        }

    }
}
