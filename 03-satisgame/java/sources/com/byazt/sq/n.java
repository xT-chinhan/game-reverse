package com.byazt.sq;

import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1265, 19})
public class n {
    public static volatile n n;
    public final Queue<Long> q = new LinkedList();
    public long qg;
    public long s;

    private n() {
    }

    public static n n() {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    n = new n();
                }
            }
        }
        return n;
    }

    public void n(long j, long j2) {
        synchronized (n.class) {
            if (this.qg != j || this.s != j2) {
                this.qg = j;
                this.s = j2;
                this.q.clear();
            }
        }
    }

    public boolean qg() {
        synchronized (n.class) {
            if (this.qg > 0 && this.s > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (this.q.size() >= this.qg) {
                    while (this.q.size() > this.qg) {
                        this.q.poll();
                    }
                    if (Math.abs(jCurrentTimeMillis - this.q.peek().longValue()) <= this.s) {
                        return true;
                    }
                    this.q.poll();
                    this.q.offer(Long.valueOf(jCurrentTimeMillis));
                } else {
                    this.q.offer(Long.valueOf(jCurrentTimeMillis));
                }
                return false;
            }
            return false;
        }
    }
}
