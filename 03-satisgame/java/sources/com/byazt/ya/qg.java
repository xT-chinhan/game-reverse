package com.byazt.ya;

import com.byazt.jp.cp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 935, 26})
public class qg {
    public static volatile qg s;
    public cp n;
    public final Map<String, com.byazt.ju.q> qg = new ConcurrentHashMap();

    public static qg n() {
        if (s == null) {
            synchronized (qg.class) {
                if (s == null) {
                    s = new qg();
                }
            }
        }
        return s;
    }

    private qg() {
    }

    public synchronized Map<String, com.byazt.ju.q> qg() {
        return this.qg;
    }

    public Collection<com.byazt.ju.q> s() {
        return this.qg.values();
    }

    public com.byazt.ju.q n(String str, cp cpVar) {
        this.n = cpVar;
        return n(str);
    }

    public synchronized com.byazt.ju.q n(String str) {
        com.byazt.ju.q qVarQg;
        qVarQg = qg(str);
        if (qVarQg == null) {
            com.byazt.ws.n nVarN = com.byazt.qt.qg.n().n(str);
            if (nVarN == null && this.n != null) {
                nVarN = new com.byazt.ws.n(this.n.l(), this.n.s(), this.n.q());
                this.n = null;
            }
            if (nVarN != null && !nVarN.l()) {
                qVarQg = s(str);
            }
            if (qVarQg != null) {
                n(str, qVarQg);
            }
        }
        return qVarQg;
    }

    private com.byazt.ju.q qg(String str) {
        if (str == null) {
            return null;
        }
        return this.qg.get(str);
    }

    private void n(String str, com.byazt.ju.q qVar) {
        if (str == null) {
            return;
        }
        this.qg.put(str, qVar);
    }

    private com.byazt.ju.q s(String str) {
        if (MediationConstant.ADN_PANGLE.equalsIgnoreCase(str)) {
            return new com.byazt.mt.n();
        }
        return new q();
    }
}
