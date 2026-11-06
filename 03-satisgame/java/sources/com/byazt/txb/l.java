package com.byazt.txb;

import com.byazt.txb.q;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 775, 18})
public class l<T extends q> {
    public int n;
    public BlockingQueue<T> qg = new LinkedBlockingQueue();

    public static l n(int i) {
        return new l(i);
    }

    private l(int i) {
        this.n = i;
    }

    public void qg(int i) {
        this.n = i;
    }

    public T n() {
        return this.qg.poll();
    }

    public int qg() {
        return this.qg.size();
    }

    public boolean n(T t) {
        if (t == null) {
            return false;
        }
        t.qg();
        if (this.qg.size() >= this.n) {
            return false;
        }
        return this.qg.offer(t);
    }
}
