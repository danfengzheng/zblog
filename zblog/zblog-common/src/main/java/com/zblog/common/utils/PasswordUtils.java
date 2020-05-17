package com.zblog.common.utils;

/**
 * @ClassName PasswordUtils
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/5/17 19:54
 * @Version 1.0
 **/
public class PasswordUtils {
    public static String hashpw(String pwd){
        return BCrypt.hashpw(pwd,BCrypt.gensalt());
    }

    public void check(){
//        BCrypt.checkpw()
    }




    public static void main(String[] args) {
        String s = hashpw("123456");
        System.out.println(s);
        System.out.println(BCrypt.checkpw("123456","$2a$10$Eq1pHV1JmeAITZPqtguWMOfnE8h.b7cJDLfiNGNPmUOPnUm7zYqsm"));
    }
}
