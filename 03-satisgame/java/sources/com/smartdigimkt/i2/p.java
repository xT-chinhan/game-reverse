package com.smartdigimkt.i2;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements Runnable {
    public final /* synthetic */ r a;

    public p(r rVar) {
        this.a = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View view = this.a.i;
        if (view != null) {
            view.setVisibility(8);
        }
    }
}
