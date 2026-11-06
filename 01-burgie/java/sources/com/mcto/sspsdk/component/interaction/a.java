package com.mcto.sspsdk.component.interaction;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {
    public final /* synthetic */ QySharkView a;

    public a(QySharkView qySharkView) {
        this.a = qySharkView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        QySharkView qySharkView = this.a;
        qySharkView.setRotation(qySharkView.g ? 15.0f : -15.0f);
        QySharkView qySharkView2 = this.a;
        qySharkView2.g = !qySharkView2.g;
        this.a.f.postDelayed(this, 300L);
    }
}
