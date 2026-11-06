package com.taptap.sdk.kit.internal.utils;

import android.os.LocaleList;
import com.anythink.core.common.u.n;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class CommonUtils {
    public static String getMD5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(n.a);
            messageDigest.update(bArr);
            return getHashString(messageDigest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String getHashString(MessageDigest messageDigest) {
        StringBuilder sb = new StringBuilder();
        for (byte b : messageDigest.digest()) {
            sb.append(Integer.toHexString((b >> 4) & 15));
            sb.append(Integer.toHexString(b & 15));
        }
        return sb.toString();
    }

    public static Locale getCurrentLocale() {
        return LocaleList.getDefault().get(0);
    }
}
