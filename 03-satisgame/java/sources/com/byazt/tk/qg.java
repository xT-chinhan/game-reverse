package com.byazt.tk;

import android.content.Context;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 350, 26})
public final class qg {
    public static HashMap<String, ArrayList<String>> n = new HashMap<>();

    public static ArrayList<String> n(Context context, String str) {
        ArrayList<String> arrayList = null;
        if (context != null && str != null) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                return null;
            }
            if (n.get(str) != null) {
                return n.get(str);
            }
            arrayList = new ArrayList<>();
            try {
                for (Signature signature : qg(context, packageName)) {
                    String strN = "error!";
                    if (com.anythink.core.common.u.n.a.equals(str)) {
                        strN = n(signature, com.anythink.core.common.u.n.a);
                    } else if ("SHA1".equals(str)) {
                        strN = n(signature, "SHA1");
                    } else if ("SHA256".equals(str)) {
                        strN = n(signature, "SHA256");
                    }
                    arrayList.add(strN);
                }
            } catch (Exception e) {
                k.n(e.toString());
            }
            n.put(str, arrayList);
        }
        return arrayList;
    }

    public static String n(Context context) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayListN = n(context, "SHA1");
        if (arrayListN != null && arrayListN.size() != 0) {
            for (int i = 0; i < arrayListN.size(); i++) {
                sb.append(arrayListN.get(i));
                if (i < arrayListN.size() - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    private static Signature[] qg(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception e) {
            k.n(e.toString());
            return null;
        }
    }

    private static String n(Signature signature, String str) {
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
            k.n(e.toString());
            return "error!";
        }
    }
}
