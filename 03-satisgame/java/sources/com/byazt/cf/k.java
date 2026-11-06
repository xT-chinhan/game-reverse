package com.byazt.cf;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 93, 210})
public final class k {
    public final String fs;
    public final String l;
    public final int n;
    public final String q;
    public final String qg;
    public final String s;
    public final String w;
    public final String x;

    public static n n() {
        return new n();
    }

    public static k n(String str, int i) {
        return new k(str, i);
    }

    private k(String str, int i) {
        this.qg = null;
        this.s = null;
        this.q = null;
        this.l = null;
        this.w = str;
        this.x = null;
        this.n = i;
        this.fs = null;
    }

    private k(n nVar) {
        this.qg = nVar.n;
        this.s = nVar.qg;
        this.q = nVar.s;
        this.l = nVar.q;
        this.w = nVar.l;
        this.x = nVar.w;
        this.n = 1;
        this.fs = nVar.x;
    }

    public static boolean n(k kVar) {
        return kVar == null || kVar.n != 1 || TextUtils.isEmpty(kVar.q) || TextUtils.isEmpty(kVar.l);
    }

    public String toString() {
        return "methodName: " + this.q + ", params: " + this.l + ", callbackId: " + this.w + ", type: " + this.s + ", version: " + this.qg + ", ";
    }

    @com.byazt.cp.n(n = {0, 1, 93, 116})
    public static final class n {
        public String l;
        public String n;
        public String q;
        public String qg;
        public String s;
        public String w;
        public String x;

        private n() {
        }

        public n n(String str) {
            this.n = str;
            return this;
        }

        public n qg(String str) {
            this.qg = str;
            return this;
        }

        public n s(String str) {
            this.s = str;
            return this;
        }

        public n q(String str) {
            this.q = str;
            return this;
        }

        public n l(String str) {
            this.l = str;
            return this;
        }

        public n w(String str) {
            this.w = str;
            return this;
        }

        public n x(String str) {
            this.x = str;
            return this;
        }

        public k n() {
            return new k(this);
        }
    }
}
