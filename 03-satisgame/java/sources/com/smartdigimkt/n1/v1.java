package com.smartdigimkt.n1;

import com.smartdigimkt.sdk.basead.ui.BaseShakeView;

/* JADX INFO: loaded from: classes3.dex */
public final class v1 implements Runnable {
    public final /* synthetic */ BaseShakeView a;

    public v1(BaseShakeView baseShakeView) {
        this.a = baseShakeView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int iMin;
        try {
            iMin = Math.min(this.a.getResources().getDisplayMetrics().widthPixels, this.a.getResources().getDisplayMetrics().heightPixels) / 2;
        } catch (Throwable unused) {
            iMin = 0;
        }
        BaseShakeView baseShakeView = this.a;
        baseShakeView.j = com.smartdigimkt.i3.m.a(baseShakeView.getContext()).b(new com.smartdigimkt.i3.o(3, this.a.f), iMin, iMin);
        BaseShakeView baseShakeView2 = this.a;
        baseShakeView2.getClass();
        com.smartdigimkt.q3.f.a().a(new w1(baseShakeView2));
    }
}
