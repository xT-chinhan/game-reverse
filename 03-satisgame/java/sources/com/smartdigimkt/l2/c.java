package com.smartdigimkt.l2;

import android.view.View;
import android.view.ViewGroup;
import com.smartdigimkt.sdk.basead.ui.RoundCornerRelativeLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;
    public final /* synthetic */ int f;
    public final /* synthetic */ int g;
    public final /* synthetic */ int h;
    public final /* synthetic */ int i;
    public final /* synthetic */ int j;
    public final /* synthetic */ f k;

    public c(f fVar, Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.k = fVar;
        this.a = obj;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = i6;
        this.h = i7;
        this.i = i8;
        this.j = i9;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.smartdigimkt.u1.d dVar = this.k.b;
        View view = dVar.r;
        if (view == null) {
            view = dVar.h;
        }
        if (view == null) {
            com.smartdigimkt.k2.a.a(this.a, "playerViewContainer empty");
            return;
        }
        view.setX(this.b);
        view.setY(this.c);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = this.d;
            layoutParams.height = this.e;
            view.setLayoutParams(layoutParams);
        }
        this.k.b.a(this.f == 1, null);
        if (view instanceof RoundCornerRelativeLayout) {
            ((RoundCornerRelativeLayout) view).setRadius(this.g, this.h, this.i, this.j);
        }
        view.requestLayout();
        com.smartdigimkt.k2.a.b(this.a, "");
        a aVar = this.k.a;
        if (aVar != null) {
            aVar.a();
        }
    }
}
