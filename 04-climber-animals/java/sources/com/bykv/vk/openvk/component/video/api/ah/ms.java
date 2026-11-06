package com.bykv.vk.openvk.component.video.api.ah;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f17ms;
    private int x;
    private String xr;
    private long ah = -2147483648L;
    private int d = Integer.MIN_VALUE;
    private long ka = -2147483648L;
    private double c = -2.147483648E9d;
    private double ab = -2.147483648E9d;

    public JSONObject ms() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.xr)) {
                jSONObject.putOpt("audio_url", this.xr);
            }
            if (!TextUtils.isEmpty(this.f17ms)) {
                jSONObject.putOpt("file_hash", this.f17ms);
            }
            long j = this.ah;
            if (j > 0) {
                jSONObject.put("size", j);
            }
            int i = this.d;
            if (i >= 0) {
                jSONObject.put("reward_audio_cached_type", i);
            }
            long j2 = this.ka;
            if (j2 >= 0) {
                jSONObject.put("audio_preload_size", j2);
            }
            double d = this.c;
            if (d > 0.0d) {
                jSONObject.put("audio_duration", d);
            }
            double d2 = this.ab;
            if (d2 > 0.0d) {
                jSONObject.put("start", d2);
            }
            int i2 = this.x;
            if (i2 > 0) {
                jSONObject.put("repeat_count", i2);
            }
            return jSONObject;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public String xr() {
        return this.f17ms;
    }

    public void ms(String str) {
        this.f17ms = str;
    }

    public long ah() {
        return this.ah;
    }

    public void ms(long j) {
        this.ah = j;
    }

    public void ms(int i) {
        this.d = i;
    }

    public double d() {
        return this.ab;
    }

    public void ms(double d) {
        this.ab = d;
    }

    public void xr(long j) {
        this.ka = j;
    }

    public String ka() {
        return this.xr;
    }

    public void xr(String str) {
        this.xr = str;
    }

    public double c() {
        return this.c;
    }

    public void xr(double d) {
        this.c = d;
    }

    public void xr(int i) {
        if (i < 0) {
            i = 0;
        }
        this.x = i;
    }

    public int ab() {
        return this.x;
    }
}
