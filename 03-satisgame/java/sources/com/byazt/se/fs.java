package com.byazt.se;

import com.byazt.gct.pk;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1270, 101})
public class fs extends n {
    public Map<String, String> cp;
    public String cy;
    public String d;
    public long fs;
    public long hd;
    public com.byazt.fvm.qg k;
    public boolean oa;
    public com.byazt.qdx.qg q;
    public long rv;
    public boolean sz;
    public long tj;
    public boolean l = false;
    public boolean w = false;
    public boolean x = false;
    public AtomicBoolean cd = new AtomicBoolean(false);

    @Override // com.byazt.se.n
    public int n() {
        return this.n;
    }

    @Override // com.byazt.se.n
    public void n(int i) {
        this.n = i;
    }

    @Override // com.byazt.se.n
    public pk qg() {
        return this.qg;
    }

    @Override // com.byazt.se.n
    public void n(pk pkVar) {
        this.qg = pkVar;
    }

    public fs(pk pkVar, boolean z) {
        this.qg = pkVar;
        this.oa = z;
    }

    public fs(com.byazt.qdx.qg qgVar, pk pkVar, boolean z) {
        this.q = qgVar;
        this.qg = pkVar;
        this.oa = z;
    }

    public com.byazt.qdx.qg q() {
        return this.q;
    }

    public boolean l() {
        return this.l;
    }

    public void n(boolean z) {
        this.l = z;
    }

    public boolean w() {
        return this.w;
    }

    public void qg(boolean z) {
        this.w = z;
    }

    public long x() {
        return this.fs;
    }

    public void qg(long j) {
        this.fs = j;
    }

    public void s(long j) {
        this.rv = j;
    }

    public long fs() {
        return this.tj;
    }

    public void q(long j) {
        this.tj = j;
    }

    public Map<String, String> rv() {
        return this.cp;
    }

    public void n(Map<String, String> map) {
        this.cp = map;
    }

    public boolean tj() {
        return this.x;
    }

    public void s(boolean z) {
        this.x = z;
    }

    public void n(String str) {
        this.d = str;
    }

    public boolean cp() {
        return this.oa;
    }

    public void q(boolean z) {
        this.sz = z;
    }

    public com.byazt.fvm.qg d() {
        return this.k;
    }

    public void n(com.byazt.fvm.qg qgVar) {
        this.k = qgVar;
    }

    public String oa() {
        return this.cy;
    }

    public void qg(String str) {
        this.cy = str;
    }

    public long sz() {
        return this.hd;
    }

    public void l(long j) {
        this.hd = j;
    }

    public boolean k() {
        return this.cd.get();
    }

    public void l(boolean z) {
        this.cd.set(z);
    }
}
