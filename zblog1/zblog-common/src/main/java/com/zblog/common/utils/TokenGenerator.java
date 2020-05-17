package com.zblog.common.utils;

import com.zblog.common.exception.GlobalException;
import com.zblog.common.exception.enums.ErrorEnum;

import java.security.MessageDigest;
import java.util.UUID;

/**
 * @ClassName TokenGenerator
 * @Description 生成token
 * @Author zhengdf
 * @Data 2020/5/17 15:13
 * @Version 1.0
 **/
public class TokenGenerator {
    public static String generateValue() {
        return generateValue(UUID.randomUUID().toString());
    }

    private static final char[] hexCode = "0123456789abcdef".toCharArray();

    public static String toHexString(byte[] data) {
        if(data == null) {
            return null;
        }
        StringBuilder r = new StringBuilder(data.length*2);
        for ( byte b : data) {
            r.append(hexCode[(b >> 4) & 0xF]);
            r.append(hexCode[(b & 0xF)]);
        }
        return r.toString();
    }

    public static String generateValue(String param) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(param.getBytes());
            byte[] messageDigest = algorithm.digest();
            return toHexString(messageDigest);
        } catch (Exception e) {
            throw new GlobalException(ErrorEnum.TOKEN_GENERATOR_ERROR, e);
        }
    }
}
