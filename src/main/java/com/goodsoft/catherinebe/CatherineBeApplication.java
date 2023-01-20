package com.goodsoft.catherinebe;

import com.goodsoft.catherinebe.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@EnableConfigurationProperties(RsaKeyProperties.class)
public class CatherineBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatherineBeApplication.class, args);
    }

}
