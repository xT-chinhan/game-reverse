package com.smartdigimkt.y1;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.ChopOnceG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements com.smartdigimkt.i3.l {
    public final /* synthetic */ ChopOnceG2CV2View a;

    public d(ChopOnceG2CV2View chopOnceG2CV2View) {
        this.a = chopOnceG2CV2View;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        ImageView imageView = this.a.i;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
