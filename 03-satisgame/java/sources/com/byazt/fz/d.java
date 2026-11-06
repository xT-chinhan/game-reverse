package com.byazt.fz;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2097, 113})
public class d {
    public final int cp;
    public final int d;
    public final int fs;
    public final int l;
    public final int n;
    public final int oa;
    public final int q;
    public final int qg;
    public final int rv;
    public final int s;
    public final Map<String, Integer> sz;
    public final int tj;
    public final int w;
    public final int x;

    @com.byazt.cp.n(n = {0, 1, 2097, 89})
    public static class n {
        public int cp;
        public int d;
        public int fs;
        public int l;
        public int n;
        public int oa;
        public int q;
        public int qg;
        public int rv;
        public int s;
        public Map<String, Integer> sz;
        public int tj;
        public int w;
        public int x;

        public n(int i) {
            this.sz = Collections.emptyMap();
            this.n = i;
            this.sz = new HashMap();
        }

        public n n(int i) {
            this.qg = i;
            return this;
        }

        public n qg(int i) {
            this.rv = i;
            return this;
        }

        public n s(int i) {
            this.tj = i;
            return this;
        }

        public n q(int i) {
            this.cp = i;
            return this;
        }

        public n l(int i) {
            this.d = i;
            return this;
        }

        public n w(int i) {
            this.w = i;
            return this;
        }

        public n x(int i) {
            this.fs = i;
            return this;
        }

        public n fs(int i) {
            this.x = i;
            return this;
        }

        public n rv(int i) {
            this.s = i;
            return this;
        }

        public n tj(int i) {
            this.q = i;
            return this;
        }

        public n cp(int i) {
            this.l = i;
            return this;
        }

        public n n(Map<String, Integer> map) {
            if (map != null) {
                this.sz = new HashMap(map);
            }
            return this;
        }

        public d n() {
            return new d(this);
        }
    }

    public d(n nVar) {
        this.n = nVar.n;
        this.qg = nVar.qg;
        this.s = nVar.s;
        this.q = nVar.q;
        this.l = nVar.l;
        this.w = nVar.w;
        this.x = nVar.x;
        this.fs = nVar.fs;
        this.sz = nVar.sz;
        this.rv = nVar.tj;
        this.tj = nVar.cp;
        this.cp = nVar.d;
        this.d = nVar.rv;
        this.oa = nVar.oa;
    }

    public static d n(com.byazt.he.q qVar) {
        if (qVar == null) {
            return null;
        }
        n nVar = new n(qVar.n());
        nVar.n(qVar.qg()).tj(qVar.q()).rv(qVar.s()).s(qVar.rv()).q(qVar.tj()).l(qVar.cp()).w(qVar.w()).fs(qVar.x()).cp(qVar.l()).qg(qVar.d()).x(qVar.fs()).n(qVar.oa());
        return nVar.n();
    }

    public static com.byazt.st.n n(d dVar) {
        if (dVar != null) {
            return new com.byazt.st.n(dVar);
        }
        return null;
    }
}
