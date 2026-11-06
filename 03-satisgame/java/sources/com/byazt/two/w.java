package com.byazt.two;

import android.content.Context;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 802, 13})
public class w {
    public com.byazt.xl.s n;

    public w(com.byazt.xl.s sVar) {
        this.n = sVar;
    }

    public void n(Context context, int i, String str, int i2) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (i == 1) {
                linkedHashMap.put(n(i2), str);
            }
            com.byazt.xl.s sVar = this.n;
            if (sVar != null) {
                sVar.n(context, linkedHashMap);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0013  */
    public String n(Context context, int i, int i2) {
        String strN;
        if (i != 1) {
            strN = "";
        } else {
            try {
                com.byazt.xl.s sVar = this.n;
                if (sVar != null) {
                    strN = sVar.n(context, n(i2), "");
                } else {
                    strN = "";
                }
            } catch (Exception unused) {
            }
        }
        return strN instanceof String ? String.valueOf(strN) : "";
    }

    private static String n(int i) {
        return "tnc_config".concat(String.valueOf(i));
    }
}
