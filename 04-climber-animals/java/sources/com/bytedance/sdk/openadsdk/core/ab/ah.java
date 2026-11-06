package com.bytedance.sdk.openadsdk.core.ab;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.jw;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static com.byted.ms.ms.ms.ms f1889ms;

    private static com.byted.ms.ms.ms.ms d() {
        if (f1889ms == null) {
            f1889ms = jw.ms().ka();
        }
        return f1889ms;
    }

    public static void ms(xr xrVar) {
        if (d() == null) {
            return;
        }
        ms.ms(xrVar);
    }

    public static void ms() {
        com.byted.ms.ms.ms.ms msVarD = d();
        if (msVarD == null) {
            return;
        }
        msVarD.ms();
    }

    public static void ms(int i) {
        com.byted.ms.ms.ms.ms msVarD = d();
        if (msVarD == null) {
            return;
        }
        msVarD.ms(i);
    }

    public static void ms(String str, String str2) {
        com.byted.ms.ms.ms.ms msVarD = d();
        if (msVarD == null) {
            return;
        }
        msVarD.xr(str, str2);
    }

    public static void xr(String str, String str2) {
        com.byted.ms.ms.ms.ms msVarD = d();
        if (msVarD == null) {
            return;
        }
        msVarD.ah(str, str2);
    }

    public static void ah(String str, String str2) {
        com.byted.ms.ms.ms.ms msVarD = d();
        if (msVarD == null) {
            return;
        }
        msVarD.d(str, str2);
    }

    public static void ms(String str, String str2, Throwable th) {
        com.byted.ms.ms.ms.ms msVarD = d();
        if (msVarD == null) {
            return;
        }
        msVarD.ms(str, str2, th);
    }

    public static void d(String str, String str2) {
        com.byted.ms.ms.ms.ms msVarD = d();
        if (msVarD == null) {
            return;
        }
        msVarD.ka(str, str2);
    }

    public static void xr(String str, String str2, Throwable th) {
        com.byted.ms.ms.ms.ms msVarD = d();
        if (msVarD == null) {
            return;
        }
        msVarD.xr(str, str2, th);
    }

    public static void ms(String str, Throwable th) {
        com.byted.ms.ms.ms.ms msVarD = d();
        if (msVarD == null) {
            return;
        }
        msVarD.xr(str, th);
    }

    public static void xr() {
        com.byted.ms.ms.ms.ms msVarD = d();
        if (msVarD == null) {
            return;
        }
        msVarD.ah();
    }

    public static boolean ms(Context context, JSONObject jSONObject) {
        com.byted.ms.ms.ms.ms msVarD = d();
        if (msVarD == null) {
            return false;
        }
        msVarD.ms(context, jSONObject);
        return true;
    }

    public static void ms(Context context, String str, String str2) {
        com.byted.ms.ms.ms.ms msVarD = d();
        if (msVarD == null) {
            return;
        }
        msVarD.ms(context, str, str2);
    }

    public static void ms(String str) {
        com.byted.ms.ms.ms.ms msVarD = d();
        if (msVarD == null) {
            return;
        }
        msVarD.ms(str);
    }

    public static void ah() {
        com.byted.ms.ms.ms.ms msVarD = d();
        if (msVarD == null) {
            return;
        }
        msVarD.xr();
    }
}
