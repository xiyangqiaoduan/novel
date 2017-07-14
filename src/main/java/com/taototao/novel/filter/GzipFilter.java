package com.taototao.novel.filter;

import com.taototao.novel.constant.TaoToTaoConfig;
import com.taototao.novel.constant.TaoToTaoConstants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 
 * <p>
 * Gzip过滤器
 * </p>
 */
public class GzipFilter implements Filter {
    /**
     * 过滤器配置
     */
    private FilterConfig filterConfig = null;

    /**
     * 构造方法
     * 
     * @return 过滤器配置
     */
    protected final FilterConfig getFilterConfig() {
        return this.filterConfig;
    }

    /**
     * {@inheritDoc}
     * 
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    public void init(final FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    /**
     * {@inheritDoc}
     *
     * @see javax.servlet.Filter#destroy()
     */
    public void destroy() {
        this.filterConfig = null;
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
            ServletException {

        if (!TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.GZIP_EFFECTIVE, false)) {
            chain.doFilter(req, res);
        } else {
            if (req instanceof HttpServletRequest) {
                if (!((HttpServletRequest) req).getRequestURI().startsWith("/download")) {
                    // download以外的请求做Gzip处理
                    HttpServletRequest request = (HttpServletRequest) req;
                    HttpServletResponse response = (HttpServletResponse) res;
                    String ae = request.getHeader("accept-encoding");
                    if (ae != null && ae.indexOf("gzip") != -1) {
                        GZIPResponseWrapper wrappedResponse = new GZIPResponseWrapper(response);
                        chain.doFilter(req, wrappedResponse);
                        wrappedResponse.finishResponse();
                        return;
                    }
                }
            }
            chain.doFilter(req, res);
        }
    }
}
