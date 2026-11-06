package com.byazt.md;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 801, 5})
public final class q {
    public static long l;
    public static volatile q n;
    public static int w;
    public final n q;
    public final s qg;
    public final qg s;

    private static int n(int i) {
        if (i <= 0) {
            return 16;
        }
        return i;
    }

    private static long n(long j) {
        if (j <= 0) {
            return 180000L;
        }
        return j;
    }

    private q(s sVar, qg qgVar, n nVar) {
        this.qg = sVar;
        this.s = qgVar;
        this.q = nVar;
    }

    public static q n() {
        q qVar;
        q qVar2 = n;
        if (qVar2 != null) {
            return qVar2;
        }
        synchronized (q.class) {
            if (n == null) {
                n = fs();
            }
            qVar = n;
        }
        return qVar;
    }

    public static void qg() {
        synchronized (q.class) {
            n = null;
        }
    }

    private static q fs() {
        JSONObject jSONObjectX;
        try {
            jSONObjectX = com.byazt.ph.q.x();
        } catch (Throwable unused) {
            jSONObjectX = null;
        }
        if (jSONObjectX == null) {
            return new q(s.n, qg.n, n.n);
        }
        if (!jSONObjectX.optBoolean("enable", false)) {
            return new q(s.n, qg.n, n.n);
        }
        l = n(jSONObjectX.optLong("max_session_ttl", 180000L));
        w = n(jSONObjectX.optInt("max_active_sessions", 16));
        return new q(s.n(jSONObjectX.optJSONObject("men_config"), l, w), qg.n(jSONObjectX.optJSONObject("jank_config"), l, w), n.n(jSONObjectX.optJSONObject("cpu_config"), l, w));
    }

    public long s() {
        return l;
    }

    public int q() {
        return w;
    }

    public s l() {
        return this.qg;
    }

    public qg w() {
        return this.s;
    }

    public n x() {
        return this.q;
    }
}
