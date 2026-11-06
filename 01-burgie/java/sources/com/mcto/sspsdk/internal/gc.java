package com.mcto.sspsdk.internal;

import android.text.TextUtils;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class gc extends q4 {
    @Override // com.mcto.sspsdk.internal.q4
    public final String a() {
        String str;
        if (!TextUtils.isEmpty(this.a)) {
            str = this.a;
        } else if (lj.b(h4.d)) {
            str = "https://t7z.cupid.iqiyi.com/dsp_track3";
            h4.d = "https://t7z.cupid.iqiyi.com/dsp_track3";
        } else {
            str = h4.d;
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
    public final HashMap c(int i, p pVar) {
        HashMap mapA = a(i);
        if (mapA == null || mapA.isEmpty()) {
            return null;
        }
        mapA.put(an.av, ak.b(i));
        return mapA;
    }

    @Override // com.mcto.sspsdk.internal.q4
    public final String a(String str) {
        return bk.c(str);
    }
}
