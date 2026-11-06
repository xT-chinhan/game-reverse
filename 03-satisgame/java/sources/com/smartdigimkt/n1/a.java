package com.smartdigimkt.n1;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements View.OnApplyWindowInsetsListener {
    public final /* synthetic */ h a;
    public final /* synthetic */ boolean b;

    public a(h hVar, boolean z) {
        this.a = hVar;
        this.b = z;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        Rect rectB;
        h hVar = this.a;
        if (this.b) {
            rectB = Build.VERSION.SDK_INT >= 30 ? f.a(windowInsets) : d.b(windowInsets);
        } else {
            rectB = Build.VERSION.SDK_INT >= 30 ? f.b(windowInsets, false) : d.c(windowInsets);
        }
        hVar.o = rectB;
        this.a.p = Build.VERSION.SDK_INT >= 31 ? g.a(windowInsets) : null;
        this.a.onGlobalLayout();
        return windowInsets;
    }
}
