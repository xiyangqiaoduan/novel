package com.taototao.novel.filter;

import com.taototao.novel.constant.TaoToTaoConfig;
import com.taototao.novel.constant.TaoToTaoConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 
 * <p>
 * 屏蔽掉访问模版文件
 * </p>
 */
public class ForbidFilter implements Filter {

    /**
     * logger
     */
    private static Log logger = LogFactory.getLog(ForbidFilter.class);


    public void destroy() {
        // TODO Auto-generated method stub
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String uri = httpRequest.getRequestURI().toString();

        List<Object> forbidFiles = TaoToTaoConstants.taoToTaoConf.getList(TaoToTaoConfig.FORBID_FILES);
        for (Object object : forbidFiles) {
            if (StringUtils.endsWith(uri, (String) object) && !StringUtils.endsWith(uri, "robots.txt")) {
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                // 模拟不存在 返回404
                httpResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
                logger.warn("the template file was been request :" + uri);
                return;
            }
        }
        chain.doFilter(request, response);
    }

    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
    }

}
