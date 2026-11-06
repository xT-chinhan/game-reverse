package com.byazt.zsl;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 469, 19})
public class n {
    public int fs;
    public String n;
    public String qg;
    public long s = -2147483648L;
    public int q = Integer.MIN_VALUE;
    public long l = -2147483648L;
    public double w = -2.147483648E9d;
    public double x = -2.147483648E9d;

    public JSONObject n() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.qg)) {
                jSONObject.putOpt("audio_url", this.qg);
            }
            if (!TextUtils.isEmpty(this.n)) {
                jSONObject.putOpt("file_hash", this.n);
            }
            long j = this.s;
            if (j > 0) {
                jSONObject.put("size", j);
            }
            int i = this.q;
            if (i >= 0) {
                jSONObject.put("reward_audio_cached_type", i);
            }
            long j2 = this.l;
            if (j2 >= 0) {
                jSONObject.put("audio_preload_size", j2);
            }
            double d = this.w;
            if (d > 0.0d) {
                jSONObject.put("audio_duration", d);
            }
            double d2 = this.x;
            if (d2 > 0.0d) {
                jSONObject.put("start", d2);
            }
            int i2 = this.fs;
            if (i2 > 0) {
                jSONObject.put("repeat_count", i2);
            }
            return jSONObject;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public String qg() {
        return this.n;
    }

    public void n(String str) {
        this.n = str;
    }

    public long s() {
        return this.s;
    }

    public void n(long j) {
        this.s = j;
    }

    public void n(int i) {
        this.q = i;
    }

    public double q() {
        return this.x;
    }

    public void n(double d) {
        this.x = d;
    }

    public void qg(long j) {
        this.l = j;
    }

    public String l() {
        return this.qg;
    }

    public void qg(String str) {
        this.qg = str;
    }

    public double w() {
        return this.w;
    }

    public void qg(double d) {
        this.w = d;
    }

    public void qg(int i) {
        if (i < 0) {
            i = 0;
        }
        this.fs = i;
    }

    public int x() {
        return this.fs;
    }
}
