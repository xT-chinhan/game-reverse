package com.ss.android.socialbase.downloader.c;

import com.anythink.basead.exoplayer.i.a;
import com.ss.android.download.api.constant.BaseConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class u {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final JSONObject f4622ms;
    private int xr;

    private u(JSONObject jSONObject) {
        this.f4622ms = jSONObject;
    }

    public void ms(int i) {
        this.xr = xr(i);
    }

    public int ms() {
        return this.xr;
    }

    private int ao() {
        return this.f4622ms.optInt("url_balance", 2);
    }

    public boolean xr() {
        return ao() > 0;
    }

    public boolean ah() {
        return ao() == 1;
    }

    public int d() {
        return this.f4622ms.optInt("buffer_count", 512);
    }

    public int ka() {
        return this.f4622ms.optInt("buffer_size", 8192);
    }

    public boolean c() {
        return this.f4622ms.optInt("segment_mode", 1) == 0;
    }

    public long ab() {
        long jOptInt = ((long) this.f4622ms.optInt("segment_min_kb", 512)) * 1024;
        if (jOptInt < 65536) {
            return 65536L;
        }
        return jOptInt;
    }

    public long x() {
        long jOptInt = ((long) this.f4622ms.optInt("segment_min_init_mb", 10)) * BaseConstants.MB_VALUE;
        if (jOptInt < 5242880) {
            return 5242880L;
        }
        return jOptInt;
    }

    public long ny() {
        long jOptInt = ((long) this.f4622ms.optInt("segment_max_kb", 0)) * BaseConstants.MB_VALUE;
        if (jOptInt < ab()) {
            return -1L;
        }
        return jOptInt;
    }

    public long ch() {
        long jOptInt = this.f4622ms.optInt("connect_timeout", -1);
        if (jOptInt >= a.f) {
            return jOptInt;
        }
        return -1L;
    }

    public long hi() {
        long jOptInt = this.f4622ms.optInt("read_timeout", -1);
        if (jOptInt >= 4000) {
            return jOptInt;
        }
        return -1L;
    }

    public int sl() {
        return this.f4622ms.optInt("ip_strategy", 0);
    }

    private int xr(int i) {
        int iOptInt = this.f4622ms.optInt("thread_count", 4);
        if (iOptInt > 16) {
            iOptInt = 16;
        }
        if (iOptInt > 0) {
            return ao() == 1 ? Math.min(iOptInt, i) : iOptInt;
        }
        if (ao() > 0) {
            return i;
        }
        return 1;
    }

    public float zb() {
        return (float) this.f4622ms.optDouble("main_ratio", 0.0d);
    }

    public int u() {
        return this.f4622ms.optInt("ratio_segment", 0);
    }

    public float ub() {
        return Math.min(Math.max(0.0f, (float) this.f4622ms.optDouble("poor_speed_ratio", 0.0d)), 1.0f);
    }

    public static u ms(JSONObject jSONObject) {
        return new u(jSONObject);
    }
}
