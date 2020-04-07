package cn.kj.ebff.utils;

import java.security.MessageDigest;

/**
 * Created with IntelliJ IDEA.
 * Package: cn.kj.ebff.utils
 * User: 25414
 * Date: 2020/4/4
 * Time: 16:06
 * Description:
 */
public class MD5Utils {
    public static String encode(String string) throws Exception {
        byte[] hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) {
                hex.append("0");
            }
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }
}
