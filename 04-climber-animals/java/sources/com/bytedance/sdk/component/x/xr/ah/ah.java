package com.bytedance.sdk.component.x.xr.ah;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.x.ms.d;
import com.bytedance.sdk.component.x.ms.ka;

/* JADX INFO: loaded from: classes2.dex */
public class ah {
    private static boolean ms(String str) {
        d dVarD;
        ka kaVarAh = ah(str);
        if (kaVarAh == null || (dVarD = kaVarAh.d()) == null) {
            return false;
        }
        return dVarD.ah();
    }

    private static String xr(String str) {
        d dVarD;
        ka kaVarAh = ah(str);
        if (kaVarAh == null || (dVarD = kaVarAh.d()) == null) {
            return null;
        }
        return dVarD.d();
    }

    private static ka ah(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.bytedance.sdk.component.x.xr.ms.ka(str);
    }

    public static void ms(String str, ka kaVar) {
        if (kaVar == null) {
            return;
        }
        ms(null, str, kaVar.ka(), 4);
    }

    public static void xr(String str, ka kaVar) {
        if (kaVar == null) {
            return;
        }
        ms(null, str, kaVar.ka(), 5);
    }

    public static void ah(String str, ka kaVar) {
        if (kaVar == null) {
            return;
        }
        ms(null, str, kaVar.ka(), 6);
    }

    public static void d(String str, ka kaVar) {
        if (kaVar == null) {
            return;
        }
        ms(null, str, kaVar.ka(), 100);
    }

    public static void ms(String str, String str2, ka kaVar) {
        if (kaVar == null) {
            return;
        }
        ms(str, str2, kaVar.ka(), 4);
    }

    public static void xr(String str, String str2, ka kaVar) {
        if (kaVar == null) {
            return;
        }
        ms(str, str2, kaVar.ka(), 5);
    }

    public static void ah(String str, String str2, ka kaVar) {
        if (kaVar == null) {
            return;
        }
        ms(str, str2, kaVar.ka(), 6);
    }

    public static void ms(String str, String str2, String str3) {
        ms(str, str2, str3, 4);
    }

    private static void ms(String str, String str2, String str3, int i) {
        try {
            if (ms(str3) || i == 100) {
                String strXr = xr(str3);
                if (strXr == null) {
                    strXr = "";
                }
                String str4 = strXr + "log";
                if (!TextUtils.isEmpty(str)) {
                    str4 = str4 + str;
                }
                if (i == 4) {
                    sl.ms(str4, str2);
                    return;
                }
                if (i == 5) {
                    sl.xr(str4, str2);
                } else if (i == 6 || i == 100) {
                    sl.d(str4, str2);
                }
            }
        } catch (Exception e) {
            sl.ms(e);
        }
    }
}
