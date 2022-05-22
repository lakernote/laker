package com.github.laker.test;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;

/**
 * @author : [laker]
 * @className : Test
 * @description : [描述说明该类的功能]
 * @date : 2022年05月22日 20:13
 * @createTime : [2022/5/22 20:13]
 */
public class Test {
    /**
     * 16长度
     */
    private final static String KEY = "1234567890123456";

    public static void main(String[] args) {
        AES aes = SecureUtil.aes(StrUtil.bytes(KEY, CharsetUtil.CHARSET_UTF_8));
        String enc = aes.encryptHex("laker11111111111111111");
        System.out.println(enc);
        String s = aes.decryptStr(enc);
        System.out.println(s);

    }
}
