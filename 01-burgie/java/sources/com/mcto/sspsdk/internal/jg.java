package com.mcto.sspsdk.internal;

import com.mcto.sspsdk.IQyRewardVideoAd;
import com.mcto.sspsdk.QyAdSlot;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class jg implements IQyRewardVideoAd {
    public final QyAdSlot a;
    public final p b;
    public final AtomicBoolean c = new AtomicBoolean(false);
    public IQyRewardVideoAd.IAdInteractionListener d;

    public jg(QyAdSlot qyAdSlot, p pVar) {
        this.b = pVar;
        this.a = qyAdSlot;
    }

    @Override // com.mcto.sspsdk.IQyRewardVideoAd, com.mcto.sspsdk.internal.l7
    public final Map getAdExtra() {
        p9.a.a(Integer.valueOf(this.b.a), "getAdExtra():", this.b.j());
        return this.b.j();
    }

    @Override // com.mcto.sspsdk.IQyRewardVideoAd
    public final int getAdId() {
        return this.b.a;
    }

    @Override // com.mcto.sspsdk.IQyRewardVideoAd, com.mcto.sspsdk.internal.l7
    public final void loss(Map map) {
        this.b.a(map);
        l lVarA = l.a();
        p pVar = this.b;
        lVarA.getClass();
        l.a(0, pVar);
    }

    @Override // com.mcto.sspsdk.IQyRewardVideoAd
    public final void setRewardVideoAdInteractionListener(IQyRewardVideoAd.IAdInteractionListener iAdInteractionListener) {
        this.d = iAdInteractionListener;
    }

    @Override // com.mcto.sspsdk.IQyRewardVideoAd
    public final void win(Map map) {
        this.b.b(map);
    }
}
