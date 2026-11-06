package com.byazt.udb;

import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1064, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa {
    public int a;
    public String ae;
    public View an;
    public JSONObject bb;
    public int cd;
    public long cp;
    public boolean cy;
    public int d;
    public int f;
    public boolean fi;
    public String fs;
    public boolean h;
    public String hd;
    public int hu;
    public boolean j;
    public int k;
    public int l;
    public String lh;
    public boolean ln;
    public double m;
    public JSONObject n;
    public String oa;
    public int ou;
    public int py;
    public rv q;
    public l qg;
    public boolean rv;
    public String s;
    public Map<String, String> sz;
    public JSONObject t;
    public int tj;
    public int um;
    public JSONObject ur;
    public final boolean v;
    public String w;
    public String wm;
    public String x;

    public oa(n nVar) {
        this.j = true;
        this.n = nVar.n;
        this.qg = nVar.qg;
        this.s = nVar.s;
        this.q = nVar.q;
        this.l = nVar.l;
        this.w = nVar.w;
        this.x = nVar.x;
        this.fs = nVar.fs;
        this.rv = nVar.rv;
        this.tj = nVar.tj;
        this.cp = nVar.cp;
        this.d = nVar.d;
        this.oa = nVar.oa;
        this.sz = nVar.sz;
        this.k = nVar.k;
        this.cy = nVar.cy;
        this.hd = nVar.hd;
        this.cd = nVar.cd;
        this.um = nVar.um;
        this.a = nVar.a;
        this.py = nVar.py;
        this.ou = nVar.ou;
        this.wm = nVar.wm;
        this.m = nVar.m;
        this.hu = nVar.hu;
        this.h = nVar.h;
        this.t = nVar.t;
        this.ur = nVar.ur;
        this.bb = nVar.bb;
        this.ln = nVar.ln;
        this.lh = nVar.lh;
        this.v = nVar.v;
        this.j = nVar.j;
        this.f = nVar.an;
        this.ae = nVar.f;
        this.an = nVar.ae;
        this.fi = nVar.fi;
    }

    public String n() {
        return this.ae;
    }

    public View qg() {
        return this.an;
    }

    public boolean s() {
        return this.h;
    }

    public double q() {
        return this.m;
    }

    public JSONObject l() {
        l lVar;
        if (this.n == null && (lVar = this.qg) != null) {
            this.n = lVar.n();
        }
        return this.n;
    }

    public String w() {
        return this.s;
    }

    public rv x() {
        return this.q;
    }

    public int fs() {
        return this.l;
    }

    public boolean rv() {
        return this.j;
    }

    public boolean tj() {
        return this.rv;
    }

    public long cp() {
        return this.cp;
    }

    public int d() {
        return this.d;
    }

    public Map<String, String> oa() {
        return this.sz;
    }

    public int sz() {
        return this.k;
    }

    public boolean k() {
        return this.cy;
    }

    public String cy() {
        return this.hd;
    }

    public void n(int i) {
        this.l = i;
    }

    public int hd() {
        return this.cd;
    }

    public int cd() {
        return this.um;
    }

    public int um() {
        return this.a;
    }

    public JSONObject a() {
        return this.t;
    }

    public JSONObject py() {
        return this.ur;
    }

    public JSONObject ou() {
        return this.bb;
    }

    public int wm() {
        return this.py;
    }

    public int m() {
        return this.ou;
    }

    public boolean hu() {
        return this.ln;
    }

    public String h() {
        return this.lh;
    }

    public boolean t() {
        return this.v;
    }

    public int ur() {
        return this.f;
    }

    public boolean bb() {
        return this.fi;
    }

    @com.byazt.cp.n(n = {0, 1, 1064, TTAdConstant.IMAGE_URL_CODE})
    public static class n {
        public int a;
        public View ae;
        public int an;
        public JSONObject bb;
        public int cd;
        public long cp;
        public boolean cy;
        public int d;
        public String f;
        public String fs;
        public String hd;
        public int hu;
        public int k;
        public int l;
        public String lh;
        public boolean ln;
        public double m;
        public JSONObject n;
        public String oa;
        public int ou;
        public int py;
        public rv q;
        public l qg;
        public boolean rv;
        public String s;
        public Map<String, String> sz;
        public JSONObject t;
        public int tj;
        public int um;
        public JSONObject ur;
        public String w;
        public String wm;
        public String x;
        public boolean h = true;
        public boolean v = true;
        public boolean j = true;
        public boolean fi = false;

        public n n(boolean z) {
            this.j = z;
            return this;
        }

        public n n(JSONObject jSONObject) {
            this.n = jSONObject;
            return this;
        }

        public n n(String str) {
            this.s = str;
            return this;
        }

        public n n(rv rvVar) {
            this.q = rvVar;
            return this;
        }

        public n n(int i) {
            this.l = i;
            return this;
        }

        public n qg(String str) {
            this.w = str;
            return this;
        }

        public n s(String str) {
            this.x = str;
            return this;
        }

        public n q(String str) {
            this.fs = str;
            return this;
        }

        public n qg(boolean z) {
            this.rv = z;
            return this;
        }

        public n qg(int i) {
            this.tj = i;
            return this;
        }

        public n s(int i) {
            this.d = i;
            return this;
        }

        public n l(String str) {
            this.oa = str;
            return this;
        }

        public n n(Map<String, String> map) {
            this.sz = map;
            return this;
        }

        public n q(int i) {
            this.k = i;
            return this;
        }

        public n w(String str) {
            this.hd = str;
            return this;
        }

        public n l(int i) {
            this.cd = i;
            return this;
        }

        public n w(int i) {
            this.um = i;
            return this;
        }

        public n x(int i) {
            this.a = i;
            return this;
        }

        public n fs(int i) {
            this.py = i;
            return this;
        }

        public n rv(int i) {
            this.ou = i;
            return this;
        }

        public n x(String str) {
            this.wm = str;
            return this;
        }

        public n s(boolean z) {
            this.ln = z;
            return this;
        }

        public n fs(String str) {
            this.lh = str;
            return this;
        }

        public n tj(int i) {
            this.an = i;
            return this;
        }

        public oa n() {
            return new oa(this);
        }

        public n qg(JSONObject jSONObject) {
            this.t = jSONObject;
            return this;
        }

        public n s(JSONObject jSONObject) {
            this.ur = jSONObject;
            return this;
        }

        public n q(JSONObject jSONObject) {
            this.bb = jSONObject;
            return this;
        }

        public n rv(String str) {
            this.f = str;
            return this;
        }

        public n n(View view) {
            this.ae = view;
            return this;
        }

        public n q(boolean z) {
            this.fi = z;
            return this;
        }
    }
}
