package com.idea.common.util;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;

public class CommonUtil {
    /**
     * 判断是否为空
     *
     * @param obj
     * @return
     */
    public static Boolean isObjectEmpty(Object obj) {
        if (obj == null || "".equals(obj)) {
            return true;
        }
        return false;
    }

    /**
     * 得到客户端请求IP地址
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        try {
            String ip = request.getHeader("x-forwarded-for");
            if (ip == null || ip.length() == 0
                    || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0
                    || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0
                    || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
                if (ip.equals("127.0.0.1")) {
                    // 根据网卡取本机配置的IP
                    InetAddress inet = InetAddress.getLocalHost();
                    ip = inet.getHostAddress();

                    // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
                    if (ip != null && ip.length() > 15) { // "***.***.***.***".length()
                        // = 15
                        if (ip.indexOf(",") > 0) {
                            ip = ip.substring(0, ip.indexOf(","));
                        }
                    }
                }
            }
            if (ip != null && ip.length() > 15) { // "***.***.***.***".length()
                // = 15
                if (ip.indexOf(",") > 0) {
                    ip = ip.substring(0, ip.indexOf(","));
                }
            }
            return ip;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
