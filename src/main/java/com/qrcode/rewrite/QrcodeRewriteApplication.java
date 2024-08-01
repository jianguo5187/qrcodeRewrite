package com.qrcode.rewrite;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qrcode.rewrite.mapper")
public class QrcodeRewriteApplication {

    public static void main(String[] args) {
        SpringApplication.run(QrcodeRewriteApplication.class, args);
    }

}
