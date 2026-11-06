package com.smartdigimkt.r4;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes3.dex */
public final class x {
    public final PackageManager a;

    public x(Context context) {
        this.a = context.getPackageManager();
    }

    public final String a() {
        byte[] byteArray;
        byte[] bArrDigest;
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = this.a.getPackageInfo("com.huawei.hwid", 64);
            byteArray = (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) ? new byte[0] : signatureArr[0].toByteArray();
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (byteArray == null || byteArray.length == 0) {
            return null;
        }
        try {
            bArrDigest = MessageDigest.getInstance("SHA-256").digest(byteArray);
        } catch (NoSuchAlgorithmException unused2) {
            bArrDigest = new byte[0];
        }
        char[] cArr = r.a;
        char[] cArr2 = new char[bArrDigest.length << 1];
        int i = 0;
        for (byte b : bArrDigest) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b & 240) >>> 4];
            i += 2;
            cArr2[i2] = cArr[b & 15];
        }
        return new String(cArr2);
    }
}
