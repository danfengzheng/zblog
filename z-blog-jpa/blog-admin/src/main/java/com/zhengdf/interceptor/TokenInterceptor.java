package com.zhengdf.interceptor;

import com.zhengdf.common.constant.Const;
import com.zhengdf.common.enums.ErrorEnum;
import com.zhengdf.common.exception.GlobalException;
import com.zhengdf.util.TokenUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getMethod().equals("OPTIONS")) {
            return true;
        }
        String token = resolveToken(request);
        if (StringUtils.hasText(token) && TokenUtil.verify(token)) {
            return true;
        } else {
            throw new GlobalException(ErrorEnum.TOKEN_EXPIRES);
        }
//            JSONObject json = new JSONObject();
//            json.put("success","false");
//            json.put("msg","认证失败，未通过拦截器");
//            json.put("code","50000");
//            response.getWriter().append(json.toJSONString());
//            System.out.println("认证失败，未通过拦截器");
        //        response.getWriter().write("50000");
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
