package com.byazt.qg;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 26, 5})
public abstract class q {
    public abstract String n();

    public abstract JSONObject qg();

    public static void n(q qVar) {
        if (qVar == null) {
            return;
        }
        com.byazt.gh.q.n(qVar.n(), qVar.qg());
    }
}
