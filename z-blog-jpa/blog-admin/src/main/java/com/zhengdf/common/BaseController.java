package com.zhengdf.common;

import com.zhengdf.common.constant.Const;
import com.zhengdf.util.TokenUtil;
import org.springframework.http.HttpRequest;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName BaseController
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/6/25 1:45
 * @Version 1.0
 **/
public class BaseController {

    public String getUserName(HttpServletRequest request){
        String token = resolveToken(request);
        return TokenUtil.getUsername(token);
    }


    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(Const.JWT_HEADER);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(Const.JWT_TOKEN_START)) {
            // 去掉令牌前缀
            return bearerToken.replace(Const.JWT_TOKEN_START,"");
        }
        return null;
    }
}
