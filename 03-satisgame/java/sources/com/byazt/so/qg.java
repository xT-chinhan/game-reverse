package com.byazt.so;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 427, 26})
public class qg {
    public static String n(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(com.anythink.core.common.u.n.a);
            messageDigest.update(bArr);
            return fs.n(messageDigest.digest());
        } catch (Exception unused) {
            return "";
        }
    }
}
