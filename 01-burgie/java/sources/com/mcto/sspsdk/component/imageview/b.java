package com.mcto.sspsdk.component.imageview;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ QYNiceImageView b;

    public b(QYNiceImageView qYNiceImageView, int i) {
        this.b = qYNiceImageView;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.g.a(Integer.valueOf(this.a));
    }
}
