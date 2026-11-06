package com.byazt.se;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1270, 21})
public class x extends n {
    public int cp;
    public boolean fs;
    public String l;
    public int q;
    public com.byazt.fvm.qg rv;
    public long tj;
    public boolean w;
    public int x;

    public x() {
        this.q = -1;
        this.l = "unknown";
        this.w = false;
        this.fs = false;
        this.cp = -1;
    }

    public x(int i, String str, boolean z) {
        this.w = false;
        this.cp = -1;
        this.q = i;
        this.l = str;
        this.fs = z;
    }

    public int q() {
        return this.q;
    }

    public void qg(int i) {
        this.q = i;
    }

    public void s(int i) {
        this.cp = i;
    }

    public String l() {
        return TextUtils.isEmpty(this.l) ? "unknown" : this.l;
    }

    public void n(String str) {
        this.l = str;
    }

    public boolean w() {
        return this.w;
    }

    public void n(boolean z) {
        this.w = z;
    }

    public int x() {
        return this.x;
    }

    public void q(int i) {
        this.x = i;
    }

    public boolean fs() {
        return this.fs;
    }

    public void qg(boolean z) {
        this.fs = z;
    }

    public com.byazt.fvm.qg rv() {
        return this.rv;
    }

    public void n(com.byazt.fvm.qg qgVar) {
        this.rv = qgVar;
    }

    @Override // com.byazt.se.n
    public long s() {
        return this.tj;
    }

    @Override // com.byazt.se.n
    public void n(long j) {
        this.tj = j;
    }
}
