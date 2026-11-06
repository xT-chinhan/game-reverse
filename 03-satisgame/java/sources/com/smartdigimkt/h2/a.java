package com.smartdigimkt.h2;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.specialnote.BaseSpecialNoteView;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {
    public final /* synthetic */ BaseSpecialNoteView a;

    public a(BaseSpecialNoteView baseSpecialNoteView) {
        this.a = baseSpecialNoteView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BaseSpecialNoteView baseSpecialNoteView = this.a;
        int i = BaseSpecialNoteView.o;
        if (baseSpecialNoteView.getWindowVisibility() == 0) {
            View view = baseSpecialNoteView.e;
            if (view != null && view.getParent() != null) {
                Object parent = baseSpecialNoteView.e.getParent();
                if ((parent instanceof View) && baseSpecialNoteView.i.a((View) parent, baseSpecialNoteView.e, 50, 0)) {
                    long j = baseSpecialNoteView.b;
                    if (j > 0) {
                        baseSpecialNoteView.b = j - 500;
                    } else {
                        long j2 = baseSpecialNoteView.d;
                        if (j2 > 0) {
                            baseSpecialNoteView.d = j2 - 500;
                        }
                    }
                    baseSpecialNoteView.b();
                    if (baseSpecialNoteView.f == null) {
                        return;
                    }
                    baseSpecialNoteView.postDelayed(baseSpecialNoteView.g, 500L);
                    return;
                }
            }
        } else if (baseSpecialNoteView.e()) {
            baseSpecialNoteView.b = baseSpecialNoteView.a;
            baseSpecialNoteView.d = baseSpecialNoteView.c;
            baseSpecialNoteView.setVisibility(4);
            baseSpecialNoteView.n = false;
        }
        View view2 = baseSpecialNoteView.e;
        if (view2 == null) {
            return;
        }
        baseSpecialNoteView.h.a(view2, new d(baseSpecialNoteView));
    }
}
