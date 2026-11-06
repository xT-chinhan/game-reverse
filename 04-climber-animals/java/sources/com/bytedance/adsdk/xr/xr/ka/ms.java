package com.bytedance.adsdk.xr.xr.ka;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    public static boolean ah(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean d(char c) {
        return '+' == c || '-' == c || '*' == c || '/' == c || '%' == c || '=' == c || '>' == c || '<' == c || '!' == c || '&' == c || '|' == c || '?' == c || ':' == c;
    }

    public static boolean ms(char c) {
        return c == ' ';
    }

    public static boolean xr(char c) {
        if (c < 'A' || c > 'Z') {
            return c >= 'a' && c <= 'z';
        }
        return true;
    }
}
