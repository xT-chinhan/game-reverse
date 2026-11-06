package com.smartdigimkt.n1;

import android.view.ViewGroup;
import com.smartdigimkt.sdk.basead.ui.BaseATView;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 extends com.smartdigimkt.b2.c {
    public final /* synthetic */ BaseATView h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(BaseATView baseATView, ViewGroup viewGroup, com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, int i, com.smartdigimkt.b2.e eVar) {
        super(viewGroup, cVar, aVar, i, eVar);
        this.h = baseATView;
    }

    @Override // com.smartdigimkt.b2.c
    public final ViewGroup.LayoutParams b() {
        return this.h.getSpecialNoteViewLayoutParams();
    }
}
