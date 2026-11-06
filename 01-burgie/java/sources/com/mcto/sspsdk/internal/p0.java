package com.mcto.sspsdk.internal;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class p0 extends q4 {
    @Override // com.mcto.sspsdk.internal.q4
    public final String a() {
        String str;
        if (!TextUtils.isEmpty(this.a)) {
            str = this.a;
        } else if (lj.b(h4.c)) {
            str = "https://t7z.cupid.iqiyi.com/etx";
            h4.c = "https://t7z.cupid.iqiyi.com/etx";
        } else {
            str = h4.c;
        }
        return !str.contains("?") ? str.concat("?") : str;
    }

    @Override // com.mcto.sspsdk.internal.q4, com.mcto.sspsdk.internal.s7
    public final ArrayList b(int i, p pVar) {
        HashMap mapC = c(i, pVar);
        if (mapC == null || mapC.isEmpty()) {
            return null;
        }
        return a(i, pVar, mapC);
    }

    @Override // com.mcto.sspsdk.internal.q4
    public final String a(String str) {
        return bk.a(str);
    }
}
