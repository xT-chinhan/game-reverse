package com.byazt.vt;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1387, 19})
public class n {
    public volatile Map<String, s> n = new HashMap();

    public s n(String str) {
        if (this.n.containsKey(str) && this.n.get(str) != null) {
            return this.n.get(str);
        }
        qg qgVar = new qg();
        this.n.put(str, qgVar);
        return qgVar;
    }

    public void n(String str, s sVar) {
        if (!this.n.containsKey(str) || this.n.get(str) == null) {
            this.n.put(str, sVar);
        }
    }
}
