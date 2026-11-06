package com.byazt.gdj;

import android.text.TextUtils;
import com.byazt.tk.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2284, 19})
public class n {
    public String cp;
    public boolean d = true;
    public String fs;
    public String l;
    public String n;
    public w q;
    public String qg;
    public String rv;
    public String s;
    public double tj;
    public q w;
    public String x;

    public String n() {
        return this.n;
    }

    public void n(String str) {
        this.n = str;
    }

    public String qg() {
        return this.qg;
    }

    public void qg(String str) {
        this.qg = str;
    }

    public String s() {
        return this.s;
    }

    public void s(String str) {
        this.s = str;
    }

    public w q() {
        return this.q;
    }

    public void n(w wVar) {
        this.q = wVar;
    }

    public String l() {
        return this.l;
    }

    public void q(String str) {
        this.l = str;
    }

    public q w() {
        return this.w;
    }

    public void n(q qVar) {
        this.w = qVar;
    }

    public String x() {
        return this.x;
    }

    public void l(String str) {
        this.x = str;
    }

    public String fs() {
        return this.fs;
    }

    public void w(String str) {
        this.fs = str;
    }

    public String rv() {
        return this.rv;
    }

    public void x(String str) {
        this.rv = str;
    }

    public double tj() {
        return this.tj;
    }

    public void n(double d) {
        this.tj = d;
    }

    public String cp() {
        return this.cp;
    }

    public void fs(String str) {
        this.cp = str;
    }

    public boolean d() {
        return this.d;
    }

    public void n(boolean z) {
        this.d = z;
    }

    public boolean n(JSONObject jSONObject) {
        String strL = l();
        if (TextUtils.isEmpty(strL)) {
            return true;
        }
        try {
            Object objN = com.byazt.sz.n.n(com.byazt.rm.q.n(strL)).n(jSONObject);
            return objN != null && Boolean.TRUE.equals(objN);
        } catch (Exception e) {
            k.n("TTFeatureAggregate", "匹配filter失败: ".concat(String.valueOf(strL)), e);
            return false;
        }
    }
}
