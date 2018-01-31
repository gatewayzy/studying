package javaModule.request;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by dell on 2017/3/6.
 */
public class RequestUtils {

    /**
     * get IP from request
     *
     * @param request
     * @return String
     */
    public static String getIpAddr(HttpServletRequest request) {
		/* 从10.15.62.49中转; nginx 服务器 */
        String ip = request.getHeader("X-Real-IP");
        if (null != ip && !"".equals(ip))
            return ip;
        ip = request.getHeader("x-forwarded-for");
        if (ip == null || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
