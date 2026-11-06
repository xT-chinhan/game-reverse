package com.byazt.kg;

import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1238, 8})
public class s {
    public String fs;
    public long l;
    public Map<String, TreeMap<Float, String>> n;
    public String q;
    public long qg;
    public int rv = 1;
    public int s;
    public JSONObject tj;
    public n w;
    public String x;

    @com.byazt.cp.n(n = {0, 1, 1238, 546})
    public static class n {
        public String n;
        public String qg;
    }

    public JSONObject n() {
        return this.tj;
    }

    public void n(JSONObject jSONObject) {
        this.tj = jSONObject;
    }

    public Map<String, TreeMap<Float, String>> qg() {
        return this.n;
    }

    public void n(Map<String, TreeMap<Float, String>> map) {
        this.n = map;
    }

    public long s() {
        return this.qg;
    }

    public void n(long j) {
        this.qg = j;
    }

    public int q() {
        return this.s;
    }

    public void n(int i) {
        this.s = i;
    }

    public String l() {
        return this.q;
    }

    public void n(String str) {
        this.q = str;
    }

    public long w() {
        return this.l;
    }

    public void qg(long j) {
        this.l = j;
    }

    public n x() {
        return this.w;
    }

    public void n(n nVar) {
        this.w = nVar;
    }

    public String fs() {
        return this.x;
    }

    public void qg(String str) {
        this.x = str;
    }

    public String rv() {
        return this.fs;
    }

    public void s(String str) {
        this.fs = str;
    }

    public int tj() {
        return this.rv;
    }

    public void qg(int i) {
        this.rv = i;
    }

    public String toString() {
        return "AnimationModel{mKeyFramesMap=" + this.n + ", mDuration=" + this.qg + ", mPlayCount=" + this.s + ", mPlayDirection=" + this.q + ", mDelay=" + this.l + ", mName=" + this.fs + ", mPlayState=" + this.rv + ", mTransformOrigin='" + this.w + "', mTimingFunction='" + this.x + "'}";
    }
}
