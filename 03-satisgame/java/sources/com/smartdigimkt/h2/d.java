package com.smartdigimkt.h2;

import com.smartdigimkt.sdk.basead.ui.specialnote.BaseSpecialNoteView;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends com.smartdigimkt.p3.a {
    public final /* synthetic */ BaseSpecialNoteView b;

    public d(BaseSpecialNoteView baseSpecialNoteView) {
        this.b = baseSpecialNoteView;
    }

    @Override // com.smartdigimkt.p3.a
    public final int a() {
        return 50;
    }

    @Override // com.smartdigimkt.p3.a
    public final void b() {
        BaseSpecialNoteView baseSpecialNoteView = this.b;
        int i = BaseSpecialNoteView.o;
        if (baseSpecialNoteView.f == null) {
            return;
        }
        baseSpecialNoteView.postDelayed(baseSpecialNoteView.g, 500L);
    }
}
