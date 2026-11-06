package com.smartdigimkt.y2;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public static a a(String str, String str2) {
        if (str == null || str2 == null) {
            return a.c;
        }
        if (str.length() == 3 && a(str) && !"000".equals(str)) {
            return ((str2.length() == 2 || str2.length() == 3) && a(str2)) ? new a(str, str2) : a.c;
        }
        return a.c;
    }

    public static a b(String str) {
        if (str == null || str.isEmpty()) {
            return a.c;
        }
        for (String str2 : str.split("[,;]")) {
            String strTrim = str2.trim();
            if ((strTrim.length() == 5 || strTrim.length() == 6) && a(strTrim)) {
                a aVarA = a(strTrim.substring(0, 3), strTrim.substring(3));
                if (aVarA.a()) {
                    return aVarA;
                }
            }
        }
        return a.c;
    }

    public static boolean a(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt < '0' || cCharAt > '9') {
                return false;
            }
        }
        return true;
    }
}
