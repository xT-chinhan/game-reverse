package com.smartdigimkt.h1;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.smartdigimkt.sdk.basead.ui.OwnNativeATView;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends com.smartdigimkt.b2.c {
    public final /* synthetic */ k h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(k kVar, OwnNativeATView ownNativeATView, com.smartdigimkt.b3.l lVar, com.smartdigimkt.a3.a aVar, int i, h hVar) {
        super(ownNativeATView, lVar, aVar, i, hVar);
        this.h = kVar;
    }

    @Override // com.smartdigimkt.b2.c
    public final ViewGroup.LayoutParams b() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.h.q != null) {
            layoutParams.gravity = 81;
            layoutParams.setMargins(0, 0, 0, 0);
        }
        return layoutParams;
    }
}
