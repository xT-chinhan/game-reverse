package com.byazt.md;

import com.kwad.sdk.api.loader.ApiSpUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 801, 19})
public final class n {
    public static final n n = new n(false, 0, 0, 3000, 1000, 4, 2000, 180000, 16);
    public final int fs;
    public final int l;
    public final int q;
    public final boolean qg;
    public final long rv;
    public final int s;
    public final int tj;
    public final int w;
    public final int x;

    private n(boolean z, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7) {
        this.qg = z;
        this.s = i;
        this.q = i2;
        this.l = i3;
        this.w = i4;
        this.x = i5;
        this.fs = i6;
        this.rv = j;
        this.tj = i7;
    }

    public static n n(JSONObject jSONObject, long j, int i) {
        if (jSONObject == null) {
            return n;
        }
        boolean zOptBoolean = jSONObject.optBoolean("enable", false);
        int iOptInt = jSONObject.optInt("rate", 0);
        int iOptInt2 = jSONObject.optInt("f_rate", 0);
        int iOptInt3 = jSONObject.optInt(ApiSpUtils.SP_INTERVAL, 3000);
        int iOptInt4 = jSONObject.optInt("window_interval", 1000);
        int iOptInt5 = jSONObject.optInt("window_count", 4);
        int iOptInt6 = jSONObject.optInt("destroy_delay", 2000);
        long jOptLong = jSONObject.optLong("max_session_ttl", j);
        int iOptInt7 = jSONObject.optInt("max_active_sessions", i);
        int i2 = iOptInt4 <= 0 ? 1000 : iOptInt4;
        int i3 = iOptInt5 <= 0 ? 4 : iOptInt5;
        int i4 = iOptInt6 > 0 ? iOptInt6 : 2000;
        if (jOptLong <= 0) {
            jOptLong = 180000;
        }
        if (iOptInt7 <= 0) {
            iOptInt7 = 16;
        }
        return new n(zOptBoolean, n(iOptInt), n(iOptInt2), iOptInt3, i2, i3, i4, jOptLong, iOptInt7);
    }

    public boolean n() {
        return this.qg;
    }

    public int qg() {
        return this.s;
    }

    public int s() {
        return this.q;
    }

    public boolean q() {
        if (this.qg) {
            return (this.s > 0 || this.q > 0) && this.l > 0;
        }
        return false;
    }

    public int l() {
        return this.l;
    }

    public int w() {
        return this.w;
    }

    public int x() {
        return this.x;
    }

    public int fs() {
        return this.fs;
    }

    public long rv() {
        return this.rv;
    }

    public int tj() {
        return this.tj;
    }

    private static int n(int i) {
        if (i <= 0) {
            return 0;
        }
        return Math.min(i, 10000);
    }
}
