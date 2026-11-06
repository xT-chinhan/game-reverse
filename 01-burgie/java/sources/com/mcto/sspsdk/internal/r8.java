package com.mcto.sspsdk.internal;

import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public final class r8 implements Runnable {
    public final /* synthetic */ ImageView a;

    public r8(ImageView imageView) {
        this.a = imageView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.setVisibility(0);
    }
}
