package com.byazt.kf;

import com.byazt.is.vk;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1182, 121})
public final class x {
    public static long c;
    public static volatile x pr;
    public static int uc;
    public final hw hn;
    public final hn hw;
    public final pr x;

    private x(hn hnVar, hw hwVar, pr prVar) {
        this.hw = hnVar;
        this.hn = hwVar;
        this.x = prVar;
    }

    public static x pr() {
        x xVar;
        x xVar2 = pr;
        if (xVar2 != null) {
            return xVar2;
        }
        synchronized (x.class) {
            if (pr == null) {
                pr = zo();
            }
            xVar = pr;
        }
        return xVar;
    }

    public static void hw() {
        synchronized (x.class) {
            pr = null;
        }
    }

    private static x zo() {
        JSONObject jSONObjectFw;
        try {
            jSONObjectFw = vk.fw();
        } catch (Throwable th) {
            jSONObjectFw = null;
        }
        if (jSONObjectFw == null) {
            return new x(hn.pr, hw.pr, pr.pr);
        }
        if (!jSONObjectFw.optBoolean("enable", false)) {
            return new x(hn.pr, hw.pr, pr.pr);
        }
        c = pr(jSONObjectFw.optLong("max_session_ttl", 180000L));
        uc = pr(jSONObjectFw.optInt("max_active_sessions", 16));
        return new x(hn.pr(jSONObjectFw.optJSONObject("men_config"), c, uc), hw.pr(jSONObjectFw.optJSONObject("jank_config"), c, uc), pr.pr(jSONObjectFw.optJSONObject("cpu_config"), c, uc));
    }

    private static long pr(long j) {
        if (j <= 0) {
            return 180000L;
        }
        return j;
    }

    private static int pr(int i) {
        if (i <= 0) {
            return 16;
        }
        return i;
    }

    public long hn() {
        return c;
    }

    public int x() {
        return uc;
    }

    public hn c() {
        return this.hw;
    }

    public hw uc() {
        return this.hn;
    }

    public pr fw() {
        return this.x;
    }
}
