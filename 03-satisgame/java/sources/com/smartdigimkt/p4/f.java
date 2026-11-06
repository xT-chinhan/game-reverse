package com.smartdigimkt.p4;

import android.text.TextUtils;
import com.anythink.core.common.f.h;
import com.anythink.core.common.f.i;
import com.smartdigimkt.r4.k;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static final f b = new f(null);
    public final Object a;

    public f(LinkedHashMap linkedHashMap) {
        Object obj;
        a(linkedHashMap, i.a.c, "bidId");
        a(linkedHashMap, h.b.d, "request_url", "requestUrl");
        a(linkedHashMap, "tp_bid_id", "tpBidId");
        String[] strArr = {"adx_extra", "adxExtra"};
        if (linkedHashMap == null || linkedHashMap.isEmpty()) {
            obj = null;
        } else {
            for (int i = 0; i < 2; i++) {
                String str = strArr[i];
                if (linkedHashMap.containsKey(str)) {
                    obj = linkedHashMap.get(str);
                }
            }
            obj = null;
        }
        this.a = obj;
        ((Double) k.a(linkedHashMap, com.anythink.core.d.b.e.a.h, Double.valueOf(0.0d))).getClass();
        ((Double) k.a(linkedHashMap, "cny_price", Double.valueOf(0.0d))).getClass();
        ((Double) k.a(linkedHashMap, "origin_price", Double.valueOf(0.0d))).getClass();
        ((Double) k.a(linkedHashMap, com.anythink.core.common.k.aq, Double.valueOf(0.0d))).getClass();
        ((Double) k.a(linkedHashMap, "ecpm_api", Double.valueOf(0.0d))).getClass();
        ((Double) k.a(linkedHashMap, "cny_ecpm_api", Double.valueOf(0.0d))).getClass();
    }

    public static void a(LinkedHashMap linkedHashMap, String... strArr) {
        if (linkedHashMap == null || linkedHashMap.isEmpty()) {
            return;
        }
        int length = strArr.length;
        for (int i = 0; i < length && TextUtils.isEmpty((String) k.a(linkedHashMap, strArr[i], "")); i++) {
        }
    }
}
