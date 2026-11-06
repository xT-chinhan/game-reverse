package com.bytedance.sdk.openadsdk.core.p;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public class ah {
    public static String ms(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return hi.ms(messageDigest.digest());
        } catch (Exception unused) {
            return "";
        }
    }
}
