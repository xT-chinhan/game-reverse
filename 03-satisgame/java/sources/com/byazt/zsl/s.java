package com.byazt.zsl;

import android.text.TextUtils;
import com.byazt.af.x;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 469, 8})
public class s implements com.byazt.ej.l {
    public double cp;
    public int d;
    public String fs;
    public String l;
    public int n;
    public int oa;
    public double q;
    public int qg;
    public String rv;
    public long s;
    public String tj;
    public String w;
    public String x;
    public float sz = -1.0f;
    public int k = 0;
    public int cy = 0;
    public int hd = 0;
    public int cd = 0;
    public int um = 307200;
    public int a = 1;

    @Override // com.byazt.ej.l
    public int n() {
        return this.d;
    }

    @Override // com.byazt.ej.l
    public void n(int i) {
        this.d = i;
    }

    @Override // com.byazt.ej.l
    public int qg() {
        return this.n;
    }

    @Override // com.byazt.ej.l
    public void qg(int i) {
        this.n = i;
    }

    @Override // com.byazt.ej.l
    public int s() {
        return this.qg;
    }

    @Override // com.byazt.ej.l
    public void s(int i) {
        this.qg = i;
    }

    @Override // com.byazt.ej.l
    public int q() {
        return this.oa;
    }

    @Override // com.byazt.ej.l
    public void q(int i) {
        this.oa = i;
    }

    @Override // com.byazt.ej.l
    public long l() {
        return this.s;
    }

    @Override // com.byazt.ej.l
    public void n(long j) {
        this.s = j;
    }

    @Override // com.byazt.ej.l
    public double w() {
        return this.q;
    }

    @Override // com.byazt.ej.l
    public void n(double d) {
        this.q = d;
    }

    @Override // com.byazt.ej.l
    public double x() {
        return this.cp;
    }

    @Override // com.byazt.ej.l
    public void qg(double d) {
        this.cp = d;
    }

    @Override // com.byazt.ej.l
    public float fs() {
        return this.sz;
    }

    @Override // com.byazt.ej.l
    public void n(float f) {
        this.sz = f;
    }

    @Override // com.byazt.ej.l
    public String rv() {
        return this.l;
    }

    @Override // com.byazt.ej.l
    public void n(String str) {
        this.l = str;
    }

    @Override // com.byazt.ej.l
    public int[] tj() {
        try {
            int iIndexOf = this.l.indexOf(x.n);
            return new int[]{Integer.parseInt(this.l.substring(0, iIndexOf).trim()), Integer.parseInt(this.l.substring(iIndexOf + 1).trim())};
        } catch (Throwable th) {
            com.byazt.nl.qg.n("VideoInfo", "getWidthAndHeight error", th);
            return null;
        }
    }

    @Override // com.byazt.ej.l
    public String cp() {
        return this.w;
    }

    @Override // com.byazt.ej.l
    public void qg(String str) {
        this.w = str;
    }

    @Override // com.byazt.ej.l
    public String d() {
        return this.x;
    }

    @Override // com.byazt.ej.l
    public void s(String str) {
        this.x = str;
    }

    @Override // com.byazt.ej.l
    public String oa() {
        return this.fs;
    }

    @Override // com.byazt.ej.l
    public void q(String str) {
        this.fs = str;
    }

    @Override // com.byazt.ej.l
    public String sz() {
        return this.rv;
    }

    @Override // com.byazt.ej.l
    public void l(String str) {
        this.rv = str;
    }

    @Override // com.byazt.ej.l
    public String k() {
        if (TextUtils.isEmpty(this.tj)) {
            this.tj = com.byazt.nl.n.n(this.x);
        }
        return this.tj;
    }

    @Override // com.byazt.ej.l
    public void w(String str) {
        this.tj = str;
    }

    @Override // com.byazt.ej.l
    public int cy() {
        if (this.um < 0) {
            this.um = 307200;
        }
        long j = this.um;
        long j2 = this.s;
        if (j > j2) {
            this.um = (int) j2;
        }
        return this.um;
    }

    @Override // com.byazt.ej.l
    public void l(int i) {
        this.um = i;
    }

    @Override // com.byazt.ej.l
    public int hd() {
        return this.hd;
    }

    @Override // com.byazt.ej.l
    public void w(int i) {
        this.hd = i;
    }

    @Override // com.byazt.ej.l
    public int cd() {
        return this.cd;
    }

    @Override // com.byazt.ej.l
    public void x(int i) {
        this.cd = i;
    }

    @Override // com.byazt.ej.l
    public JSONObject um() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cover_height", qg());
            jSONObject.put("cover_url", cp());
            jSONObject.put("cover_width", s());
            jSONObject.put("endcard", oa());
            jSONObject.put("file_hash", k());
            jSONObject.put("resolution", rv());
            jSONObject.put("size", l());
            jSONObject.put("video_duration", w());
            jSONObject.put("video_url", d());
            jSONObject.put("playable_download_url", sz());
            jSONObject.put("if_playable_loading_show", a());
            jSONObject.put("remove_loading_page_type", py());
            jSONObject.put("fallback_endcard_judge", n());
            jSONObject.put("video_preload_size", cy());
            jSONObject.put("reward_video_cached_type", hd());
            jSONObject.put("execute_cached_type", cd());
            jSONObject.put("endcard_render", q());
            jSONObject.put("replay_time", m());
            jSONObject.put("play_speed_ratio", fs());
            if (x() > 0.0d) {
                jSONObject.put("start", x());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    @Override // com.byazt.ej.l
    public int a() {
        return this.k;
    }

    @Override // com.byazt.ej.l
    public void fs(int i) {
        this.k = i;
    }

    @Override // com.byazt.ej.l
    public int py() {
        return this.cy;
    }

    @Override // com.byazt.ej.l
    public void rv(int i) {
        this.cy = i;
    }

    @Override // com.byazt.ej.l
    public boolean ou() {
        return this.cd == 1;
    }

    @Override // com.byazt.ej.l
    public boolean wm() {
        return this.hd == 0;
    }

    @Override // com.byazt.ej.l
    public void tj(int i) {
        this.a = Math.min(4, Math.max(1, i));
    }

    @Override // com.byazt.ej.l
    public int m() {
        return this.a;
    }
}
