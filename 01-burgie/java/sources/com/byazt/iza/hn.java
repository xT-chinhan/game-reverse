package com.byazt.iza;

import java.util.Map;
import java.util.TreeMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 124, 20})
public class hn {
    public int aj = 1;
    public long c;
    public String fw;
    public int hn;
    public long hw;
    public Map<String, TreeMap<Float, String>> pr;
    public pr uc;
    public JSONObject vk;
    public String x;
    public String zo;

    @com.byazt.vzx.pr(pr = {0, 1, 124, 116})
    public static class pr {
        public String hw;
        public String pr;
    }

    public JSONObject pr() {
        return this.vk;
    }

    public void pr(JSONObject jSONObject) {
        this.vk = jSONObject;
    }

    public Map<String, TreeMap<Float, String>> hw() {
        return this.pr;
    }

    public void pr(Map<String, TreeMap<Float, String>> map) {
        this.pr = map;
    }

    public long hn() {
        return this.hw;
    }

    public void pr(long j) {
        this.hw = j;
    }

    public int x() {
        return this.hn;
    }

    public void pr(int i) {
        this.hn = i;
    }

    public String c() {
        return this.x;
    }

    public void pr(String str) {
        this.x = str;
    }

    public long uc() {
        return this.c;
    }

    public void hw(long j) {
        this.c = j;
    }

    public pr fw() {
        return this.uc;
    }

    public void pr(pr prVar) {
        this.uc = prVar;
    }

    public String zo() {
        return this.fw;
    }

    public void hw(String str) {
        this.fw = str;
    }

    public String aj() {
        return this.zo;
    }

    public void hn(String str) {
        this.zo = str;
    }

    public int vk() {
        return this.aj;
    }

    public void hw(int i) {
        this.aj = i;
    }

    public String toString() {
        return "AnimationModel{mKeyFramesMap=" + this.pr + ", mDuration=" + this.hw + ", mPlayCount=" + this.hn + ", mPlayDirection=" + this.x + ", mDelay=" + this.c + ", mName=" + this.zo + ", mPlayState=" + this.aj + ", mTransformOrigin='" + this.uc + "', mTimingFunction='" + this.fw + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
