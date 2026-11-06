package com.mcto.sspsdk.internal;

import android.app.Activity;
import com.mcto.sspsdk.IQyFullScreenAd;
import com.mcto.unionsdk.QiAd;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class tj implements IQyFullScreenAd {
    public QiAd a;
    public final p b;
    public IQyFullScreenAd.AdInteractionListener c;

    public tj(p pVar, QiAd qiAd) {
        this.b = pVar;
        this.a = qiAd;
        qiAd.setInteractionListener(new sj(this));
    }

    @Override // com.mcto.sspsdk.IQyFullScreenAd
    public final void destroy() {
        QiAd qiAd = this.a;
        if (qiAd != null) {
            qiAd.destroy();
            this.a = null;
        }
    }

    @Override // com.mcto.sspsdk.IQyFullScreenAd, com.mcto.sspsdk.internal.l7
    public final Map getAdExtra() {
        return this.b.j();
    }

    @Override // com.mcto.sspsdk.IQyFullScreenAd
    public final boolean isValid() {
        p pVar = this.b;
        if (pVar.g == 5) {
            return this.a != null && pVar.E0 >= System.currentTimeMillis();
        }
        QiAd qiAd = this.a;
        return qiAd != null && qiAd.isValid();
    }

    @Override // com.mcto.sspsdk.IQyFullScreenAd, com.mcto.sspsdk.internal.l7
    public final void loss(Map map) {
        this.b.a(map);
        l lVarA = l.a();
        p pVar = this.b;
        lVarA.getClass();
        l.a(0, pVar);
    }

    @Override // com.mcto.sspsdk.IQyFullScreenAd
    public final void setAdInteractionListener(IQyFullScreenAd.AdInteractionListener adInteractionListener) {
        this.c = adInteractionListener;
    }

    @Override // com.mcto.sspsdk.IQyFullScreenAd
    public final void showAd(Activity activity) {
        this.a.show(activity);
    }

    @Override // com.mcto.sspsdk.IQyFullScreenAd
    public final void win(Map map) {
        this.b.b(map);
    }
}
