package com.mcto.sspsdk.internal;

import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public final class u2 implements Runnable {
    public final /* synthetic */ y2 a;

    public u2(y2 y2Var) {
        this.a = y2Var;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, com.mcto.sspsdk.internal.n7] */
    @Override // java.lang.Runnable
    public final void run() {
        ?? r0 = this.a.i;
        if (r0 != 0) {
            r0.b();
            ((ge) this.a.i).setVisibility(8);
        }
        TextView textView = this.a.j;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }
}
