package com.byazt.nr;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1357, 5})
public class q implements Runnable {
    public final s qg;
    public volatile boolean s = false;
    public Runnable q = new Runnable() { // from class: com.byazt.nr.q.1
        @Override // java.lang.Runnable
        public void run() {
            q.this.s = false;
        }
    };
    public long n = n();

    public q(s sVar) {
        this.qg = sVar;
        com.byazt.qi.w.n(2L);
        com.byazt.qi.l.n().n(4500L, this.q);
        com.byazt.qi.l.n().n(5000L, this, 40, 5000L);
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        int i;
        if (this.s) {
            return;
        }
        if (qg()) {
            i = 200;
            str = "/data/anr/traces.txt";
        } else {
            str = null;
            i = 100;
        }
        if (this.qg.n(i, str, 25)) {
            this.s = true;
        }
    }

    private long n() {
        File file = new File("/data/anr/traces.txt");
        if (file.exists()) {
            return file.lastModified();
        }
        return 0L;
    }

    private boolean qg() {
        File file = new File("/data/anr/traces.txt");
        return file.exists() && file.canRead();
    }
}
