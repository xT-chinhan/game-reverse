package com.smartdigimkt.b2;

import com.smartdigimkt.sdk.basead.ui.specialnote.BaseSpecialNoteView;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;
    public final /* synthetic */ j0 d;

    public i0(j0 j0Var, int i, long j, long j2) {
        this.d = j0Var;
        this.a = i;
        this.b = j;
        this.c = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BaseSpecialNoteView baseSpecialNoteView = this.d.i;
        if (baseSpecialNoteView != null) {
            if (baseSpecialNoteView.getParent() == null) {
                j0 j0Var = this.d;
                j0Var.i.initSetting(j0Var.d, this.a, new h0(this), this.b, this.c);
                j0 j0Var2 = this.d;
                j0Var2.d.addView(j0Var2.i);
                return;
            }
            if (this.a == 7) {
                j0 j0Var3 = this.d;
                if (!com.smartdigimkt.z.c0.h(j0Var3.b, j0Var3.c) || this.d.i.hasBeenShow()) {
                    return;
                }
                this.d.i.pause();
                this.d.i.reset(this.a, this.b, this.c);
                this.d.i.resume();
            }
        }
    }
}
