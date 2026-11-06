package com.byazt.zsl;

import android.os.Build;
import android.text.TextUtils;
import com.byazt.ej.k;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 469, 18})
public class l implements k, Serializable {
    public int a;
    public boolean cd;
    public String cp;
    public long cy;
    public int d;
    public boolean hd;
    public String k;
    public com.byazt.ej.l l;
    public String n;
    public int oa;
    public int py;
    public com.byazt.ej.l q;
    public int qg;
    public List<String> sz;
    public String w;
    public int x;
    public int fs = 204800;
    public int rv = 0;
    public int tj = 0;
    public long um = -1;
    public final HashMap<String, Object> s = new HashMap<>();
    public int ou = 10000;
    public int wm = 10000;
    public int m = 10000;
    public int hu = 0;
    public JSONObject h = new JSONObject();

    public l(String str, com.byazt.ej.l lVar, com.byazt.ej.l lVar2, int i, int i2) {
        this.a = 0;
        this.py = 0;
        this.w = str;
        this.q = lVar;
        this.l = lVar2;
        this.a = i;
        this.py = i2;
    }

    @Override // com.byazt.ej.k
    public JSONObject n() {
        return this.h;
    }

    @Override // com.byazt.ej.k
    public int qg() {
        return this.h.optInt("pitaya_cache_size", 0);
    }

    @Override // com.byazt.ej.k
    public int s() {
        return this.h.optInt("pitaya_code", 0);
    }

    @Override // com.byazt.ej.k
    public String q() {
        return this.h.optString("pitaya_msg");
    }

    @Override // com.byazt.ej.k
    public String l() {
        return this.w;
    }

    @Override // com.byazt.ej.k
    public void n(String str) {
        this.w = str;
    }

    @Override // com.byazt.ej.k
    public int w() {
        return this.x;
    }

    @Override // com.byazt.ej.k
    public void n(int i) {
        this.x = i;
    }

    @Override // com.byazt.ej.k
    public int x() {
        if (a()) {
            return this.l.cy();
        }
        com.byazt.ej.l lVar = this.q;
        if (lVar != null) {
            return lVar.cy();
        }
        return 0;
    }

    @Override // com.byazt.ej.k
    public boolean fs() {
        return this.cd;
    }

    @Override // com.byazt.ej.k
    public void n(boolean z) {
        this.cd = z;
    }

    @Override // com.byazt.ej.k
    public String rv() {
        return this.cp;
    }

    @Override // com.byazt.ej.k
    public void qg(String str) {
        this.cp = str;
    }

    @Override // com.byazt.ej.k
    public int tj() {
        return this.d;
    }

    @Override // com.byazt.ej.k
    public void qg(int i) {
        this.d = i;
    }

    @Override // com.byazt.ej.k
    public int cp() {
        return this.oa;
    }

    @Override // com.byazt.ej.k
    public void s(int i) {
        this.oa = i;
    }

    @Override // com.byazt.ej.k
    public List<String> d() {
        return this.sz;
    }

    @Override // com.byazt.ej.k
    public void n(List<String> list) {
        this.sz = list;
    }

    @Override // com.byazt.ej.k
    public String oa() {
        return this.k;
    }

    @Override // com.byazt.ej.k
    public void s(String str) {
        this.k = str;
    }

    @Override // com.byazt.ej.k
    public long sz() {
        return this.cy;
    }

    @Override // com.byazt.ej.k
    public void n(long j) {
        this.cy = j;
    }

    @Override // com.byazt.ej.k
    public boolean k() {
        return this.hd;
    }

    @Override // com.byazt.ej.k
    public void qg(boolean z) {
        this.hd = z;
    }

    @Override // com.byazt.ej.k
    public long cy() {
        if (a()) {
            return this.l.l();
        }
        com.byazt.ej.l lVar = this.q;
        if (lVar != null) {
            return lVar.l();
        }
        return 0L;
    }

    @Override // com.byazt.ej.k
    public boolean hd() {
        if (a()) {
            return this.l.wm();
        }
        com.byazt.ej.l lVar = this.q;
        if (lVar != null) {
            return lVar.wm();
        }
        return true;
    }

    @Override // com.byazt.ej.k
    public String cd() {
        return this.n;
    }

    @Override // com.byazt.ej.k
    public void q(String str) {
        this.n = str;
    }

    @Override // com.byazt.ej.k
    public int um() {
        return this.qg;
    }

    @Override // com.byazt.ej.k
    public void q(int i) {
        this.qg = i;
    }

    @Override // com.byazt.ej.k
    public boolean a() {
        com.byazt.ej.l lVar;
        if (this.py == 1 && (lVar = this.l) != null && !TextUtils.isEmpty(lVar.d())) {
            if (com.byazt.iza.qg.l() == 2) {
                if (Build.VERSION.SDK_INT >= 26) {
                    return true;
                }
            } else if (this.a == 1) {
                return true;
            }
        }
        return false;
    }

    @Override // com.byazt.ej.k
    public float py() {
        if (a()) {
            return this.l.fs();
        }
        com.byazt.ej.l lVar = this.q;
        if (lVar != null) {
            return lVar.fs();
        }
        return -1.0f;
    }

    @Override // com.byazt.ej.k
    public String ou() {
        if (a()) {
            return this.l.d();
        }
        com.byazt.ej.l lVar = this.q;
        if (lVar != null) {
            return lVar.d();
        }
        return null;
    }

    @Override // com.byazt.ej.k
    public String wm() {
        if (a()) {
            return this.l.k();
        }
        com.byazt.ej.l lVar = this.q;
        if (lVar != null) {
            return lVar.k();
        }
        return null;
    }

    @Override // com.byazt.ej.k
    public int m() {
        return this.a;
    }

    @Override // com.byazt.ej.k
    public void l(int i) {
        this.a = i;
    }

    @Override // com.byazt.ej.k
    public synchronized void n(String str, Object obj) {
        this.s.put(str, obj);
    }

    @Override // com.byazt.ej.k
    public synchronized Object l(String str) {
        return this.s.get(str);
    }

    @Override // com.byazt.ej.k
    public Object w(String str) {
        return this.s.remove(str);
    }

    @Override // com.byazt.ej.k
    public int hu() {
        return this.ou;
    }

    @Override // com.byazt.ej.k
    public void w(int i) {
        this.ou = i;
    }

    @Override // com.byazt.ej.k
    public int h() {
        return this.wm;
    }

    @Override // com.byazt.ej.k
    public void x(int i) {
        this.wm = i;
    }

    @Override // com.byazt.ej.k
    public int t() {
        return this.m;
    }

    @Override // com.byazt.ej.k
    public void fs(int i) {
        this.m = i;
    }

    @Override // com.byazt.ej.k
    public int ur() {
        return this.hu;
    }

    @Override // com.byazt.ej.k
    public void rv(int i) {
        this.hu = i;
    }

    @Override // com.byazt.ej.k
    public int bb() {
        return this.py;
    }

    @Override // com.byazt.ej.k
    public void tj(int i) {
        this.py = i;
    }

    @Override // com.byazt.ej.k
    public com.byazt.ej.l ln() {
        return this.q;
    }

    @Override // com.byazt.ej.k
    public void n(com.byazt.ej.l lVar) {
        this.q = lVar;
    }

    @Override // com.byazt.ej.k
    public com.byazt.ej.l lh() {
        return this.l;
    }

    @Override // com.byazt.ej.k
    public com.byazt.ej.l v() {
        if (a()) {
            return this.l;
        }
        com.byazt.ej.l lVar = this.q;
        if (lVar != null) {
            return lVar;
        }
        return null;
    }

    @Override // com.byazt.ej.k
    public void qg(com.byazt.ej.l lVar) {
        this.l = lVar;
    }
}
