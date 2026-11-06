package com.byazt.hls;

import android.content.Context;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1598, 19})
public final class n {
    public static HashMap<String, ArrayList<String>> n = new HashMap<>();

    public static String n(Context context) {
        ArrayList<String> arrayListN = n(context, com.anythink.core.common.u.n.a);
        if (arrayListN == null || arrayListN.isEmpty()) {
            return null;
        }
        return arrayListN.get(0);
    }

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
                x.q(e.toString());
            }
            n.put(str, arrayList);
        }
        return arrayList;
    }

    private static Signature[] qg(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception e) {
            x.q(e.toString());
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
            x.q(e.toString());
            return "error!";
        }
    }
}
