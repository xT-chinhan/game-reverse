package com.mcto.sspsdk.internal;

import android.content.Context;
import android.view.View;
import com.mcto.sspsdk.QyAdSlot;
import com.mcto.sspsdk.component.button.DownloadButtonView;
import com.mcto.unionsdk.QiNativeAd;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class l2 extends z1 {
    public QiNativeAd j;

    public l2(Context context, p pVar, QiNativeAd qiNativeAd, QyAdSlot qyAdSlot) {
        super(context, qyAdSlot, pVar);
        this.j = qiNativeAd;
        k2 k2Var = new k2(this);
        y2 y2Var = this.b;
        y2Var.getClass();
        ArrayList arrayList = new ArrayList();
        arrayList.add(y2Var);
        View view = y2Var.n;
        if (view != null) {
            arrayList.add(view);
        }
        View view2 = y2Var.f;
        if (view2 != null) {
            arrayList.add(view2);
        }
        DownloadButtonView downloadButtonView = y2Var.d;
        if (downloadButtonView != null && downloadButtonView.getVisibility() == 0) {
            arrayList.add(y2Var.d);
        }
        y2 y2Var2 = this.b;
        y2Var2.getClass();
        ArrayList arrayList2 = new ArrayList();
        DownloadButtonView downloadButtonView2 = y2Var2.d;
        if (downloadButtonView2 != null && downloadButtonView2.getVisibility() == 0) {
            arrayList2.add(y2Var2.d);
        }
        qiNativeAd.registerViewForInteraction(y2Var, arrayList, arrayList2, (View) null, k2Var);
    }

    @Override // com.mcto.sspsdk.internal.z1
    public final void a() {
        QiNativeAd qiNativeAd = this.j;
        if (qiNativeAd != null) {
            qiNativeAd.getCustomizeVideo().reportVideoError(0L, -1, -1);
        }
    }

    @Override // com.mcto.sspsdk.internal.z1
    public final void b() {
        QiNativeAd qiNativeAd = this.j;
        if (qiNativeAd != null) {
            qiNativeAd.getCustomizeVideo().reportVideoFinish();
        }
    }

    @Override // com.mcto.sspsdk.internal.z1
    public final void c() {
        QiNativeAd qiNativeAd = this.j;
        if (qiNativeAd != null) {
            qiNativeAd.getCustomizeVideo().reportVideoStart();
        }
    }

    @Override // com.mcto.sspsdk.internal.z1, com.mcto.sspsdk.IQyBanner
    public final void destroy() {
        super.destroy();
        QiNativeAd qiNativeAd = this.j;
        if (qiNativeAd != null) {
            qiNativeAd.destroy();
            this.j = null;
        }
    }
}
