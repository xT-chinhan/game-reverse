package com.smartdigimkt.b2;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ t c;

    public s(t tVar, int i, int i2) {
        this.c = tVar;
        this.a = i;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewGroup.LayoutParams layoutParams;
        if (this.c.a.getParent() == null || (layoutParams = this.c.a.getLayoutParams()) == null) {
            return;
        }
        int i = layoutParams.width;
        int i2 = this.a;
        if (i == i2 && layoutParams.height == this.b) {
            return;
        }
        layoutParams.width = i2;
        layoutParams.height = this.b;
        this.c.a.setLayoutParams(layoutParams);
    }
}
