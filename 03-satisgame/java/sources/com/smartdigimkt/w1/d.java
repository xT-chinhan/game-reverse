package com.smartdigimkt.w1;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.smartdigimkt.sdk.basead.ui.component.emdcardimprove.RedPacketPage;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements com.smartdigimkt.i3.l {
    public final /* synthetic */ RedPacketPage a;

    public d(RedPacketPage redPacketPage) {
        this.a = redPacketPage;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        ImageView imageView = this.a.k;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
