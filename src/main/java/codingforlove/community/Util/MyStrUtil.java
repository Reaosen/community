package codingforlove.community.Util;

import java.io.UnsupportedEncodingException;

public class MyStrUtil {

    public static String taken(String str, int n) {
        if (str == null) {
            return null; // 如果输入字符串为null，直接返回null
        }
        if (n <= 0) {
            return ""; // 如果n小于等于0，返回空字符串
        }
        // 使用内置的substring方法截取前n个字符
        return str.length() > n ? str.substring(0, n) : str;
    }
}
