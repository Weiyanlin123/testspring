package com.citycloud.dcm.street.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PutObjectRequest;

import java.io.*;

/**
 * @author weiyl
 * @date 2020/11/27 13:53
 */
public class OssDownLoadUtil {

    private static String endpoint = "http://oss-cn-hz-zt-d01-a.zt-ops.com/jxhglpt";
    private static String accessKeyId = "zVWLB3DZZV7lnzBu";
    private static String accessKeySecret = "N91OsjGfT0PmboxJ9h91G2GaH7SOsr";

    private static String bucketName = "jxhglpt";
    //<key>表示从OSS下载文件时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
    private static String key = "abc/efg/123.jpg";


    public static void main(String[] args) throws IOException {
        OSS client = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            String content = "Thank you for using Aliyun Object Storage Service";
            client.putObject(bucketName, key, new ByteArrayInputStream(content.getBytes()));
            client.putObject(new PutObjectRequest(bucketName, key, createSampleFile()));
            OSSObject object = client.getObject(new GetObjectRequest(bucketName, key));
            displayTextInputStream(object.getObjectContent());

        } catch (OSSException oe) {
        } catch (Exception ce) {
        } finally {
            client.shutdown();
        }
    }

    private static File createSampleFile() throws IOException {
        File file = File.createTempFile("oss-java-sdk-", ".txt");
        file.deleteOnExit();
        Writer writer = new OutputStreamWriter(new FileOutputStream(file));
        writer.write("abcdefghijklmnopqrstuvwxyz\n");
        writer.write("0123456789011234567890\n");
        writer.close();
        return file;
    }

    private static void displayTextInputStream(InputStream input) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        while (true) {
            String line = reader.readLine();
            if (line == null){
                System.out.println("\t" + line);
                break;
            }
        }
        reader.close();
    }
}
