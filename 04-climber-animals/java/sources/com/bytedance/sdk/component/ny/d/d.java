package com.bytedance.sdk.component.ny.d;

import android.content.Context;
import com.bytedance.sdk.component.ny.ah.ab;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static void ms(Context context, int i, String str, int i2) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (i == 1) {
                linkedHashMap.put(ms(i2), str);
            }
            ah.xr("MultiProcessFileUtils", "saveData = ".concat(String.valueOf(str)));
            if (ab.ms().ms(i2).d() != null) {
                ab.ms().ms(i2).d().ms(context, linkedHashMap);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0029  */
    public static String ms(Context context, int i, int i2) {
        String strMs;
        if (i != 1) {
            strMs = "";
        } else {
            try {
                if (ab.ms().ms(i2).d() != null) {
                    strMs = ab.ms().ms(i2).d().ms(context, ms(i2), "");
                } else {
                    strMs = "";
                }
            } catch (Exception unused) {
            }
        }
        return strMs instanceof String ? String.valueOf(strMs) : "";
    }

    private static String ms(int i) {
        return "tnc_config".concat(String.valueOf(i));
    }
}
