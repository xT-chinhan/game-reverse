package com.smartdigimkt.y1;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.GTCV2InnerCountDownView;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements com.smartdigimkt.i3.l {
    public final /* synthetic */ GTCV2InnerCountDownView a;

    public p(GTCV2InnerCountDownView gTCV2InnerCountDownView) {
        this.a = gTCV2InnerCountDownView;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        ImageView imageView = this.a.f;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
