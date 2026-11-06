package com.smartdigimkt.y1;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.LuckyBagG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 implements com.smartdigimkt.i3.l {
    public final /* synthetic */ LuckyBagG2CV2View a;

    public j0(LuckyBagG2CV2View luckyBagG2CV2View) {
        this.a = luckyBagG2CV2View;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        ImageView imageView = this.a.j;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
