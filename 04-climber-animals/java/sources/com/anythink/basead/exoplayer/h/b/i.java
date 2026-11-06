package com.anythink.basead.exoplayer.h.b;

import com.anythink.basead.exoplayer.j.k;
import com.anythink.basead.exoplayer.m;

/* JADX INFO: loaded from: classes.dex */
public abstract class i extends c {
    public final long j;

    public abstract boolean f();

    public i(com.anythink.basead.exoplayer.j.h hVar, k kVar, m mVar, int i, Object obj, long j, long j2, long j3) {
        super(hVar, kVar, mVar, i, obj, j, j2);
        com.anythink.basead.exoplayer.k.a.a(mVar);
        this.j = j3;
    }

    public long e() {
        long j = this.j;
        if (j != -1) {
            return j + 1;
        }
        return -1L;
    }
}
