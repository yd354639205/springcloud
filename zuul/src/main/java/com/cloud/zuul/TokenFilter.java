package com.cloud.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Component
public class TokenFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(400);
            context.setResponseBody("Token is empty");
        } else {
            context.setSendZuulResponse(true);
            context.setResponseStatusCode(200);
        }
        return null;
    }
}
