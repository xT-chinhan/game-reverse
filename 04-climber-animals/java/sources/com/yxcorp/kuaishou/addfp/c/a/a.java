package com.yxcorp.kuaishou.addfp.c.a;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.kuaishou.weapon.p0.g;
import com.ss.android.download.api.constant.BaseConstants;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import com.yxcorp.kuaishou.addfp.android.a.d;
import com.yxcorp.kuaishou.addfp.android.b.f;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    /* JADX WARN: Code duplicated, block: B:13:0x0034  */
    /* JADX WARN: Code duplicated, block: B:39:0x008b  */
    /* JADX WARN: Code duplicated, block: B:59:0x00d0  */
    public static String a() {
        boolean z;
        boolean z2;
        boolean z3;
        String str = Build.MANUFACTURER;
        if (str.equalsIgnoreCase("XIAOMI")) {
            z = true;
        } else {
            String str2 = Build.BRAND;
            if (str2.equalsIgnoreCase("XIAOMI") || str2.equalsIgnoreCase("REDMI") || str2.equalsIgnoreCase("MEITU") || !TextUtils.isEmpty(a("ro.miui.ui.version.name", ""))) {
                z = true;
            } else {
                z = false;
            }
        }
        if (!z) {
            if (!(str.equalsIgnoreCase("BLACKSHARK") || Build.BRAND.equalsIgnoreCase("BLACKSHARK"))) {
                if (str.equalsIgnoreCase("SAMSUNG") || Build.BRAND.equalsIgnoreCase("SAMSUNG")) {
                    return "3";
                }
                if (str.equalsIgnoreCase("VIVO")) {
                    z2 = true;
                } else {
                    String str3 = Build.BRAND;
                    if (str3.equalsIgnoreCase("VIVO") || str3.equalsIgnoreCase("IQOO") || !TextUtils.isEmpty(a("ro.vivo.os.version", ""))) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                }
                if (z2) {
                    return "2";
                }
                if (str.equalsIgnoreCase("HUAWEI") || Build.BRAND.equalsIgnoreCase("HUAWEI")) {
                    return "1";
                }
                if (str.equalsIgnoreCase(BaseConstants.ROM_OPPO_UPPER_CONSTANT)) {
                    z3 = true;
                } else {
                    String str4 = Build.BRAND;
                    if (str4.equalsIgnoreCase(BaseConstants.ROM_OPPO_UPPER_CONSTANT) || str4.equalsIgnoreCase("REALME") || !TextUtils.isEmpty(a("ro.build.version.opporom", ""))) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                }
                if (!z3) {
                    if (!(str.equalsIgnoreCase("ONEPLUS") || Build.BRAND.equalsIgnoreCase("ONEPLUS"))) {
                        return Build.BRAND.equalsIgnoreCase("HONOR") ? "7" : "0";
                    }
                }
                return "5";
            }
        }
        return "4";
    }

    public static String a(int i, String str) {
        String strA;
        Context paramContext = KWEGIDDFP.instance().getParamContext();
        if (paramContext == null) {
            return "";
        }
        String[] strArrSplit = new String(Base64.decode("U3lzdGVtQFNlY3VyZUBHbG9iYWw=", 0)).split("@");
        String str2 = strArrSplit[0];
        String str3 = strArrSplit[1];
        String str4 = strArrSplit[2];
        if (i == 0) {
            strA = com.yxcorp.kuaishou.addfp.android.b.a.a(paramContext, str2, str);
            if (TextUtils.isEmpty(strA)) {
                strA = Settings.System.getString(paramContext.getContentResolver(), str);
            }
        } else if (i == 1) {
            strA = com.yxcorp.kuaishou.addfp.android.b.a.a(paramContext, str3, str);
            if (TextUtils.isEmpty(strA)) {
                strA = Settings.Secure.getString(paramContext.getContentResolver(), str);
            }
        } else if (i == 2) {
            strA = com.yxcorp.kuaishou.addfp.android.b.a.a(paramContext, str4, str);
            if (TextUtils.isEmpty(strA)) {
                strA = Settings.Global.getString(paramContext.getContentResolver(), str);
            }
        } else {
            strA = "";
        }
        return strA == null ? "" : strA;
    }

    public static String a(Context context, String str) {
        try {
            return Settings.System.getString(context.getContentResolver(), str);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String a(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception unused) {
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0086 A[Catch: all -> 0x00dc, TryCatch #1 {all -> 0x00dc, blocks: (B:3:0x0002, B:6:0x0016, B:8:0x0020, B:10:0x002a, B:23:0x0069, B:25:0x006f, B:28:0x0076, B:30:0x0080, B:34:0x0090, B:36:0x0096, B:37:0x00ad, B:45:0x00cf, B:47:0x00d5, B:32:0x0086, B:15:0x0043, B:17:0x004d, B:19:0x0057, B:21:0x0065), top: B:57:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00bf A[Catch: all -> 0x00ad, TRY_LEAVE, TryCatch #2 {all -> 0x00ad, blocks: (B:41:0x00b7, B:43:0x00bf), top: B:59:0x00b7 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00d5 A[Catch: all -> 0x00dc, TRY_LEAVE, TryCatch #1 {all -> 0x00dc, blocks: (B:3:0x0002, B:6:0x0016, B:8:0x0020, B:10:0x002a, B:23:0x0069, B:25:0x006f, B:28:0x0076, B:30:0x0080, B:34:0x0090, B:36:0x0096, B:37:0x00ad, B:45:0x00cf, B:47:0x00d5, B:32:0x0086, B:15:0x0043, B:17:0x004d, B:19:0x0057, B:21:0x0065), top: B:57:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x00cc A[SYNTHETIC] */
    public static String a(Context context) {
        String str;
        LinkedHashMap linkedHashMapB;
        ListIterator listIterator;
        JSONObject jSONObject;
        int i;
        Map.Entry entry;
        try {
            String strA = a(context, "k_w_o_d_out_dtt");
            String strA2 = "";
            if (TextUtils.isEmpty(strA)) {
                if (!d.a(context).b()) {
                    if (f.a(context, new String[]{g.i, "android.permission.WRITE_EXTERNAL_STORAGE"})) {
                        strA2 = d.a(context).a("Lm91a2R0ZnQ=");
                        if (!TextUtils.isEmpty(strA2)) {
                            try {
                                Settings.System.putString(context.getContentResolver(), "k_w_o_d_out_dtt", strA2);
                            } catch (Throwable unused) {
                            }
                        }
                    } else {
                        str = "KWE_PN";
                    }
                }
                if (!TextUtils.isEmpty(strA) && TextUtils.isEmpty(strA2)) {
                    return "KWE_N";
                }
                linkedHashMapB = d.a(context).b(strA);
                if (linkedHashMapB != null || linkedHashMapB.size() == 0) {
                    linkedHashMapB = d.a(context).b(strA2);
                }
                if (linkedHashMapB != null && linkedHashMapB.size() > 0) {
                    listIterator = new ArrayList(linkedHashMapB.entrySet()).listIterator(linkedHashMapB.size());
                    jSONObject = new JSONObject();
                    i = 0;
                    while (listIterator.hasPrevious() && i < 10) {
                        try {
                            entry = (Map.Entry) listIterator.previous();
                            if (entry != null) {
                                jSONObject.put((String) entry.getKey(), entry.getValue());
                            }
                            i++;
                        } catch (Throwable unused2) {
                        }
                    }
                    if (jSONObject.length() > 0) {
                        return jSONObject.toString();
                    }
                }
                return str;
            }
            if (!d.a(context).b() && f.a(context, new String[]{g.i, "android.permission.WRITE_EXTERNAL_STORAGE"})) {
                strA2 = d.a(context).a("Lm91a2R0ZnQ=");
                if (TextUtils.isEmpty(strA2)) {
                    d.a(context, strA);
                }
            }
            str = "KWE_N";
            if (!TextUtils.isEmpty(strA)) {
            }
            linkedHashMapB = d.a(context).b(strA);
            if (linkedHashMapB != null) {
                linkedHashMapB = d.a(context).b(strA2);
            } else {
                linkedHashMapB = d.a(context).b(strA2);
            }
            if (linkedHashMapB != null) {
                listIterator = new ArrayList(linkedHashMapB.entrySet()).listIterator(linkedHashMapB.size());
                jSONObject = new JSONObject();
                i = 0;
                while (listIterator.hasPrevious()) {
                    entry = (Map.Entry) listIterator.previous();
                    if (entry != null) {
                        jSONObject.put((String) entry.getKey(), entry.getValue());
                    }
                    i++;
                }
                if (jSONObject.length() > 0) {
                    return jSONObject.toString();
                }
            }
            return str;
        } catch (Throwable th) {
            th.printStackTrace();
            return "KWE_PE";
        }
    }
}
