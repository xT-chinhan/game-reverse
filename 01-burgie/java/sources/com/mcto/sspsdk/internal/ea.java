package com.mcto.sspsdk.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.bykv.vk.component.ttvideo.player.C;
import com.mcto.sspsdk.IQyFullScreenAd;
import com.mcto.sspsdk.QyAdSlot;
import com.mcto.sspsdk.component.imageview.QYNiceImageView;
import com.mcto.sspsdk.ssp.fullscreen.QyFullActivity;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ea implements IQyFullScreenAd {
    public final Context a;
    public final p b;
    public final QyAdSlot c;
    public final m d;
    public float e;
    public QYNiceImageView f;
    public boolean g = false;

    public ea(p pVar, QyAdSlot qyAdSlot, Context context, m mVar) {
        this.a = context;
        this.b = pVar;
        this.d = mVar;
        this.c = qyAdSlot;
        int iOptInt = pVar.H.optInt("width", 0);
        int iOptInt2 = pVar.H.optInt("height", 0);
        this.e = (iOptInt <= 0 || iOptInt2 <= 0) ? pVar.R == 2 ? 0.5625f : 1.7777778f : (iOptInt * 1.0f) / iOptInt2;
    }

    @Override // com.mcto.sspsdk.IQyFullScreenAd
    public void destroy() {
    }

    @Override // com.mcto.sspsdk.IQyFullScreenAd, com.mcto.sspsdk.internal.l7
    public final Map getAdExtra() {
        return this.b.j();
    }

    @Override // com.mcto.sspsdk.IQyFullScreenAd
    public final boolean isValid() {
        return this.b.E0 >= System.currentTimeMillis();
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
        this.d.b = adInteractionListener;
    }

    @Override // com.mcto.sspsdk.IQyFullScreenAd
    public final void showAd(Activity activity) {
        if (this.g) {
            this.d.a("has been exposed");
            return;
        }
        if (this.f == null) {
            this.d.a("view is null");
            return;
        }
        og.a.set(this);
        Intent intent = new Intent(this.a, (Class<?>) QyFullActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        this.a.startActivity(intent);
        this.g = true;
        p9.a.a(Integer.valueOf(this.b.a), "renderTrueView()");
    }

    @Override // com.mcto.sspsdk.IQyFullScreenAd
    public final void win(Map map) {
        this.b.b(map);
    }
}
