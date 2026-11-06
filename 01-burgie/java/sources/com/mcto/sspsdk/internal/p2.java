package com.mcto.sspsdk.internal;

import android.content.Context;
import android.view.View;
import com.mcto.sspsdk.IQyNativeAd;
import com.mcto.sspsdk.QyAdSlot;
import com.mcto.sspsdk.QyVideoPlayOption;
import com.mcto.sspsdk.component.imageview.QYNiceImageView;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class p2 extends n3 {
    public p2(Context context, QyAdSlot qyAdSlot, p pVar) {
        super(context, qyAdSlot, pVar);
        if (!pVar.o() || qyAdSlot.getQyVideoPlayOption() == QyVideoPlayOption.MANUAL) {
            QYNiceImageView qYNiceImageView = new QYNiceImageView(context);
            qYNiceImageView.a(new n2(this));
            qYNiceImageView.a(pVar.o() ? pVar.h() : pVar.G);
            this.c = qYNiceImageView;
            return;
        }
        Context context2 = this.a;
        p pVar2 = this.d;
        QyAdSlot qyAdSlot2 = this.b;
        if (this.r == null) {
            this.r = new l3(this);
        }
        this.c = gf.a(context2, pVar2, qyAdSlot2, false, false, 1.0f, this.r);
    }

    @Override // com.mcto.sspsdk.internal.n3, com.mcto.sspsdk.IQyNativeAd
    public final void destroy() {
        super.destroy();
        if (this.d.o()) {
            View view = this.c;
            if (view instanceof gf) {
                ((gf) view).b();
            }
        }
    }

    @Override // com.mcto.sspsdk.internal.n3, com.mcto.sspsdk.IQyNativeAd
    public final void setMute(boolean z) {
        View view = this.c;
        if (view instanceof gf) {
            ((gf) view).a(z);
        }
    }

    @Override // com.mcto.sspsdk.internal.n3
    public final void a() {
        if ((this.i & 1) == 0 || this.d.m()) {
            return;
        }
        HashMap map = new HashMap(4);
        map.put(v5.KEY_VIEW_COORDINATE, this.k.d);
        map.put(v5.KEY_TOKEN_VIEW_COORDINATE, gj.a(this.h));
        v5 v5Var = v5.KEY_AD_VIEW_RECT;
        d8 d8Var = this.k;
        map.put(v5Var, d8Var.e + "_" + d8Var.f);
        map.put(v5.KEY_IMPRESSION_INTERVAL_TIME, Long.valueOf(System.currentTimeMillis() - this.k.g));
        l lVarA = l.a();
        p pVar = this.d;
        lVarA.getClass();
        l.a(12, pVar, map);
        IQyNativeAd.IQyNativeAdInteractionListener iQyNativeAdInteractionListener = this.o;
        if (iQyNativeAdInteractionListener != null) {
            iQyNativeAdInteractionListener.onAdShow(this);
        }
    }

    @Override // com.mcto.sspsdk.internal.n3
    public final void a(View view) {
        pd pdVar = new pd(this.a);
        pdVar.c = new o2(this, view);
        pdVar.a(view);
    }
}
