package com.smartdigimkt.b2;

import android.view.ViewGroup;
import com.smartdigimkt.sdk.basead.ui.specialnote.BaseSpecialNoteView;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {
    public final /* synthetic */ j0 a;
    public final /* synthetic */ c b;

    public a(c cVar, j0 j0Var) {
        this.b = cVar;
        this.a = j0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BaseSpecialNoteView baseSpecialNoteView;
        ViewGroup.LayoutParams layoutParamsB = this.b.b();
        if (this.a == null || this.b.b() == null || (baseSpecialNoteView = this.a.i) == null) {
            return;
        }
        baseSpecialNoteView.setLayoutParams(layoutParamsB);
    }
}
