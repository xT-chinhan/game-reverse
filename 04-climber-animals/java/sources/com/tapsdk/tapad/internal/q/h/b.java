package com.tapsdk.tapad.internal.q.h;

import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final int e = 5;
    public double b = 0.0d;
    private double c = 0.0d;
    private double d = 0.0d;
    private final Queue<com.tapsdk.tapad.internal.q.e.a> a = new LinkedList();

    private void a() {
        double d = 0.0d;
        for (com.tapsdk.tapad.internal.q.e.a aVar : this.a) {
            long j = aVar.k;
            long j2 = aVar.j;
            d += (j > j2 ? aVar.e / (j - j2) : 0L) * (aVar.e / this.d);
        }
        if (Double.isNaN(d)) {
            return;
        }
        this.b = d;
    }

    public synchronized void a(com.tapsdk.tapad.internal.q.e.a aVar) {
        if (aVar != null) {
            long j = aVar.k;
            long j2 = aVar.j;
            double d = j > j2 ? aVar.e / (j - j2) : 0L;
            if (d > this.c) {
                this.c = d;
            }
            this.a.add(aVar);
            this.d += aVar.e;
            if (this.a.size() > 5) {
                this.d -= this.a.poll().e;
            }
            a();
        }
    }
}
