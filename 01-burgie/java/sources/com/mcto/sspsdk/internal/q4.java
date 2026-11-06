package com.mcto.sspsdk.internal;

import android.text.TextUtils;
import com.mcto.sspsdk.QySdk;
import com.taptap.sdk.db.constant.Common;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class q4 implements s7 {
    public String a;
    public final HashSet b = new HashSet();
    public HashMap c;
    public HashMap d;

    public String a() {
        String str;
        if (!TextUtils.isEmpty(this.a)) {
            str = this.a;
        } else if (lj.b(h4.b)) {
            str = "https://t7z.cupid.iqiyi.com/track2";
            h4.b = "https://t7z.cupid.iqiyi.com/track2";
        } else {
            str = h4.b;
        }
        return !str.contains("?") ? str.concat("?") : str;
    }

    @Override // com.mcto.sspsdk.internal.s7
    public ArrayList b(int i, p pVar) {
        HashMap mapC = c(i, pVar);
        if (mapC == null || mapC.isEmpty()) {
            return null;
        }
        if (j.b(2, i)) {
            mapC.put("cts", Integer.valueOf(pVar.p));
            int i2 = pVar.n;
            if (i2 > 0) {
                mapC.put("blt", Integer.valueOf(i2));
            }
        } else if (j.b(1, i) && pVar.b && !pVar.D0) {
            mapC.put("sbdf", 1);
        }
        return a(i, pVar, mapC);
    }

    public HashMap c(int i, p pVar) {
        HashMap mapA = a(i);
        if (mapA == null) {
            return null;
        }
        mapA.put(an.av, ak.b(i));
        mapA.put("cv", y4.r.c());
        mapA.put(Common.Predefined.SUB_SV, QySdk.SDK_VERSION);
        mapA.put("st", Integer.valueOf(pVar.c.n));
        mh mhVarC = pVar.c();
        if (mhVarC != null) {
            mapA.put("r", mhVarC.g);
        }
        return mapA;
    }

    public final HashMap a(int i) {
        Map map;
        HashSet hashSet = this.b;
        if (hashSet == null || this.c == null || !hashSet.contains(ak.b(i))) {
            return null;
        }
        HashMap map2 = new HashMap(this.c);
        HashMap map3 = this.d;
        if (map3 != null && (map = (Map) map3.get(ak.b(i))) != null) {
            map2.putAll(map);
        }
        return map2;
    }

    public final ArrayList a(int i, p pVar, Map map) {
        String strA = a(bk.a(i, pVar, bk.a(i, a() + gj.a(map, "&", "=", false), pVar, pVar.c())));
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(strA);
        return arrayList;
    }

    @Override // com.mcto.sspsdk.internal.s7
    public final List a(int i, p pVar) {
        HashMap mapC = c(i, pVar);
        if (mapC == null || mapC.isEmpty()) {
            return null;
        }
        int i2 = pVar.F0;
        if (i2 != 1 && i2 != 2) {
            mapC.put("eti", gj.f(pVar.z0) + "__CUPID_ETI__");
        }
        ArrayList arrayList = new ArrayList(1);
        String strReplace = a() + gj.a((Map) mapC, "&", "=", false);
        if (pVar.f() > 0.0f) {
            strReplace = strReplace.replace("SETTLEMENT_WATERFALL", gj.f(gj.b("" + pVar.f())));
        }
        arrayList.add(strReplace);
        return arrayList;
    }

    public String a(String str) {
        return bk.b(str);
    }
}
