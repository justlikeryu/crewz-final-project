package com.project.crewz.common.s3;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AwsS3 {
    private final AmazonS3Client awsS3;

    /* 1. 파일 업로드 */
    public String upload(final MultipartFile multipartFile,  final String path) {
        System.out.println("awsS3: " + awsS3.toString());
        String fileName = UUID.randomUUID().toString();
        try {
            // 메타데이터 생성
            ObjectMetadata objMeta = new ObjectMetadata();
            objMeta.setContentLength(multipartFile.getInputStream().available());
            // putObject(버킷명, 파일명, 파일데이터, 메타데이터)로 S3에 객체 등록
            awsS3.putObject(Bucket.bucket, path + "/" + fileName, multipartFile.getInputStream(), objMeta);
            // 등록된 객체의 url 반환 (decoder: url 안의 한글or특수문자 깨짐 방지)

            return URLDecoder.decode(awsS3.getUrl("crewz-bucket", fileName).toString(), "utf-8");
        } catch(IOException e) {
            System.out.println("AwsS3 upload Failed::" + e.getCause());

            return null;
        }
    }



    public boolean delete(final String keyName) {
        boolean flag = false;

        try{
            awsS3.deleteObject("crewz-bucket", keyName);
            flag = true;
        } catch(AmazonServiceException e) {
            System.out.println(e.getErrorMessage());
        }

        return flag;
    }
}
