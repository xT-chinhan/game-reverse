package com.bytedance.sdk.component.ch.xr;

import com.bytedance.sdk.component.ch.xr.ah;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public class d<T extends ah> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f1228ms;
    private BlockingQueue<T> xr = new LinkedBlockingQueue();

    public static d ms(int i) {
        return new d(i);
    }

    private d(int i) {
        this.f1228ms = i;
    }

    public T ms() {
        return this.xr.poll();
    }

    public boolean ms(T t) {
        if (t == null) {
            return false;
        }
        t.ms();
        if (this.xr.size() >= this.f1228ms) {
            return false;
        }
        return this.xr.offer(t);
    }
}
