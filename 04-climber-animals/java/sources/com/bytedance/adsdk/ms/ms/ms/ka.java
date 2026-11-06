package com.bytedance.adsdk.ms.ms.ms;

import android.text.TextUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class ka {
    int ab;
    int c;
    int d;
    int ka;

    void ms(com.bytedance.adsdk.ms.ms.xr.ms msVar) throws IOException {
    }

    ka() {
    }

    static int ms(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return -1159790593;
        }
        return ((str.charAt(3) & 255) << 24) | (str.charAt(0) & 255) | ((str.charAt(1) & 255) << 8) | ((str.charAt(2) & 255) << 16);
    }

    void xr(com.bytedance.adsdk.ms.ms.xr.ms msVar) throws IOException {
        int iD = msVar.d();
        ms(msVar);
        int iD2 = iD - msVar.d();
        int i = this.d;
        if (iD2 > i) {
            throw new IOException("Out of chunk area");
        }
        if (iD2 < i) {
            msVar.ms(i - iD2);
        }
    }
}
