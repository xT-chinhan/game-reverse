package com.byazt.zo;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 588, 8})
public class s {
    public static com.byazt.jp.w n(com.byazt.xmw.s sVar) {
        if (sVar == null) {
            return null;
        }
        com.byazt.jp.w wVar = new com.byazt.jp.w();
        wVar.n(sVar.qg());
        wVar.q(sVar.w());
        wVar.qg(sVar.s());
        wVar.s(sVar.q());
        wVar.n(sVar.l());
        wVar.l(sVar.x());
        wVar.n(sVar.n());
        return wVar;
    }

    public static Map<String, String> n(Map<String, Object> map) {
        HashMap map2 = new HashMap();
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                map2.put(entry.getKey(), entry.getValue().toString());
            }
        }
        return map2;
    }
}
