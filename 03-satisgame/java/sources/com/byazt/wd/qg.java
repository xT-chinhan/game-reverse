package com.byazt.wd;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 584, 26})
public abstract class qg {
    public static volatile boolean n;
    public static volatile long qg;
    public Handler q;
    public final Queue<n> s = new LinkedList();

    public abstract int qg();

    public abstract long s();

    private synchronized boolean qg(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iQg = qg();
        long jS = s();
        if (this.s.size() > 0 && this.s.size() >= iQg) {
            long jAbs = Math.abs(jCurrentTimeMillis - this.s.peek().n);
            if (jAbs <= jS) {
                qg(jS - jAbs);
                return true;
            }
            this.s.poll();
            this.s.offer(new n(jCurrentTimeMillis, str));
        } else {
            this.s.offer(new n(jCurrentTimeMillis, str));
        }
        return false;
    }

    public synchronized boolean n(String str) {
        if (qg(str)) {
            n(true);
            n(qg);
        } else {
            n(false);
        }
        return n;
    }

    private void n(long j) {
        if (this.q == null) {
            this.q = new Handler(Looper.getMainLooper());
        }
        this.q.postDelayed(new Runnable() { // from class: com.byazt.wd.qg.1
            @Override // java.lang.Runnable
            public void run() {
                qg.this.n(false);
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void n(boolean z) {
        n = z;
    }

    public boolean q() {
        return n;
    }

    private synchronized void qg(long j) {
        qg = j;
    }

    public synchronized String l() {
        String str;
        HashMap map = new HashMap();
        for (n nVar : this.s) {
            if (map.containsKey(nVar.qg)) {
                map.put(nVar.qg, Integer.valueOf(((Integer) map.get(nVar.qg)).intValue() + 1));
            } else {
                map.put(nVar.qg, 1);
            }
        }
        str = "";
        int i = Integer.MIN_VALUE;
        for (String str2 : map.keySet()) {
            int iIntValue = ((Integer) map.get(str2)).intValue();
            if (i < iIntValue) {
                str = str2;
                i = iIntValue;
            }
        }
        return str;
    }

    @com.byazt.cp.n(n = {0, 1, 584, 48})
    private static class n {
        public final long n;
        public final String qg;

        private n(long j, String str) {
            this.n = j;
            this.qg = str;
        }
    }
}
