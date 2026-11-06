package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static HashMap<String, ArrayList<String>> f1350ms = new HashMap<>();

    public static ArrayList<String> ms(Context context, String str) {
        ArrayList<String> arrayList = null;
        if (context != null && str != null) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                return null;
            }
            if (f1350ms.get(str) != null) {
                return f1350ms.get(str);
            }
            arrayList = new ArrayList<>();
            try {
                for (Signature signature : xr(context, packageName)) {
                    String strMs = "error!";
                    if ("MD5".equals(str)) {
                        strMs = ms(signature, "MD5");
                    } else if (com.tapsdk.tapad.internal.utils.i.b.equals(str)) {
                        strMs = ms(signature, com.tapsdk.tapad.internal.utils.i.b);
                    } else if (com.tapsdk.tapad.internal.utils.i.c.equals(str)) {
                        strMs = ms(signature, com.tapsdk.tapad.internal.utils.i.c);
                    }
                    arrayList.add(strMs);
                }
            } catch (Exception e) {
                sl.xr(e.toString());
            }
            f1350ms.put(str, arrayList);
        }
        return arrayList;
    }

    public static String ms(Context context) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayListMs = ms(context, com.tapsdk.tapad.internal.utils.i.b);
        if (arrayListMs != null && arrayListMs.size() != 0) {
            for (int i = 0; i < arrayListMs.size(); i++) {
                sb.append(arrayListMs.get(i));
                if (i < arrayListMs.size() - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    private static Signature[] xr(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception e) {
            sl.xr(e.toString());
            return null;
        }
    }

    private static String ms(Signature signature, String str) {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (messageDigest == null) {
                return "error!";
            }
            byte[] bArrDigest = messageDigest.digest(byteArray);
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(Integer.toHexString((b & UByte.MAX_VALUE) | 256).substring(1, 3).toUpperCase());
                sb.append(":");
            }
            return sb.substring(0, sb.length() - 1).toString();
        } catch (Exception e) {
            sl.xr(e.toString());
            return "error!";
        }
    }
}
