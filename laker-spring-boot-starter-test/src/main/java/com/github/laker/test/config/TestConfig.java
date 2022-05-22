package com.github.laker.test.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author : [laker]
 * @className : TestConfig
 * @description : [描述说明该类的功能]
 * @date : 2022年05月21日 22:02
 * @createTime : [2022/5/21 22:02]
 */
@Configuration
@Data
@ConfigurationProperties(prefix = "laker")
public class TestConfig {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}
