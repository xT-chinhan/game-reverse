package com.smartdigimkt.n1;

import com.smartdigimkt.sdk.basead.ui.BaseShakeView;

/* JADX INFO: loaded from: classes3.dex */
public final class e2 implements Runnable {
    public final /* synthetic */ BaseShakeView a;

    public e2(BaseShakeView baseShakeView) {
        this.a = baseShakeView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int width = (int) (((double) this.a.a.getWidth()) * 0.5d);
        int height = (int) (((double) this.a.a.getHeight()) * 0.5d);
        this.a.a.setPivotX(width);
        this.a.a.setPivotY(height);
    }
}
