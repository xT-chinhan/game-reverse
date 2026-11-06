package com.smartdigimkt.n1;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.smartdigimkt.sdk.basead.ui.EndCardView;

/* JADX INFO: loaded from: classes3.dex */
public final class r2 implements com.smartdigimkt.s4.c {
    public final /* synthetic */ s2 a;

    public r2(s2 s2Var) {
        this.a = s2Var;
    }

    @Override // com.smartdigimkt.s4.c
    public final void a(Bitmap bitmap) {
        EndCardView endCardView = this.a.b;
        endCardView.j = bitmap;
        endCardView.setBackgroundDrawable(new BitmapDrawable(this.a.b.j));
        p0 p0Var = this.a.b.mListener;
    }

    @Override // com.smartdigimkt.s4.c
    public final void a() {
        p0 p0Var = this.a.b.mListener;
    }
}
