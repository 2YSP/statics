package cn.sp.stati;

import java.util.List;

/**
 * Created by 2YSP on 2017/10/23.
 */
public class ConstantCacheCenter {
    private static volatile ConstantCacheCenter constantCacheCenter;
    private String username = "XXXX@qq.com";
    private String authorizationCode = "pfkantwjshgghiab";
    private String senderEmail = "XXXX@qq.com";
    private String senderName = "ship";
    private String host = "smtp.qq.com";
    private String port = "465";
    private String protocol="smtp";
    private List<String> receivers;

    private ConstantCacheCenter() {
    }

    public static ConstantCacheCenter getInstance() {
        if (null == constantCacheCenter) {
            synchronized (ConstantCacheCenter.class) {
                if (null == constantCacheCenter) {
                    constantCacheCenter = new ConstantCacheCenter();
                }
            }
        }
        return constantCacheCenter;
    }

    public String getUsername() {
        return username;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getProtocol() {
        return protocol;
    }

    public List<String> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<String> receivers) {
        this.receivers = receivers;
    }
}
