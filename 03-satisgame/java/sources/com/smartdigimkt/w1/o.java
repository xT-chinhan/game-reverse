package com.smartdigimkt.w1;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.smartdigimkt.sdk.basead.ui.component.emdcardimprove.SecondEndCardView;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements com.smartdigimkt.i3.l {
    public final /* synthetic */ SecondEndCardView a;

    public o(SecondEndCardView secondEndCardView) {
        this.a = secondEndCardView;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        ImageView imageView = this.a.c;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
