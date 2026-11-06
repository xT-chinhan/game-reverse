package com.byazt.mj;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1480, 26})
public class qg {
    public int l;
    public String n;
    public String q;
    public String qg;
    public String s;
    public String w;

    public String n() {
        return this.q;
    }

    public qg n(String str) {
        this.q = str;
        return this;
    }

    public String qg() {
        return this.n;
    }

    public qg qg(String str) {
        this.n = str;
        return this;
    }

    public String s() {
        return this.qg;
    }

    public qg s(String str) {
        this.qg = str;
        return this;
    }

    public String q() {
        return this.s;
    }

    public qg q(String str) {
        this.s = str;
        return this;
    }

    public int l() {
        return this.l;
    }

    public qg n(int i) {
        this.l = i;
        return this;
    }

    public String w() {
        return this.w;
    }

    public qg l(String str) {
        this.w = str;
        return this;
    }

    public String toString() {
        return "{mediationRit='" + this.n + "', adnName='" + this.qg + "', customAdnName='" + this.s + "', adType='" + this.q + "', errCode=" + this.l + ", errMsg=" + this.w + AbstractJsonLexerKt.END_OBJ;
    }
}
