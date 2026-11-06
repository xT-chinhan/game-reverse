package com.byazt.gp;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 80, 26})
public class qg {
    public int cd;
    public String cp;
    public String cy;
    public String d;
    public String fs;
    public String hd;
    public int k;
    public String l;
    public String n;
    public String oa;
    public String ou;
    public String q;
    public String qg;
    public String rv;
    public String s;
    public String sz;
    public long tj;
    public long um;
    public String w;
    public String x;
    public int a = -1;
    public int py = -1;
    public Map<String, Object> wm = new ConcurrentHashMap();
    public long m = -1;

    public qg n(int i) {
        this.sz = String.valueOf(i);
        return this;
    }

    public qg n(long j) {
        this.um = j;
        return this;
    }

    public qg n(String str) {
        this.n = str;
        return this;
    }

    public qg qg(String str) {
        this.rv = str;
        return this;
    }

    public qg qg(long j) {
        this.tj = j;
        return this;
    }

    public qg s(String str) {
        this.cp = str;
        return this;
    }

    public qg q(String str) {
        this.qg = str;
        return this;
    }

    public qg l(String str) {
        this.s = str;
        return this;
    }

    public qg w(String str) {
        this.q = str;
        return this;
    }

    public qg x(String str) {
        this.l = str;
        return this;
    }

    public qg fs(String str) {
        this.w = str;
        return this;
    }

    public qg rv(String str) {
        this.x = str;
        return this;
    }

    public qg tj(String str) {
        this.fs = str;
        return this;
    }

    public qg cp(String str) {
        this.d = str;
        return this;
    }

    public qg qg(int i) {
        this.k = i;
        return this;
    }

    public qg s(int i) {
        this.cy = String.valueOf(i);
        return this;
    }

    public qg q(int i) {
        this.hd = String.valueOf(i);
        return this;
    }

    public qg l(int i) {
        this.cd = i;
        return this;
    }

    public qg setResult(int i) {
        this.a = i;
        return this;
    }

    public qg w(int i) {
        this.py = i;
        return this;
    }

    public qg d(String str) {
        this.ou = str;
        return this;
    }

    public qg n(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.wm.put(str, obj);
        }
        return this;
    }

    public qg n(Map<String, Object> map) {
        if (map != null && map.size() > 0) {
            this.wm.putAll(map);
        }
        return this;
    }

    public qg s(long j) {
        this.m = j;
        return this;
    }

    public long n() {
        return this.m;
    }

    public static qg qg() {
        return new qg();
    }

    public static qg s() {
        qg qgVar = new qg();
        qgVar.s(System.currentTimeMillis());
        return qgVar;
    }
}
