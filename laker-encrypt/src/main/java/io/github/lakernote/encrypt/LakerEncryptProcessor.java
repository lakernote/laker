
package io.github.lakernote.encrypt;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.OriginTrackedMapPropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;

public class LakerEncryptProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        // 获取秘钥
        String encKey = environment.getProperty("enc.key");

        // 处理加密数据
        if (StrUtil.isNotBlank(encKey)) {
            HashMap<String, Object> map = new HashMap<>();
            for (PropertySource<?> ps : environment.getPropertySources()) {
                if (ps instanceof OriginTrackedMapPropertySource) {
                    OriginTrackedMapPropertySource source = (OriginTrackedMapPropertySource) ps;
                    for (String name : source.getPropertyNames()) {
                        Object value = source.getProperty(name);
                        if (value instanceof String) {
                            String str = (String) value;
                            if (str.startsWith("enc:")) {
                                map.put(name, SecureUtil.aes(StrUtil.bytes(encKey, CharsetUtil.CHARSET_UTF_8)).decryptStr(str.substring(4), CharsetUtil.CHARSET_UTF_8));
                            }
                        }
                    }
                }
            }
            // 将解密的数据放入环境变量，并处于第一优先级上
            if (CollUtil.isNotEmpty(map)) {
                environment.getPropertySources().addFirst(new MapPropertySource("laker-encrypt", map));
            }
        }
    }
}
