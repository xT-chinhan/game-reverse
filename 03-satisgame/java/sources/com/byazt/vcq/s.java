package com.byazt.vcq;

import android.text.TextUtils;
import com.byazt.tbt.d;
import com.byazt.tbt.sz;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1112, 8})
public abstract class s {
    public Map<String, Object> n;
    public d s;
    public String q = null;
    public final Map<String, String> l = new HashMap();
    public String w = null;
    public boolean x = false;

    public abstract com.byazt.phf.q n();

    public abstract void n(com.byazt.dgx.n nVar);

    public s(d dVar) {
        this.s = dVar;
        qg(UUID.randomUUID().toString());
    }

    public void n(String str) {
        this.w = str;
    }

    public void qg(String str, String str2) {
        this.l.put(str, str2);
    }

    public void q(Map<String, String> map) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.l.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void qg(String str) {
        this.q = str;
    }

    public String qg() {
        return this.q;
    }

    public void s() {
        d dVar;
        if (this.q == null || (dVar = this.s) == null) {
            return;
        }
        com.byazt.tbt.q qVarN = dVar.n();
        synchronized (qVarN) {
            for (com.byazt.tbt.qg qgVar : qVarN.s()) {
                if (this.q.equals(qgVar.n().n())) {
                    qgVar.s();
                }
            }
            for (com.byazt.tbt.qg qgVar2 : qVarN.q()) {
                if (this.q.equals(qgVar2.n().n())) {
                    qgVar2.s();
                }
            }
        }
        com.byazt.phf.n.n((Object) this.q);
    }

    public Map<String, Object> q() {
        return this.n;
    }

    public void l(Map<String, Object> map) {
        this.n = map;
    }

    public void n(sz.n nVar) {
        if (nVar != null && this.l.size() > 0) {
            for (Map.Entry<String, String> entry : this.l.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    String value = entry.getValue();
                    if (value == null) {
                        value = "";
                    }
                    nVar.qg(key, value);
                }
            }
        }
    }

    public void n(boolean z) {
        this.x = z;
    }
}
