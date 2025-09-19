package io.github.tdminhnhat.core.util;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Component
@RequiredArgsConstructor
public class MinioUtil {

    private final MinioClient minioClient;

    @Value("${minio.bucket-name}")
    private String bucketName;

    public void uploadFile(String path, String fileName, MultipartFile file) throws Exception {
        InputStream inputStream = file.getInputStream();
        minioClient.putObject(PutObjectArgs.builder()
                .bucket(bucketName)
                .object(path + (path.endsWith("/") ? "" : "/") + fileName)
                .stream(inputStream, file.getSize(), - 1)
                .contentType(file.getContentType())
                .build());
    }
}
