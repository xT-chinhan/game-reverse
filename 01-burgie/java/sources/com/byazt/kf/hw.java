package com.byazt.kf;

import com.taptap.sdk.update.download.DownloadTask;
import com.umeng.analytics.pro.an;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1182, 13})
public final class hw {
    public static final hw pr = new hw(false, 0, 3000, 500, 2, DownloadTask.Builder.DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS, 100, 180000, 16);
    public final long aj;
    public final int c;
    public final int fw;
    public final int hn;
    public final boolean hw;
    public final int uc;
    public final int vk;
    public final int x;
    public final int zo;

    private hw(boolean z, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7) {
        this.hw = z;
        this.hn = i;
        this.x = i2;
        this.c = i3;
        this.uc = i4;
        this.fw = i5;
        this.zo = i6;
        this.aj = j;
        this.vk = i7;
    }

    public static hw pr(JSONObject jSONObject, long j, int i) {
        int i2;
        long j2;
        int i3;
        if (jSONObject != null) {
            boolean zOptBoolean = jSONObject.optBoolean("enable", false);
            int iOptInt = jSONObject.optInt("rate", 0);
            int iOptInt2 = jSONObject.optInt(an.aU, 3000);
            int iOptInt3 = jSONObject.optInt("window_interval", 500);
            int iOptInt4 = jSONObject.optInt("window_count", 2);
            int i4 = DownloadTask.Builder.DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS;
            int iOptInt5 = jSONObject.optInt("destroy_delay", DownloadTask.Builder.DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS);
            int iOptInt6 = jSONObject.optInt("jank_interval", 100);
            long jOptLong = jSONObject.optLong("max_session_ttl", j);
            int iOptInt7 = jSONObject.optInt("max_active_sessions", i);
            if (iOptInt3 <= 0) {
                iOptInt3 = 500;
            }
            if (iOptInt4 > 0) {
                i2 = iOptInt4;
            } else {
                i2 = 2;
            }
            if (iOptInt5 > 0) {
                i4 = iOptInt5;
            }
            if (iOptInt6 <= 0) {
                iOptInt6 = 100;
            }
            if (jOptLong > 0) {
                j2 = jOptLong;
            } else {
                j2 = 180000;
            }
            if (iOptInt7 > 0) {
                i3 = iOptInt7;
            } else {
                i3 = 16;
            }
            return new hw(zOptBoolean, pr(iOptInt), iOptInt2, iOptInt3, i2, i4, iOptInt6, j2, i3);
        }
        return pr;
    }

    public boolean pr() {
        return this.hw;
    }

    public int hw() {
        return this.hn;
    }

    public boolean hn() {
        return this.hw && this.hn > 0 && this.x > 0;
    }

    public int x() {
        return this.x;
    }

    public int c() {
        return this.c;
    }

    public int uc() {
        return this.uc;
    }

    public int fw() {
        return this.fw;
    }

    public int zo() {
        return this.zo;
    }

    public long aj() {
        return this.aj;
    }

    public int vk() {
        return this.vk;
    }

    private static int pr(int i) {
        if (i <= 0) {
            return 0;
        }
        return Math.min(i, 10000);
    }
}
