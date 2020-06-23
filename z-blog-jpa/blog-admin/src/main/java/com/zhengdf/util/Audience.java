package com.zhengdf.util;

/**
 * @ClassName Audience
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/6/24 0:21
 * @Version 1.0
 **/
public class Audience {
    // 代表这个JWT的接收对象,存入audience
    public static String clientId = "098f6bcd4621d373cade4e832627b4f6";
    // 密钥, 经过Base64加密, 可自行替换
    public static String base64Secret = "MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=";
    // JWT的签发主体，存入issuer
    public static String name = "restapiuser";
    // 过期时间，时间戳
    public static int expiresSecond = 172800;

}
