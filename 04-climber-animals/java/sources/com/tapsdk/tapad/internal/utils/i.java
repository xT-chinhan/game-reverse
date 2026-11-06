package com.tapsdk.tapad.internal.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public class i {
    public static final String a = "MD5";
    public static final String b = "SHA1";
    public static final String c = "SHA256";
    private static volatile boolean d = false;
    private static String e = "";

    public static synchronized String a(Context context) {
        try {
            if (d) {
                String str = e;
                d = true;
                return str;
            }
            ArrayList<String> arrayListA = a(context, b);
            if (arrayListA == null || arrayListA.isEmpty()) {
                d = true;
                return "";
            }
            e = arrayListA.get(0);
            String str2 = arrayListA.get(0);
            d = true;
            return str2;
        } catch (Throwable th) {
            d = true;
            throw th;
        }
    }

    private static synchronized String a(Signature signature, String str) {
        String strSubstring;
        strSubstring = "error!";
        try {
            byte[] bArrDigest = MessageDigest.getInstance(str).digest(signature.toByteArray());
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                sb.append(Integer.toHexString((b2 & UByte.MAX_VALUE) | 256).substring(1, 3).toUpperCase());
                sb.append(":");
            }
            strSubstring = sb.substring(0, sb.length() - 1);
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
        return strSubstring;
    }

    private static synchronized ArrayList<String> a(Context context, String str) {
        String str2;
        if (context == null || str == null) {
            return null;
        }
        String packageName = context.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Signature[] signatureArrB = b(context, packageName);
        if (signatureArrB != null) {
            for (Signature signature : signatureArrB) {
                String strA = "error!";
                if ("MD5".equals(str)) {
                    str2 = "MD5";
                } else if (b.equals(str)) {
                    str2 = b;
                } else {
                    if (c.equals(str)) {
                        str2 = c;
                    }
                    arrayList.add(strA);
                }
                strA = a(signature, str2);
                arrayList.add(strA);
            }
        }
        return arrayList;
    }

    private static synchronized Signature[] b(Context context, String str) {
        try {
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
        return context.getPackageManager().getPackageInfo(str, 64).signatures;
    }
}
