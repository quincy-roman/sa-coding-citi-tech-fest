package io.legendofjava.sacoding.s3;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.IOUtils;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.StandardCopyOption;

@Component
@RequiredArgsConstructor
public class S3Service {
    private final AmazonS3 s3Client;

    @Value("${s3.bucket.name}")
    private String bucketName;
    public File downloadFileFromS3(String filename) throws IOException {
        S3Object object = s3Client.getObject(new GetObjectRequest(bucketName, filename));
        object.getObjectMetadata();
        InputStream stream = object.getObjectContent();
        File file = new File(filename);
        FileUtils.copyInputStreamToFile(stream, file);
        return file;
    }

    public void uploadFileToS3(String fileName){
        PutObjectRequest request = new PutObjectRequest(bucketName,
                fileName, new File(fileName));
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType("plain/text");
        request.setMetadata(metadata);
        s3Client.putObject(request);
    }

}
