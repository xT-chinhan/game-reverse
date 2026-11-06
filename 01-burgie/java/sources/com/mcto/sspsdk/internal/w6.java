package com.mcto.sspsdk.internal;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public final class w6 implements s7 {
    public String a;
    public HashMap b;

    @Override // com.mcto.sspsdk.internal.s7
    public final List a(int i, p pVar) {
        return null;
    }

    @Override // com.mcto.sspsdk.internal.s7
    public final ArrayList b(int i, p pVar) {
        HashMap map = this.b;
        StringBuilder sb = new StringBuilder();
        String strConcat = TextUtils.isEmpty(this.a) ? "https://t7z.cupid.iqiyi.com/track2" : this.a;
        if (!strConcat.contains("?")) {
            strConcat = strConcat.concat("?");
        }
        StringBuilder sbAppend = sb.append(strConcat);
        String strA = gj.a((Map) new TreeMap(map), "&", "=", false);
        String string = sbAppend.append(strA + "&sign=" + gj.d(strA + "ahTT6Me3slo2nASK57P1t")).toString();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(string);
        return arrayList;
    }
}
