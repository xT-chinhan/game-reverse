package com.bytedance.adsdk.ugeno.ms;

import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    private String ab;
    private int ah;
    private ms c;
    private String d;
    private long ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Map<String, TreeMap<Float, String>> f384ms;
    private JSONObject x;
    private long xr;

    public static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public String f385ms;
        public String xr;
    }

    public JSONObject ms() {
        return this.x;
    }

    public void ms(JSONObject jSONObject) {
        this.x = jSONObject;
    }

    public Map<String, TreeMap<Float, String>> xr() {
        return this.f384ms;
    }

    public void ms(Map<String, TreeMap<Float, String>> map) {
        this.f384ms = map;
    }

    public long ah() {
        return this.xr;
    }

    public void ms(long j) {
        this.xr = j;
    }

    public int d() {
        return this.ah;
    }

    public void ms(int i) {
        this.ah = i;
    }

    public String ka() {
        return this.d;
    }

    public void ms(String str) {
        this.d = str;
    }

    public long c() {
        return this.ka;
    }

    public void xr(long j) {
        this.ka = j;
    }

    public ms ab() {
        return this.c;
    }

    public void ms(ms msVar) {
        this.c = msVar;
    }

    public String x() {
        return this.ab;
    }

    public void xr(String str) {
        this.ab = str;
    }

    public String toString() {
        return "AnimationModel{mKeyFramesMap=" + this.f384ms + ", mDuration=" + this.xr + ", mPlayCount=" + this.ah + ", mPlayDirection=" + this.d + ", mDelay=" + this.ka + ", mTransformOrigin='" + this.c + "', mTimingFunction='" + this.ab + "'}";
    }
}
