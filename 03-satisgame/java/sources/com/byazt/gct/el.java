package com.byazt.gct;

import android.graphics.Color;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 989})
public class el {
    public qg cp;
    public qg d;
    public int fs;
    public int k;
    public int l;
    public int n;
    public int oa;
    public int q;
    public String qg;
    public n sz;
    public int w;
    public int x;
    public boolean s = false;
    public String rv = "#008DEA";
    public String tj = "点击查看";
    public float cy = 0.0f;
    public int hd = 0;
    public int cd = 0;
    public int um = 55;
    public int a = 0;
    public float py = 0.0f;
    public int ou = 100;
    public int wm = 0;
    public int m = 0;
    public int hu = 0;

    public int n() {
        return this.n;
    }

    public void n(int i) {
        this.n = i;
    }

    public String qg() {
        if (this.q == 4 && !com.byazt.vyf.s.cy().n(com.byazt.nf.rv.getContext())) {
            this.qg = "点击跳转至详情页或第三方应用";
        } else if (this.q == 7 && !com.byazt.vyf.s.cy().qg(com.byazt.nf.rv.getContext())) {
            this.qg = "点击跳转至详情页或第三方应用";
        }
        return this.qg;
    }

    public boolean s() {
        return this.s;
    }

    public void n(String str) {
        if (TextUtils.isEmpty(str)) {
            this.s = true;
            int i = this.q;
            if (i == 3) {
                this.qg = "跳转至详情页或第三方应用";
                return;
            }
            if (i == 4) {
                this.qg = "前往详情页或第三方应用";
                return;
            } else if (i == 5 || i == 7) {
                this.qg = "前往详情页或第三方应用";
                return;
            } else {
                this.qg = "点击跳转至详情页或第三方应用";
                return;
            }
        }
        this.qg = str;
    }

    public int q() {
        return this.l;
    }

    public void qg(int i) {
        this.l = i;
    }

    public int l() {
        return this.w;
    }

    public void s(int i) {
        this.w = i;
    }

    public int w() {
        return this.x;
    }

    public void q(int i) {
        this.x = i;
    }

    public int x() {
        return this.fs;
    }

    public void l(int i) {
        this.fs = i;
    }

    public void w(int i) {
        this.k = i;
    }

    public int fs() {
        return this.k;
    }

    public int rv() {
        if (this.q == 4 && !com.byazt.vyf.s.cy().n(com.byazt.nf.rv.getContext())) {
            this.q = 0;
        } else if (this.q == 7 && !com.byazt.vyf.s.cy().qg(com.byazt.nf.rv.getContext())) {
            this.q = 0;
        }
        return this.q;
    }

    public void x(int i) {
        this.q = i;
    }

    public String tj() {
        return this.rv;
    }

    public void qg(String str) {
        try {
            Color.parseColor(str);
            this.rv = str;
        } catch (Throwable unused) {
            this.rv = "#008DEA";
        }
    }

    public String cp() {
        return this.tj;
    }

    public void s(String str) {
        if (TextUtils.isEmpty(str)) {
            int i = this.q;
            if (i == 7) {
                this.tj = "扭动手机";
                return;
            } else if (i == 5) {
                this.tj = "向上滑动";
                return;
            } else {
                if (i == 4) {
                    this.tj = "摇一摇";
                    return;
                }
                return;
            }
        }
        this.tj = str;
    }

    public void n(JSONObject jSONObject) {
        this.cp = new qg(jSONObject, 14);
    }

    public void qg(JSONObject jSONObject) {
        this.d = new qg(jSONObject, 20);
    }

    public qg d() {
        return this.cp;
    }

    public qg oa() {
        return this.d;
    }

    public void n(JSONObject jSONObject, int i) {
        this.sz = new n(jSONObject, i);
    }

    public n sz() {
        return this.sz;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 1983})
    public class n {
        public int n;
        public int q;
        public int qg;
        public int s;

        public int n() {
            return this.n;
        }

        public int qg() {
            return this.qg;
        }

        public int s() {
            return this.s;
        }

        public int q() {
            return this.q;
        }

        public JSONObject l() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("left_margin", 30);
                jSONObject.put("right_margin", 30);
                jSONObject.put("top_margin", 150);
                jSONObject.put("bottom_margin", 40);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public n(JSONObject jSONObject, int i) {
            this.n = 30;
            this.qg = 30;
            this.s = 150;
            this.q = 40;
            if (jSONObject == null) {
                if (i == 2) {
                    this.s = 40;
                    this.q = 20;
                    return;
                }
                return;
            }
            int iOptInt = jSONObject.optInt("left_margin", 30);
            this.n = iOptInt;
            if (iOptInt < 0 || iOptInt > el.this.t()) {
                this.n = 30;
            }
            int iOptInt2 = jSONObject.optInt("right_margin", 30);
            this.qg = iOptInt2;
            if (iOptInt2 < 0 || iOptInt2 > el.this.t()) {
                this.qg = 30;
            }
            if (i == 2) {
                int iOptInt3 = jSONObject.optInt("top_margin", 40);
                this.s = iOptInt3;
                if (iOptInt3 < 0 || iOptInt3 > el.this.h()) {
                    this.s = 40;
                }
                int iOptInt4 = jSONObject.optInt("bottom_margin", 20);
                this.q = iOptInt4;
                if (iOptInt4 < 0 || iOptInt4 > el.this.h()) {
                    this.q = 20;
                    return;
                }
                return;
            }
            int iOptInt5 = jSONObject.optInt("top_margin", 150);
            this.s = iOptInt5;
            if (iOptInt5 < 0 || iOptInt5 > el.this.h()) {
                this.s = 150;
            }
            int iOptInt6 = jSONObject.optInt("bottom_margin", 40);
            this.q = iOptInt6;
            if (iOptInt6 < 0 || iOptInt6 > el.this.h()) {
                this.q = 40;
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 1221})
    public class qg {
        public int n;

        public JSONObject n() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("font_size", this.n);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public qg(JSONObject jSONObject, int i) {
            this.n = 14;
            if (jSONObject == null) {
                return;
            }
            this.n = jSONObject.optInt("font_size", i);
        }

        public int qg() {
            return this.n;
        }
    }

    public int k() {
        return this.oa;
    }

    public void fs(int i) {
        if (i <= 0 || i >= h()) {
            this.oa = 5;
        } else {
            this.oa = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h() {
        return com.byazt.okk.s.q(com.byazt.nf.rv.getContext(), com.byazt.okk.s.w(com.byazt.nf.rv.getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int t() {
        return com.byazt.okk.s.q(com.byazt.nf.rv.getContext(), com.byazt.okk.s.l(com.byazt.nf.rv.getContext()));
    }

    public void n(float f) {
        this.cy = f;
    }

    public float cy() {
        return this.cy;
    }

    public void rv(int i) {
        this.hd = i;
    }

    public int hd() {
        return this.hd;
    }

    public void tj(int i) {
        this.cd = i;
    }

    public int cd() {
        return this.cd;
    }

    public void cp(int i) {
        this.um = i;
    }

    public int um() {
        return this.um;
    }

    public void d(int i) {
        this.a = i;
    }

    public int a() {
        return this.a;
    }

    public void oa(int i) {
        this.ou = i;
    }

    public int py() {
        return this.ou;
    }

    public void sz(int i) {
        this.wm = i;
    }

    public int ou() {
        return this.wm;
    }

    public void k(int i) {
        this.m = i;
    }

    public int wm() {
        return this.m;
    }

    public void cy(int i) {
        this.hu = i;
    }

    public int m() {
        return this.hu;
    }

    public void qg(float f) {
        this.py = f;
    }

    public float hu() {
        return this.py;
    }
}
