package com.bytedance.sdk.component.ah.xr.ms.xr;

import com.bytedance.sdk.component.ah.xr.of;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Set<of> f1128ms = new LinkedHashSet();

    public synchronized void ms(of ofVar) {
        this.f1128ms.add(ofVar);
    }

    public synchronized void xr(of ofVar) {
        this.f1128ms.remove(ofVar);
    }

    public synchronized boolean ah(of ofVar) {
        return this.f1128ms.contains(ofVar);
    }
}
