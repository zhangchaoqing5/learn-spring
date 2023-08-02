package org.kira;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhang chaoqing
 * @date 2023/8/1 11:56
 */
@SpringBootApplication

public class MultipleDataSourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MultipleDataSourceApplication.class);
    }
}
