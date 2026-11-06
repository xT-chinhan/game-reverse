package com.byazt.nn;

import android.content.Context;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 938, 37})
public final class pr {
    public static HashMap<String, ArrayList<String>> pr = new HashMap<>();

    public static String pr(Context context) {
        ArrayList<String> arrayListPr = pr(context, "MD5");
        if (arrayListPr != null && !arrayListPr.isEmpty()) {
            return arrayListPr.get(0);
        }
        return null;
    }

    public static ArrayList<String> pr(Context context, String str) {
        String packageName;
        if (context == null || str == null || (packageName = context.getPackageName()) == null) {
            return null;
        }
        if (pr.get(str) != null) {
            return pr.get(str);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            for (Signature signature : hw(context, packageName)) {
                String strPr = "error!";
                if ("MD5".equals(str)) {
                    strPr = pr(signature, "MD5");
                } else if ("SHA1".equals(str)) {
                    strPr = pr(signature, "SHA1");
                } else if ("SHA256".equals(str)) {
                    strPr = pr(signature, "SHA256");
                }
                arrayList.add(strPr);
            }
        } catch (Exception e) {
            fw.x(e.toString());
        }
        pr.put(str, arrayList);
        return arrayList;
    }

    private static Signature[] hw(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception e) {
            fw.x(e.toString());
            return null;
        }
    }

    private static String pr(Signature signature, String str) {
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
            fw.x(e.toString());
            return "error!";
        }
    }
}
