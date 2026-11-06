package com.smartdigimkt.k1;

import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends com.smartdigimkt.b2.c {
    public final /* synthetic */ l h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(l lVar, ViewGroup viewGroup, com.smartdigimkt.e3.a aVar, com.smartdigimkt.a3.a aVar2, j jVar) {
        super(viewGroup, aVar, aVar2, 5, jVar);
        this.h = lVar;
    }

    @Override // com.smartdigimkt.b2.c
    public final ViewGroup.LayoutParams b() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.h.l != null) {
            layoutParams.gravity = 81;
            layoutParams.setMargins(0, 0, 0, 0);
        }
        return layoutParams;
    }
}
