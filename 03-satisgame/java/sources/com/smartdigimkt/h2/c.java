package com.smartdigimkt.h2;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.specialnote.BaseSpecialNoteView;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ BaseSpecialNoteView a;

    public c(BaseSpecialNoteView baseSpecialNoteView) {
        this.a = baseSpecialNoteView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.release();
    }
}
