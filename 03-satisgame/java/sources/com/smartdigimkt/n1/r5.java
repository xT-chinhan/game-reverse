package com.smartdigimkt.n1;

import android.graphics.Bitmap;
import com.smartdigimkt.sdk.basead.ui.component.RoundImageView;

/* JADX INFO: loaded from: classes3.dex */
public final class r5 implements com.smartdigimkt.s4.c {
    public final /* synthetic */ RoundImageView a;

    public r5(RoundImageView roundImageView) {
        this.a = roundImageView;
    }

    @Override // com.smartdigimkt.s4.c
    public final void a() {
    }

    @Override // com.smartdigimkt.s4.c
    public final void a(Bitmap bitmap) {
        this.a.setVisibility(0);
        this.a.setImageBitmap(bitmap);
    }
}
