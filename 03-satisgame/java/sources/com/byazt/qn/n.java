package com.byazt.qn;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1998, 19})
public class n implements s {
    public String qg;
    public JSONObject rv;
    public int s;
    public String tj;
    public String w;
    public boolean x;
    public int q = 1;
    public int l = 0;
    public int n = 0;
    public int fs = 2;

    @Override // com.byazt.qn.s
    public String n() {
        return this.qg;
    }

    @Override // com.byazt.qn.s
    public void n(String str) {
        this.qg = str;
    }

    @Override // com.byazt.qn.s
    public void n(int i) {
        this.s = i;
    }

    @Override // com.byazt.qn.s
    public int qg() {
        return this.s;
    }

    @Override // com.byazt.qn.s
    public int s() {
        return this.q;
    }

    @Override // com.byazt.qn.s
    public void qg(int i) {
        this.q = i;
    }

    @Override // com.byazt.qn.s
    public void s(int i) {
        this.l = i;
    }

    @Override // com.byazt.qn.s
    public int q() {
        return this.l;
    }

    @Override // com.byazt.qn.s
    public int l() {
        return this.n;
    }

    @Override // com.byazt.qn.s
    public void q(int i) {
        this.n = i;
    }

    @Override // com.byazt.qn.s
    public String w() {
        return this.w;
    }

    @Override // com.byazt.qn.s
    public void qg(String str) {
        this.w = str;
    }

    @Override // com.byazt.qn.s
    public boolean x() {
        return this.x;
    }

    @Override // com.byazt.qn.s
    public void l(int i) {
        this.fs = i;
    }

    @Override // com.byazt.qn.s
    public int fs() {
        return this.fs;
    }

    @Override // com.byazt.qn.s
    public void n(JSONObject jSONObject) {
        this.rv = jSONObject;
    }

    @Override // com.byazt.qn.s
    public JSONObject rv() {
        return this.rv;
    }

    @Override // com.byazt.qn.s
    public void s(String str) {
        this.tj = str;
    }

    @Override // com.byazt.qn.s
    public String tj() {
        return this.tj;
    }
}
