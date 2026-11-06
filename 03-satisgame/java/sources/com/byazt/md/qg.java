package com.byazt.md;

import com.kwad.sdk.api.loader.ApiSpUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 801, 26})
public final class qg {
    public static final qg n = new qg(false, 0, 0, 3000, 500, 2, 2000, 100, 180000, 16);
    public final int cp;
    public final int fs;
    public final int l;
    public final int q;
    public final boolean qg;
    public final int rv;
    public final int s;
    public final long tj;
    public final int w;
    public final int x;

    private qg(boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8) {
        this.qg = z;
        this.s = i;
        this.q = i2;
        this.l = i3;
        this.w = i4;
        this.x = i5;
        this.fs = i6;
        this.rv = i7;
        this.tj = j;
        this.cp = i8;
    }

    public static qg n(JSONObject jSONObject, long j, int i) {
        if (jSONObject == null) {
            return n;
        }
        boolean zOptBoolean = jSONObject.optBoolean("enable", false);
        int iOptInt = jSONObject.optInt("rate", 0);
        int iOptInt2 = jSONObject.optInt("f_rate", 0);
        int iOptInt3 = jSONObject.optInt(ApiSpUtils.SP_INTERVAL, 3000);
        int iOptInt4 = jSONObject.optInt("window_interval", 500);
        int iOptInt5 = jSONObject.optInt("window_count", 2);
        int iOptInt6 = jSONObject.optInt("destroy_delay", 2000);
        int iOptInt7 = jSONObject.optInt("jank_interval", 100);
        long jOptLong = jSONObject.optLong("max_session_ttl", j);
        int iOptInt8 = jSONObject.optInt("max_active_sessions", i);
        int i2 = iOptInt4 <= 0 ? 500 : iOptInt4;
        int i3 = iOptInt5 <= 0 ? 2 : iOptInt5;
        int i4 = iOptInt6 > 0 ? iOptInt6 : 2000;
        if (iOptInt7 <= 0) {
            iOptInt7 = 100;
        }
        long j2 = jOptLong <= 0 ? 180000L : jOptLong;
        if (iOptInt8 <= 0) {
            iOptInt8 = 16;
        }
        return new qg(zOptBoolean, n(iOptInt), n(iOptInt2), iOptInt3, i2, i3, i4, iOptInt7, j2, iOptInt8);
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

    public int rv() {
        return this.rv;
    }

    public long tj() {
        return this.tj;
    }

    public int cp() {
        return this.cp;
    }

    private static int n(int i) {
        if (i <= 0) {
            return 0;
        }
        return Math.min(i, 10000);
    }
}
