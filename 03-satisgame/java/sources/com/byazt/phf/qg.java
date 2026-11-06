package com.byazt.phf;

import android.os.Bundle;
import com.byazt.tbt.d;
import com.byazt.tbt.rv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1735, 26})
public class qg {
    public d n;
    public com.byazt.two.l qg;

    private qg(n nVar) {
        d.n nVarQg = new d.n().n(nVar.n, TimeUnit.MILLISECONDS).s(nVar.s, TimeUnit.MILLISECONDS).qg(nVar.qg, TimeUnit.MILLISECONDS);
        if (nVar.q) {
            com.byazt.two.l lVar = new com.byazt.two.l();
            this.qg = lVar;
            nVarQg.n(lVar);
        }
        nVarQg.n(new w());
        if (nVar.l != null && nVar.l.size() > 0) {
            Iterator<rv> it = nVar.l.iterator();
            while (it.hasNext()) {
                nVarQg.n(it.next());
            }
        }
        if (nVar.x != null) {
            nVarQg.n(nVar.x);
        }
        nVarQg.n(nVar.w);
        if (nVar.fs == null) {
            nVarQg.n(new com.byazt.hcw.qg());
        } else {
            nVarQg.n(nVar.fs);
        }
        this.n = nVarQg.n();
    }

    public d n() {
        return this.n;
    }

    @com.byazt.cp.n(n = {0, 1, 1735, 48})
    public static final class n {
        public com.byazt.hcw.n fs;
        public Set<String> w;
        public Bundle x;
        public boolean q = true;
        public final List<rv> l = new ArrayList();
        public int n = 10000;
        public int qg = 10000;
        public int s = 10000;

        public n n(long j, TimeUnit timeUnit) {
            this.n = n("timeout", j, timeUnit);
            return this;
        }

        public n qg(long j, TimeUnit timeUnit) {
            this.qg = n("timeout", j, timeUnit);
            return this;
        }

        public n s(long j, TimeUnit timeUnit) {
            this.s = n("timeout", j, timeUnit);
            return this;
        }

        public n n(boolean z) {
            this.q = z;
            return this;
        }

        public n n(rv rvVar) {
            this.l.add(rvVar);
            return this;
        }

        public n n(Bundle bundle) {
            this.x = bundle;
            return this;
        }

        public n n(Set<String> set) {
            this.w = set;
            return this;
        }

        private static int n(String str, long j, TimeUnit timeUnit) {
            if (j < 0) {
                throw new IllegalArgumentException(str + " < 0");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(str + " too large.");
            }
            if (millis != 0 || j <= 0) {
                return (int) millis;
            }
            throw new IllegalArgumentException(str + " too small.");
        }

        public qg n() {
            return new qg(this);
        }
    }
}
