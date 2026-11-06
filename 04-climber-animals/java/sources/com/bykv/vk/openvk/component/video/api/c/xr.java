package com.bykv.vk.openvk.component.video.api.c;

import android.text.TextUtils;
import com.umeng.analytics.pro.ek;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final MessageDigest f21ms = ms();
    private static final char[] xr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private xr() {
    }

    private static MessageDigest ms() {
        try {
            return MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String ms(String str) {
        byte[] bArrDigest;
        MessageDigest messageDigest = f21ms;
        if (messageDigest == null || TextUtils.isEmpty(str)) {
            return "";
        }
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        synchronized (xr.class) {
            bArrDigest = messageDigest.digest(bytes);
        }
        return ms(bArrDigest);
    }

    public static String ms(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length << 1];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = xr;
            cArr[i] = cArr2[(b & 240) >> 4];
            i = i2 + 1;
            cArr[i2] = cArr2[b & ek.m];
        }
        return new String(cArr);
    }
}
