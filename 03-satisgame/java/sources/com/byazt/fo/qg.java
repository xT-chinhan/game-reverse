package com.byazt.fo;

import com.byazt.km.cp;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1154, 26})
public abstract class qg {
    public final q n;
    public volatile boolean q;
    public int qg = 0;
    public boolean s;

    public abstract long n();

    public abstract String q();

    public abstract long[] qg();

    public abstract boolean s() throws JSONException;

    public qg(q qVar) {
        this.n = qVar;
    }

    public void l() {
        this.s = true;
    }

    public boolean w() {
        return this.s;
    }

    public final long x() {
        boolean zS;
        long jN = n();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.q) {
            this.q = false;
            jN = 0;
        }
        if (jN <= 1000 + jCurrentTimeMillis) {
            try {
                zS = s();
            } catch (Exception e) {
                cp.qg(e);
                zS = false;
            }
            if (zS) {
                this.qg = 0;
                jN = n();
                jCurrentTimeMillis = System.currentTimeMillis();
            } else {
                long[] jArrQg = qg();
                int i = this.qg;
                this.qg = i + 1;
                return jArrQg[i % jArrQg.length];
            }
        }
        return jN - jCurrentTimeMillis;
    }

    public void fs() {
        cp.n("setImmediately, " + q());
        this.q = true;
    }
}
