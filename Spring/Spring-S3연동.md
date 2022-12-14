# Spring - S3 μ°λ

## AWS S3λ ?

<aside>
π‘ Simple Storage Serviceμ μ½μλ‘ νμΌ μλ²μ μ­ν μ νλ μλΉμ€λ€. μΌλ°μ μΈ νμΌμλ²λ νΈλν½μ΄ μ¦κ°ν¨μ λ°λΌμ μ₯λΉλ₯Ό μ¦μ€νλ μμμ ν΄μΌ νλλ° S3λ μ΄μ κ°μ κ²μ λννλ€. νΈλν½μ λ°λ₯Έ μμ€νμ μΈ λ¬Έμ λ κ±±μ ν  νμκ° μμ΄μ§λ€. λ νμΌμ λν μ κ·Ό κΆνμ μ§μ  ν  μ μμ΄μ μλΉμ€λ₯Ό νΈμ€ν μ©λλ‘ μ¬μ©νλ κ²μ λ°©μ§ ν  μ μλ€.

</aside>

β» μ°Έκ³  : [https://dev.classmethod.jp/articles/for-beginner-s3-explanation/](https://dev.classmethod.jp/articles/for-beginner-s3-explanation/)

μνμ λν μ΄λ―Έμ§λ₯Ό λΏλ¦΄ λ μΉμλ²κ° λ°λ‘ νλ λ νμνλ€.

S3λ₯Ό μ¬μ©ν  κ²½μ° AWSμ νμΌμ μ μ₯νκ³ , URIλ₯Ό ν΅ν΄ νλ‘ νΈ λ¨μΌλ‘ λμ Έμ€ μ μλ€.

S3 κ΄λ ¨ μ©μ΄ μ λ¦¬ : [https://daaa0555.tistory.com/471](https://daaa0555.tistory.com/471)

κ°λ¨νκ² μ λ¦¬νλ©΄ λ²ν·μ νλμ μ μ₯μ, κ°μ²΄λ νλμ νμΌ, ν€λ νμΌμ μ κ·ΌνκΈ° μν κ³ μ  κ°μ΄λ€.

S3μλ μ¬λ¬κ°μ§ μ’λ₯? ννμ ν΄λμ€κ° μ‘΄μ¬νμ§λ§, μΌλ¨ `Standard`λ‘ μ§ννλ€.

## AWS IAMμ΄λ ?

<aside>
π‘ AWS Identity and Access Management(IAM)μ AWS λ¦¬μμ€μ λν μ‘μΈμ€λ₯Ό μμ νκ² μ μ΄ν  μ μλ μΉ μλΉμ€μλλ€. IAMμ μ¬μ©νμ¬ λ¦¬μμ€λ₯Ό μ¬μ©νλλ‘ μΈμ¦(λ‘κ·ΈμΈ) λ° κΆν λΆμ¬(κΆν μμ)λ λμμ μ μ΄ν©λλ€.

</aside>

β» μ°Έκ³  : [https://docs.aws.amazon.com/ko_kr/IAM/latest/UserGuide/introduction.html](https://docs.aws.amazon.com/ko_kr/IAM/latest/UserGuide/introduction.html)

β» μ°Έκ³  : [https://choseongho93.tistory.com/263](https://choseongho93.tistory.com/263)

S3μ μ κ·Όνλ μ¬μ©μμ λν μ κ·Ό κΆνμ μν΄ IAMμ μ¬μ©.

## AWS μ€μ 

### S3 λ²ν· μμ±

![](imgs/Spring-S3μ°λ/λ²ν·μμ±.png)
- λ²ν· μ΄λ¦μ μλ ₯νκ³ , λ¦¬μ μ μμΈλ‘ μ§μ νλ€.
    - μ°λ¦¬κ° μλΉμ€ ν  μ§μ­μ΄ νκ΅­μ΄κΈ° λλ¬Έ.
    - ν λ¦¬μ μΌλ‘ ν  κ²½μ° ν΅μ  μμ μ±, κ°κ²© λΆλΆμμ μ΄μκ° μκΈΈ μ μλ€.
- μ°μ  λͺ¨λ  νΌλΈλ¦­ μμΈμ€μ λνμ¬ νμ©νλ€.

### λ²ν· μ ν

![λ²ν·λͺ©λ‘.png](imgs/Spring-S3μ°λ/λ²ν·λͺ©λ‘.png)
- λ²ν· μμ± ν λ³΄μ¬μ§λ λ²ν· λͺ©λ‘μΌλ‘, μμ±ν λ²ν·μΌλ‘ μ μνλ€.

### λ²ν· μ μ± μμ±

![λ²ν·.png](imgs/Spring-S3μ°λ/λ²ν·.png)
- κΆν ν­μ μ ννκ³ , λ²ν· μ μ± νΈμ§ λ²νΌμ ν΄λ¦­νλ€.

![λ²ν·μ μ±.png](imgs/Spring-S3μ°λ/λ²ν·μ μ±.png)

- μ΄λ ν μλΉμ€μ λν μ μ±μΈμ§ μ ννλ€.
    - S3 BucketμΌλ‘ μ ν
- μ μ± λ΄μ©μ λν μ€μ μ νλ€.
    - μμΈμ€ νμ©μ λν΄ μ€μ ν  κ²μ΄λ―λ‘ `Allow` λ‘ μ€μ νλ€.
    - μ΄λ ν νμλ€μ νμ©ν  κ²μΈμ§ μ ννλ€.
        - getObjcet
        - putObject
        - DeleteObject
    - μ΄λ€ λ¦¬μμ€μ λν μ€μ μΈμ§ μλ ₯νλ€.
        - μ°λ¦¬κ° μμ±ν λ²ν·μ λ¦¬μμ€ μ΄λ¦μ μμ±νλ€.
- `Add Statement` λ²νΌμ ν΄λ¦­νμ¬ μ μ±μ μΆκ°νλ€.
![λ²ν· μ μ±2.png](imgs/Spring-S3μ°λ/λ²ν·μ μ±2.png)

- μΆκ°λ μ μ±μ νμΈνκ³  `Generate Policy` λ²νΌμ ν΄λ¦­νμ¬ Key-Value ννλ‘ μ£Όμ΄μ§λ μ μ±μ λ³΅μ¬νλ€.

![λ²ν· μ μ±3.png](imgs/Spring-S3μ°λ/λ²ν·μ μ±3.png)
- λ²ν·μ κΆν ν­μΌλ‘ λμκ° λ³΅μ¬ν λ΄μ©μ μ μ¬μ§κ³Ό κ°μ΄ λΆμ¬λ£λλ€.
- μ£Όμ !!!! GetObject, PutObject, DeleteObject μ‘μμ λν μ μ±μ΄ μΆκ°λμμ κ²½μ° λ¦¬μμ€μ `/*` λ₯Ό μΆκ°ν΄μ£Όμ΄μΌ νλ€.
    
    (μ°Έκ³  : [https://bobbyhadz.com/blog/aws-s3-action-does-not-apply-to-resources](https://bobbyhadz.com/blog/aws-s3-action-does-not-apply-to-resources) ) 
    
- `λ³κ²½ μ¬ν­ μ μ₯` λ²νΌμ ν΄λ¦­νλ€.

## IAM μ€μ 

![iam0.png](imgs/Spring-S3μ°λ/IAM0.png)
- `IAM` μ κ²μνκ³ , λ¦¬μμ€μ λν μ‘μΈμ€ κ΄λ¦¬ μλΉμ€λ₯Ό μ ννλ€.

![IAM.png](imgs/Spring-S3μ°λ/IAM1.png)
- μ¬μ©μ λ° μ«μλ₯Ό ν΄λ¦­νλ€.

![IAM2.png](imgs/Spring-S3μ°λ/IAM2.png)
- `μ¬μ©μ μΆκ°` λ²νΌμ ν΄λ¦­νλ€.

![IAM3.png](imgs/Spring-S3μ°λ/IAM3.png)
- μ¬μ©μ μ΄λ¦μ μλ ₯νλ€.
- μκ²© μ¦λͺ μ νμ `μ‘μΈμ€ ν€`λ‘ μ ννλ€.
- `λ€μ:κΆν` λ²νΌμ ν΄λ¦­νλ€.

![IAM4.png](imgs/Spring-S3μ°λ/IAM4.png)
- `κΈ°μ‘΄ μ μ± μ§μ  μ°κ²°` μ ν΄λ¦­νλ€.
- μ μ± νν°μ s3full μ μλ ₯νκ³  μ²΄ν¬νλ€.
- `λ€μ: νκ·Έ` λ²νΌμ ν΄λ¦­νλ€.
- νκ·Έ μΆκ°λ μλ΅νκ³  `λ€μ: κ²ν ` λ²νΌμ ν΄λ¦­νλ€.

![IAM5.png](imgs/Spring-S3μ°λ/IAM5.png)
- μ¬μ©μκ° λ§λ€μ΄μ§λ©΄ `.csv λ€μ΄λ‘λ` λ²νΌμ ν΄λ¦­νμ¬ usernameμ λν access keyλ₯Ό νλνλ€.

## μ€νλ§ μ€μ 

- μ°Έκ³  λΈλ‘κ·Έ
    - [https://antdev.tistory.com/93](https://antdev.tistory.com/93)
    - [https://earth-95.tistory.com/117](https://earth-95.tistory.com/117)
- build.gradle
    
    ```
    dependencies {
        implementation 'org.springframework.cloud:spring-cloud-starter-aws:2.2.6.RELEASE'
    }
    ```
    
- νλ‘νΌν° μμ± (λ μ€μ μμ μκ² λ§λ κ²μΌλ‘ μ¬μ©)
    - application.yml
        
        ```
        cloud:
          aws:
            s3:
              bucket: bucket-nameμ μμ±ν΄μ£ΌμΈμ
            credentials:
              access-key: accessKeyλ₯Όμλ ₯ν΄μ£ΌμΈμ
              secret-key: secretKeyλ₯Όμλ ₯ν΄μ£ΌμΈμ
            region:
              static: ap-northeast-2
              auto: false
            stack:
              auto: false
        ```
        
    - application.properties
        
        ```
        # S3 Bucket
        # cloud.aws.stack.auto μμ±μ μ§μ νμ§ μμΌλ©΄ StackTraceκ° λ°μν  μ μμ.
        # properties νμΌμμ μ€μ νλμ§, @SpringBootApplication ν΄λμ€μμ μ€μ νλμ§
        cloud.aws.credentials.accessKey=accessKeyλ₯Όμλ ₯ν΄μ£ΌμΈμ
        cloud.aws.credentials.secretKey=secretKeyλ₯Όμλ ₯ν΄μ£ΌμΈμ
        cloud.aws.stack.auto=false
        
        # AWS S3 Service bucket
        cloud.aws.s3.bucket=bucket-nameμ μμ±ν΄μ£ΌμΈμ
        cloud.aws.region.static=ap-northeast-2
        
        # multipart μ¬μ΄μ¦ μ€μ 
        spring.http.multipart.max-file-size=1024MB
        spring.http.multipart.max-request-size=1024MB
        
        # EC2λ₯Ό μ¬μ©νλ κ²μ΄ μλκΈ° λλ¬Έμ EC2μ λν μλ¬λ λμ°μ§ μλλ‘ μ€μ .
        logging.level.com.amazonaws.util.EC2MetadataUtils=error
        logging.level.com.amazonaws.internal.InstanceMetadataServiceResourceFetcher=error
        ```
        
- Config νμΌ μμ±
    
    ```java
    package com.cloneproject.ssgjojo.config;
    
    import com.amazonaws.auth.AWSStaticCredentialsProvider;
    import com.amazonaws.auth.BasicAWSCredentials;
    import com.amazonaws.services.s3.AmazonS3;
    import com.amazonaws.services.s3.AmazonS3Client;
    import com.amazonaws.services.s3.AmazonS3ClientBuilder;
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.context.annotation.Primary;
    
    @Configuration
    public class AWSS3Config {
        // properties accessKey κ° μ£Όμ
        @Value("${cloud.aws.credentials.accessKey}")
        private String accessKey;
    
        // properties secretKey μ£Όμ
        @Value("${cloud.aws.credentials.secret-key}")
        private String secretKey;
    
        // properties region μ£Όμ
        @Value("${cloud.aws.region.static}")
        private String region;
    
        // aws μκ²©μ¦λͺ μμ±
        @Bean
        @Primary
        public BasicAWSCredentials awsCredentialsProvider(){
            BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(accessKey, secretKey);
            return basicAWSCredentials;
        }
    
        // S3 κ°μ²΄ μμ±
        @Bean
        public AmazonS3 amazonS3() {
            AmazonS3 s3Builder = AmazonS3ClientBuilder.standard()
                    .withRegion(region)
                    .withCredentials(new AWSStaticCredentialsProvider(awsCredentialsProvider()))
                    .build();
            return s3Builder;
        }
    }
    ```
    
- Controller
    
    ```java
    package com.cloneproject.ssgjojo.util.s3;
    
    import lombok.RequiredArgsConstructor;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;
    import org.springframework.web.multipart.MultipartFile;
    import org.springframework.web.bind.annotation.*;
    
    import java.util.List;
    
    @RestController
    @RequestMapping("/api")
    @RequiredArgsConstructor
    public class AwsS3Controller {
        private final AwsS3Service awsS3Service;
    
        @PostMapping("/resource")
        public List<FileInfoDto> upload(@RequestParam("file1")List<MultipartFile> file) {
            return awsS3Service.upload(file);
        }
    }
    ```
    
- Service
    
    ```java
    package com.cloneproject.ssgjojo.util.s3;
    
    import lombok.RequiredArgsConstructor;
    import org.springframework.stereotype.Service;
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.web.multipart.MultipartFile;
    
    import java.util.ArrayList;
    import java.util.List;
    
    @Service
    @RequiredArgsConstructor
    public class AwsS3Service {
        private final AwsS3ResourceStorage awsS3ResourceStorage;
    
        @Value("${cloud.aws.s3.bucket}")
        private String bucket;
    
        public List<FileInfoDto> upload(List<MultipartFile> file) {
            List<FileInfoDto> returnDto = new ArrayList<>();
    
            for(MultipartFile temp : file) {
                FileInfoDto fileInfoDto = FileInfoDto.multipartOf(temp);
                awsS3ResourceStorage.store(fileInfoDto, temp);
                returnDto.add(fileInfoDto);
            }
    
            return returnDto;
        }
    }
    ```
    
- FileInfoDto
    
    ```java
    package com.cloneproject.ssgjojo.util.s3;
    
    import com.cloneproject.ssgjojo.util.MultipartUtil;
    import lombok.*;
    import org.springframework.web.multipart.MultipartFile;
    
    import java.time.LocalDateTime;
    
    @Getter
    @Setter
    @ToString
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public class FileInfoDto {
        private String id;
        private String name;
        private String format;
        private String localPath;
        private String remotePath;
        private long bytes;
    
        @Builder.Default
        private LocalDateTime createTime = LocalDateTime.now();
    
        public static FileInfoDto multipartOf(MultipartFile multipartFile) {
            final String fileId = MultipartUtil.createFileUUID();
            final String format = MultipartUtil.getFormat(multipartFile.getContentType());
    
            return FileInfoDto.builder()
                    .id(fileId)
                    .name(multipartFile.getOriginalFilename())
                    .format(format)
                    .localPath(MultipartUtil.createLocalPath(fileId, format))
                    .bytes(multipartFile.getSize())
                    .build();
        }
    }
    ```
    
- Storage
    
    ```java
    package com.cloneproject.ssgjojo.util.s3;
    
    import com.amazonaws.services.s3.AmazonS3;
    import lombok.RequiredArgsConstructor;
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.stereotype.Component;
    import org.springframework.web.multipart.MultipartFile;
    
    import java.io.File;
    
    @Component
    @RequiredArgsConstructor
    public class AwsS3ResourceStorage {
        @Value("${cloud.aws.s3.bucket}")
        private String bucket;
        private final AmazonS3 amazonS3;
    
        public void store(FileInfoDto fileInfoDto, MultipartFile multipartFile) {
            File file = new File(fileInfoDto.getLocalPath());
    
            try {
                multipartFile.transferTo(file);
    
                amazonS3.putObject(bucket, fileInfoDto.getRemotePath(), file);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            finally {
                if(file.exists())
                    file.delete();
            }
        }
    }
    ```
