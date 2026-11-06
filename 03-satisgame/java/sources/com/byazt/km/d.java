package com.byazt.km;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 832, 113})
public class d {
    public final String l;
    public final String n;
    public final String q;
    public final String[] qg;
    public final String[] s;
    public final String w;
    public final String x;

    private d(n nVar) {
        this.n = nVar.n;
        this.qg = nVar.qg;
        this.s = nVar.s;
        this.q = nVar.q;
        this.l = nVar.l;
        this.w = nVar.w;
        this.x = nVar.x;
    }

    @com.byazt.cp.n(n = {0, 1, 832, 89})
    public static class n {
        public String l;
        public String n;
        public String q;
        public String[] qg;
        public String[] s;
        public String w;
        public String x;

        public n n(String str) {
            this.n = str;
            return this;
        }

        public n n(String[] strArr) {
            this.qg = strArr;
            return this;
        }

        public n qg(String[] strArr) {
            this.s = strArr;
            return this;
        }

        public n qg(String str) {
            this.q = str;
            return this;
        }

        public n s(String str) {
            this.l = str;
            return this;
        }

        public n q(String str) {
            this.x = str;
            return this;
        }

        public d n() {
            return new d(this);
        }
    }

    public String n() {
        return this.n;
    }

    public String[] qg() {
        return this.qg;
    }

    public String s() {
        return this.q;
    }

    public String q() {
        return this.l;
    }

    public static d n(int i) {
        return oa.n(i);
    }
}
