package com.anythink.core.common.v;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class ah {
    private static String a(String str, String str2) {
        int length = str.length();
        int length2 = str2.length();
        if (length == length2) {
            return str;
        }
        int iAbs = Math.abs(length2 - length);
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < iAbs; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public static boolean a(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean b(String str) {
        return str.matches("[\\u4e00-\\u9fa5]+");
    }

    public static String a(String str) {
        byte[] bytes = str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] - 3);
        }
        return new String(bytes);
    }
}
