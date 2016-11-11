package unifor.dssdk.utils;

public class InetUtils {

    public static int getPortFromAddr(String addr) {
        return Integer.parseInt(addr.split(":")[1]);
    }

    public static String getHostnameFromAddr(String addr) {
        return addr.split(":")[0];
    }

}
