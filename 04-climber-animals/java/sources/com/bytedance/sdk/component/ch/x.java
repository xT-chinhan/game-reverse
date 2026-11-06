package com.bytedance.sdk.component.ch;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes2.dex */
public class x<V> extends FutureTask<V> implements Comparable<x<V>> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f1227ms;
    private int xr;

    public x(Callable<V> callable, int i, int i2) {
        super(callable);
        this.f1227ms = i == -1 ? 5 : i;
        this.xr = i2;
    }

    public x(Runnable runnable, V v, int i, int i2) {
        super(runnable, v);
        this.f1227ms = i == -1 ? 5 : i;
        this.xr = i2;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public int compareTo(x xVar) {
        if (ms() < xVar.ms()) {
            return 1;
        }
        return ms() > xVar.ms() ? -1 : 0;
    }

    public int ms() {
        return this.f1227ms;
    }
}
