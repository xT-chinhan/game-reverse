package com.byazt.gdj;

import android.text.TextUtils;
import com.byazt.tk.k;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2284, 18})
public class l {
    public List<n> fs;
    public x l;
    public String n;
    public String q;
    public String qg;
    public List<s> rv;
    public String s;
    public boolean tj;
    public float w;
    public List<n> x;

    public String n() {
        return this.n;
    }

    public void n(String str) {
        this.n = str;
    }

    public void qg(String str) {
        this.qg = str;
    }

    public String qg() {
        return this.s;
    }

    public void s(String str) {
        this.s = str;
    }

    public String s() {
        return this.q;
    }

    public void q(String str) {
        this.q = str;
    }

    public x q() {
        return this.l;
    }

    public void n(x xVar) {
        this.l = xVar;
    }

    public void n(float f) {
        this.w = f;
    }

    public List<n> l() {
        return this.x;
    }

    public void n(List<n> list) {
        this.x = list;
    }

    public List<n> w() {
        return this.fs;
    }

    public void qg(List<n> list) {
        this.fs = list;
    }

    public List<s> x() {
        return this.rv;
    }

    public void s(List<s> list) {
        this.rv = list;
    }

    public boolean fs() {
        return this.tj;
    }

    public void n(boolean z) {
        this.tj = z;
    }

    public boolean n(JSONObject jSONObject) {
        String strQg = qg();
        if (TextUtils.isEmpty(strQg)) {
            return true;
        }
        try {
            Object objN = com.byazt.sz.n.n(com.byazt.rm.q.n(strQg)).n(jSONObject);
            return objN != null && Boolean.TRUE.equals(objN);
        } catch (Exception e) {
            k.n("TTFeatureRule", "匹配过滤器失败: ".concat(String.valueOf(strQg)), e);
            return false;
        }
    }
}
