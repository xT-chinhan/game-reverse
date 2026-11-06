package com.byazt.tk;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 350, 8})
public final class s {
    public static String n(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        String strEncodeToString = null;
        if (bitmap == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
            } catch (Throwable unused) {
                if (byteArrayOutputStream != null) {
                }
                return strEncodeToString;
            }
        } catch (Throwable unused2) {
            byteArrayOutputStream = null;
        }
        try {
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
        } catch (Throwable unused3) {
        }
        return strEncodeToString;
    }

    public static Bitmap n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] qg(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bitmap.getByteCount());
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
