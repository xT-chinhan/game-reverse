package com.byazt.kl;

import com.anythink.china.a.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 445, 110})
public class sz {
    public final JSONObject n;
    public int qg;

    private sz(JSONObject jSONObject) {
        this.n = jSONObject;
    }

    public void n(int i) {
        this.qg = qg(i);
    }

    public int n() {
        return this.qg;
    }

    private int cy() {
        return this.n.optInt("url_balance", 2);
    }

    public boolean qg() {
        return cy() > 0;
    }

    public boolean s() {
        return cy() == 1;
    }

    public int q() {
        return this.n.optInt("buffer_count", 512);
    }

    public int l() {
        return this.n.optInt("buffer_size", 8192);
    }

    public boolean w() {
        return this.n.optInt("segment_mode", 1) == 0;
    }

    public long x() {
        long jOptInt = ((long) this.n.optInt("segment_min_kb", 512)) * c.k;
        return jOptInt < c.q ? c.q : jOptInt;
    }

    public long fs() {
        long jOptInt = ((long) this.n.optInt("segment_min_init_mb", 10)) * 1048576;
        if (jOptInt < 5242880) {
            return 5242880L;
        }
        return jOptInt;
    }

    public long rv() {
        long jOptInt = ((long) this.n.optInt("segment_max_kb", 0)) * 1048576;
        if (jOptInt < x()) {
            return -1L;
        }
        return jOptInt;
    }

    public long tj() {
        long jOptInt = this.n.optInt("connect_timeout", -1);
        if (jOptInt >= 2000) {
            return jOptInt;
        }
        return -1L;
    }

    public long cp() {
        long jOptInt = this.n.optInt("read_timeout", -1);
        if (jOptInt >= 4000) {
            return jOptInt;
        }
        return -1L;
    }

    public int d() {
        return this.n.optInt("ip_strategy", 0);
    }

    private int qg(int i) {
        int iOptInt = this.n.optInt("thread_count", 4);
        if (iOptInt > 16) {
            iOptInt = 16;
        }
        if (iOptInt > 0) {
            return cy() == 1 ? Math.min(iOptInt, i) : iOptInt;
        }
        if (cy() > 0) {
            return i;
        }
        return 1;
    }

    public float oa() {
        return (float) this.n.optDouble("main_ratio", 0.0d);
    }

    public int sz() {
        return this.n.optInt("ratio_segment", 0);
    }

    public float k() {
        return Math.min(Math.max(0.0f, (float) this.n.optDouble("poor_speed_ratio", 0.0d)), 1.0f);
    }

    public static sz n(JSONObject jSONObject) {
        return new sz(jSONObject);
    }
}
