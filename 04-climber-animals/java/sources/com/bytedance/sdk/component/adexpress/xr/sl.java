package com.bytedance.sdk.component.adexpress.xr;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class sl implements ch.ms {
    private ny ah;
    private AtomicBoolean d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    ub f996ms;
    private List<ch> xr;

    public sl(List<ch> list, ny nyVar) {
        this.xr = list;
        this.ah = nyVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ch.ms
    public void ms() {
        this.ah.c();
        Iterator<ch> it = this.xr.iterator();
        while (it.hasNext() && !it.next().ms(this)) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ch.ms
    public void ms(ch chVar) {
        int iIndexOf = this.xr.indexOf(chVar);
        if (iIndexOf < 0) {
            return;
        }
        do {
            iIndexOf++;
            if (iIndexOf >= this.xr.size()) {
                return;
            }
        } while (!this.xr.get(iIndexOf).ms(this));
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ch.ms
    public boolean xr(ch chVar) {
        int iIndexOf = this.xr.indexOf(chVar);
        return iIndexOf < this.xr.size() - 1 && iIndexOf >= 0;
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ch.ms
    public ub xr() {
        return this.f996ms;
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ch.ms
    public void ms(ub ubVar) {
        this.f996ms = ubVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ch.ms
    public void ms(boolean z) {
        this.d.getAndSet(z);
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ch.ms
    public boolean ah() {
        return this.d.get();
    }
}
