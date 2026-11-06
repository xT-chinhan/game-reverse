package com.byazt.phf;

import com.byazt.tbt.cp;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1735, 5})
public class q {
    public String d;
    public Throwable fs;
    public final long l;
    public final int n;
    public String oa;
    public final String q;
    public final String qg;
    public final Map<String, String> s;
    public final boolean tj;
    public final long w;
    public cp x;
    public File rv = null;
    public byte[] cp = null;

    public q(boolean z, int i, String str, Map<String, String> map, String str2, long j, long j2) {
        this.tj = z;
        this.n = i;
        this.qg = str;
        this.s = map;
        this.q = str2;
        this.l = j;
        this.w = j2;
    }

    public q(boolean z, int i, String str, Map<String, String> map, String str2, long j, long j2, Throwable th) {
        this.tj = z;
        this.n = i;
        this.qg = str;
        this.s = map;
        this.q = str2;
        this.l = j;
        this.w = j2;
        this.fs = th;
    }

    public Throwable n() {
        return this.fs;
    }

    public int qg() {
        return this.n;
    }

    public String s() {
        return this.qg;
    }

    public Map<String, String> q() {
        return this.s;
    }

    public String l() {
        return this.q;
    }

    public long w() {
        return this.l;
    }

    public long x() {
        return this.w;
    }

    public File fs() {
        return this.rv;
    }

    public void n(File file) {
        this.rv = file;
    }

    public boolean rv() {
        return this.tj;
    }

    public long tj() {
        return this.l - this.w;
    }

    public byte[] cp() {
        return this.cp;
    }

    public void n(byte[] bArr) {
        this.cp = bArr;
    }

    public cp d() {
        return this.x;
    }

    public void n(cp cpVar) {
        this.x = cpVar;
    }

    public String oa() {
        return this.d;
    }

    public void n(String str) {
        this.d = str;
    }

    public String sz() {
        return this.oa;
    }

    public void qg(String str) {
        this.oa = str;
    }
}
