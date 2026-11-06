package com.byazt.tbt;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1089, 113})
public class d extends fs implements Cloneable {
    public static final List<oa> fs = com.byazt.equ.tj.n(oa.HTTP_2, oa.HTTP_1_1);
    public com.byazt.hcw.n cp;
    public TimeUnit l;
    public List<rv> n;
    public long q;
    public long qg;
    public List<oa> rv;
    public TimeUnit s;
    public Set<String> tj;
    public long w;
    public TimeUnit x;

    public q n() {
        return null;
    }

    public qg n(sz szVar) {
        return null;
    }

    public d() {
        this(new n());
    }

    public d(n nVar) {
        this.qg = nVar.s;
        this.q = nVar.l;
        this.w = nVar.x;
        this.s = nVar.q;
        this.l = nVar.w;
        this.x = nVar.fs;
        this.n = nVar.n;
        this.rv = nVar.rv;
        this.tj = nVar.tj;
        this.cp = nVar.qg;
    }

    @com.byazt.cp.n(n = {0, 1, 1089, 89})
    public static final class n {
        public Bundle cp;
        public TimeUnit fs;
        public long l;
        public final List<rv> n;
        public TimeUnit q;
        public com.byazt.hcw.n qg;
        public List<oa> rv;
        public long s;
        public Set<String> tj;
        public TimeUnit w;
        public long x;

        public n() {
            this.n = new ArrayList();
            this.s = 10000L;
            this.q = TimeUnit.MILLISECONDS;
            this.l = 10000L;
            this.w = TimeUnit.MILLISECONDS;
            this.x = 10000L;
            this.fs = TimeUnit.MILLISECONDS;
        }

        public n(String str) {
            this.n = new ArrayList();
            this.s = 10000L;
            this.q = TimeUnit.MILLISECONDS;
            this.l = 10000L;
            this.w = TimeUnit.MILLISECONDS;
            this.x = 10000L;
            this.fs = TimeUnit.MILLISECONDS;
            this.rv = d.fs;
        }

        public n(d dVar) {
            this.n = new ArrayList();
            this.s = 10000L;
            this.q = TimeUnit.MILLISECONDS;
            this.l = 10000L;
            this.w = TimeUnit.MILLISECONDS;
            this.x = 10000L;
            this.fs = TimeUnit.MILLISECONDS;
            this.s = dVar.qg;
            this.q = dVar.s;
            this.l = dVar.q;
            this.w = dVar.l;
            this.x = dVar.w;
            this.fs = dVar.x;
            this.rv = dVar.rv;
            this.tj = dVar.tj;
        }

        public n n(long j, TimeUnit timeUnit) {
            this.s = j;
            this.q = timeUnit;
            return this;
        }

        public n qg(long j, TimeUnit timeUnit) {
            this.l = j;
            this.w = timeUnit;
            return this;
        }

        public n s(long j, TimeUnit timeUnit) {
            this.x = j;
            this.fs = timeUnit;
            return this;
        }

        public n n(com.byazt.hcw.n nVar) {
            this.qg = nVar;
            return this;
        }

        public n n(rv rvVar) {
            this.n.add(rvVar);
            return this;
        }

        public n n(Set<String> set) {
            this.tj = set;
            return this;
        }

        public n n(List<oa> list) {
            ArrayList arrayList = new ArrayList(list);
            if (!arrayList.contains(oa.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols doesn't contain http/1.1: ".concat(String.valueOf(arrayList)));
            }
            if (arrayList.contains(oa.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: ".concat(String.valueOf(arrayList)));
            }
            if (arrayList.contains(null)) {
                throw new IllegalArgumentException("protocols must not contain null");
            }
            arrayList.remove(oa.SPDY_3);
            this.rv = Collections.unmodifiableList(arrayList);
            return this;
        }

        public n n(Bundle bundle) {
            this.cp = bundle;
            return this;
        }

        public d n() {
            if (com.byazt.ddg.n.n().qg()) {
                return com.byazt.ddg.n.qg(this);
            }
            return com.byazt.ddg.n.n(this);
        }
    }

    public n qg() {
        return new n(this);
    }
}
