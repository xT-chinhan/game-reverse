package com.byazt.qyu;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1178, 18})
public class l {
    public static StringBuffer n = new StringBuffer();

    public static void n(String str, String str2) {
        StringBuffer stringBuffer = n;
        if (stringBuffer == null || str2 == null) {
            return;
        }
        try {
            if (stringBuffer.length() > 204800) {
                return;
            }
            n.append(System.currentTimeMillis()).append(';').append(str).append(';').append(str2).append('\n');
        } catch (Exception unused) {
        }
    }

    public static void n() {
        n = null;
    }

    public static String qg() {
        StringBuffer stringBuffer = n;
        String string = stringBuffer != null ? stringBuffer.toString() : "";
        n = null;
        return string;
    }
}
