package com.mcto.sspsdk.internal;

import android.content.Context;
import com.mcto.sspsdk.QyAdSlot;
import com.mcto.unionsdk.QiNativeAd;

/* JADX INFO: loaded from: classes2.dex */
public final class fa extends ea {
    public QiNativeAd h;

    public fa(p pVar, QyAdSlot qyAdSlot, QiNativeAd qiNativeAd, Context context, o oVar) {
        super(pVar, qyAdSlot, context, oVar);
        this.h = qiNativeAd;
    }

    @Override // com.mcto.sspsdk.internal.ea, com.mcto.sspsdk.IQyFullScreenAd
    public final void destroy() {
        QiNativeAd qiNativeAd = this.h;
        if (qiNativeAd != null) {
            qiNativeAd.destroy();
            this.h = null;
        }
    }
}
