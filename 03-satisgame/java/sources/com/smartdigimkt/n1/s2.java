package com.smartdigimkt.n1;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.smartdigimkt.sdk.basead.ui.EndCardView;

/* JADX INFO: loaded from: classes3.dex */
public final class s2 implements com.smartdigimkt.i3.l {
    public final /* synthetic */ com.smartdigimkt.b3.c a;
    public final /* synthetic */ EndCardView b;

    public s2(EndCardView endCardView, com.smartdigimkt.b3.c cVar) {
        this.b = endCardView;
        this.a = cVar;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        if (TextUtils.equals(str, this.a.f)) {
            this.b.g.setImageBitmap(bitmap);
            com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.s4.b(this.b.getContext(), bitmap, new r2(this)));
        }
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
        p0 p0Var = this.b.mListener;
    }
}
