package com.xuecheng.media;

import io.minio.*;
import io.minio.errors.MinioException;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author Administrator
 * @version 1.0
 * @description 测试MinIO
 * @date 2023/3/19 12:12
 */
public class MinIOTest {
    public static String bucket = "testbucket";
    public static String filepath = "png/desk.png";

    static MinioClient minioClient = MinioClient.builder()
            .endpoint("http://192.168.17.65:9000")
            .credentials("minioadmin", "minioadmin")
            .build();

    //上传
    public static void upload() throws IOException, NoSuchAlgorithmException, InvalidKeyException{
        try {
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucket).build());
            //检查testbucket桶是否创建，没有创建自动创建
            if (!found){
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
            }else {
                System.out.println("Bucket 'testbucket' already exists.");
            }
            //上传文件
            minioClient.uploadObject(UploadObjectArgs.builder()
                            .bucket(bucket)
                            .object(filepath)
                            .filename("D:\\Java\\fileTest\\desk.png")
                            .build());
            System.out.println("上传成功");
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
            System.out.println("HTTP trace: " + e.httpTrace());
        }
    }
    //删除
    public static void delete(String bucket, String filepath) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            minioClient.removeObject(RemoveObjectArgs.builder().bucket(bucket).object(filepath).build());
            System.out.println("删除成功");
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
            System.out.println("HTTP trace: " + e.httpTrace());
        }
    }
    //下载
    public static void getFile(String bucket, String filepath, String outFile) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            InputStream stream = minioClient.getObject(GetObjectArgs.builder().bucket(bucket).object(filepath).build());
            FileOutputStream outputStream = new FileOutputStream(new File(outFile));
            IOUtils.copy(stream, outputStream);
            System.out.println("下载成功");
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
            System.out.println("HTTP trace: " + e.httpTrace());
        }
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
//        upload();
//        delete(bucket, filepath);
        getFile(bucket,filepath,"D:\\Java\\fileTest2\\d.png");
    }
}
