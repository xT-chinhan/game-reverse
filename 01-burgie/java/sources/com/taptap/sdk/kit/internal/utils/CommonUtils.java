package com.taptap.sdk.kit.internal.utils;

import android.os.Build;
import android.os.LocaleList;
import com.umeng.analytics.pro.cc;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class CommonUtils {
    public static String getMD5(byte[] bytes) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(bytes);
            return getHashString(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String getHashString(MessageDigest digest) {
        StringBuilder builder = new StringBuilder();
        for (byte b : digest.digest()) {
            builder.append(Integer.toHexString((b >> 4) & 15));
            builder.append(Integer.toHexString(b & cc.m));
        }
        return builder.toString();
    }

    public static Locale getCurrentLocale() {
        if (Build.VERSION.SDK_INT >= 24) {
            Locale locale = LocaleList.getDefault().get(0);
            return locale;
        }
        Locale locale2 = Locale.getDefault();
        return locale2;
    }
}
