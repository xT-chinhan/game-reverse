package com.byazt.vy;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1431, 793})
public class hu {
    public static String n = null;
    public static String q = "ToolUtils";
    public static String qg;
    public static String s;

    public static synchronized String n() {
        if (TextUtils.isEmpty(n) && com.byazt.qt.qg.getContext() != null) {
            try {
                n = com.byazt.qt.qg.getContext().getPackageName();
            } catch (Throwable th) {
                com.byazt.rb.qg.q(q, "ToolUtils getPackageName throws exception :" + th);
            }
        }
        return n;
    }

    public static synchronized String qg() {
        if (TextUtils.isEmpty(qg) && com.byazt.qt.qg.getContext() != null) {
            try {
                PackageInfo packageInfo = com.byazt.qt.qg.getContext().getPackageManager().getPackageInfo(n(), 0);
                qg = String.valueOf(packageInfo.versionCode);
                s = packageInfo.versionName;
            } catch (Throwable th) {
                com.byazt.rb.qg.q(q, "ToolUtils getVersionCode throws exception :" + th);
            }
        }
        return qg;
    }

    public static synchronized String s() {
        if (TextUtils.isEmpty(s) && com.byazt.qt.qg.getContext() != null) {
            try {
                PackageInfo packageInfo = com.byazt.qt.qg.getContext().getPackageManager().getPackageInfo(n(), 0);
                qg = String.valueOf(packageInfo.versionCode);
                s = packageInfo.versionName;
            } catch (Throwable th) {
                com.byazt.rb.qg.q(q, "ToolUtils getVersionName throws exception :" + th);
            }
        }
        return s;
    }

    public static String q() {
        String strConcat;
        try {
            strConcat = System.getProperty("http.agent");
        } catch (Exception unused) {
            strConcat = "unKnow";
        }
        StringBuilder sb = new StringBuilder();
        if (strConcat == null) {
            return "";
        }
        int iLastIndexOf = strConcat.lastIndexOf(";");
        if (iLastIndexOf != -1 && strConcat.length() > iLastIndexOf) {
            int i = iLastIndexOf + 1;
            strConcat = strConcat.substring(0, i).concat(" " + Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry() + ";").concat(strConcat.substring(i));
        }
        int length = strConcat.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = strConcat.charAt(i2);
            if (cCharAt <= 31 || cCharAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static String n(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 17) {
            return str;
        }
        return n.qg(str.substring(17), s(str.substring(1, 17)));
    }

    private static String s(String str) {
        String strN = n.n(str);
        if (str != null) {
            return strN;
        }
        String strN2 = qg.n();
        return strN2.concat(strN2).substring(8, 24);
    }

    public static String l() {
        try {
            byte[] bArr = new byte[8];
            new SecureRandom().nextBytes(bArr);
            return w.n(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean n(com.byazt.qk.oa oaVar) {
        if (oaVar == null) {
            return false;
        }
        if (com.byazt.nx.n.n(oaVar.s())) {
            return true;
        }
        String strFs = oaVar.fs();
        if (!TextUtils.isEmpty(strFs)) {
            String strTrim = strFs.trim();
            if (!TextUtils.isEmpty(strTrim) && !strTrim.startsWith("{") && !strTrim.endsWith("}")) {
                return true;
            }
        }
        return false;
    }

    public static String n(byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    JSONObject jSONObject = new JSONObject();
                    com.byazt.vf.k kVarS = com.byazt.cl.s.s();
                    if (kVarS == null) {
                        jSONObject.putOpt("case", "1");
                        com.byazt.eji.s.n().n("gm4decErr", jSONObject, (Throwable) null);
                        return null;
                    }
                    byte[] bArrQg = kVarS.qg(bArr);
                    if (bArrQg == null) {
                        jSONObject.putOpt("case", "2");
                        com.byazt.eji.s.n().n("gm4decErr", jSONObject, (Throwable) null);
                        return null;
                    }
                    if (bArrQg.length <= 0) {
                        jSONObject.putOpt("case", "3");
                        com.byazt.eji.s.n().n("gm4decErr", jSONObject, (Throwable) null);
                        return null;
                    }
                    String strQg = com.byazt.xu.q.qg(bArrQg);
                    if (!TextUtils.isEmpty(strQg)) {
                        return strQg;
                    }
                    jSONObject.putOpt("case", "4");
                    com.byazt.eji.s.n().n("gm4decErr", jSONObject, (Throwable) null);
                    return null;
                }
            } catch (Exception e) {
                com.byazt.eji.s.n().n("gm4decErr", e);
            }
        }
        return null;
    }

    public static byte[] qg(String str) {
        com.byazt.vf.k kVarS = com.byazt.cl.s.s();
        if (kVarS == null) {
            return null;
        }
        return kVarS.n(q(str));
    }

    private static byte[] q(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(!TextUtils.isEmpty(str) ? Math.min(str.length(), 1024) : 32);
        GZIPOutputStream gZIPOutputStream = null;
        try {
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(str.getBytes());
                    gZIPOutputStream2.close();
                } catch (Exception unused) {
                    gZIPOutputStream = gZIPOutputStream2;
                    if (gZIPOutputStream != null) {
                        gZIPOutputStream.close();
                    }
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused3) {
            }
        } catch (Exception unused4) {
        } catch (Throwable th2) {
            th = th2;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static JSONObject n(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                String strN = n.n();
                String str = "2" + strN + n.n(jSONObject.toString(), n.n(strN));
                if (!TextUtils.isEmpty(str)) {
                    jSONObject2.put("message", str);
                    jSONObject2.put("cypher", 2);
                } else {
                    jSONObject2.put("message", jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            jSONObject2.put("message", jSONObject.toString());
            jSONObject2.put("cypher", 0);
        }
        return jSONObject2;
    }

    public static void n(String str, Object obj, boolean z) {
        if (com.byazt.vyf.s.cy().sh()) {
            com.byazt.iav.qg.n().n(str, obj, z);
        }
    }
}
