package com.byazt.wy;

import com.byazt.wy.hn;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1595, 121})
public class x<T extends hn> {
    public BlockingQueue<T> hw = new LinkedBlockingQueue();
    public int pr;

    public static x pr(int i) {
        return new x(i);
    }

    private x(int i) {
        this.pr = i;
    }

    public T pr() {
        return this.hw.poll();
    }

    public int hw() {
        return this.hw.size();
    }

    public boolean pr(T t) {
        if (t == null) {
            return false;
        }
        t.pr();
        if (this.hw.size() >= this.pr) {
            return false;
        }
        return this.hw.offer(t);
    }
}
