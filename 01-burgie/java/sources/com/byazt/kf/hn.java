package com.byazt.kf;

import com.byazt.fi.BaseConstants;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.umeng.analytics.pro.an;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1182, 20})
public final class hn {
    public static final hn pr = new hn(false, 0, BaseConstants.Time.MINUTE, 1000, 4, AVMDLDataLoader.KeyIsLiveSetLoaderType, 180000, 16);
    public final int aj;
    public final int c;
    public final int fw;
    public final int hn;
    public final boolean hw;
    public final int uc;
    public final int x;
    public final long zo;

    private hn(boolean z, int i, int i2, int i3, int i4, int i5, long j, int i6) {
        this.hw = z;
        this.hn = i;
        this.x = i2;
        this.c = i3;
        this.uc = i4;
        this.fw = i5;
        this.zo = j;
        this.aj = i6;
    }

    public static hn pr(JSONObject jSONObject, long j, int i) {
        int i2;
        long j2;
        int i3;
        if (jSONObject == null) {
            return pr;
        }
        boolean zOptBoolean = jSONObject.optBoolean("enable", false);
        int iOptInt = jSONObject.optInt("rate", 0);
        int iOptInt2 = jSONObject.optInt(an.aU, BaseConstants.Time.MINUTE);
        int iOptInt3 = jSONObject.optInt("window_interval", 1000);
        int iOptInt4 = jSONObject.optInt("window_count", 4);
        int i4 = AVMDLDataLoader.KeyIsLiveSetLoaderType;
        int iOptInt5 = jSONObject.optInt("destroy_delay", AVMDLDataLoader.KeyIsLiveSetLoaderType);
        long jOptLong = jSONObject.optLong("max_session_ttl", j);
        int iOptInt6 = jSONObject.optInt("max_active_sessions", i);
        if (iOptInt3 <= 0) {
            iOptInt3 = 1000;
        }
        if (iOptInt4 > 0) {
            i2 = iOptInt4;
        } else {
            i2 = 4;
        }
        if (iOptInt5 > 0) {
            i4 = iOptInt5;
        }
        if (jOptLong > 0) {
            j2 = jOptLong;
        } else {
            j2 = 180000;
        }
        if (iOptInt6 > 0) {
            i3 = iOptInt6;
        } else {
            i3 = 16;
        }
        return new hn(zOptBoolean, pr(iOptInt), iOptInt2, iOptInt3, i2, i4, j2, i3);
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

    public long zo() {
        return this.zo;
    }

    public int aj() {
        return this.aj;
    }

    private static int pr(int i) {
        if (i <= 0) {
            return 0;
        }
        return Math.min(i, 10000);
    }
}
