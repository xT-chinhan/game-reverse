package com.smartdigimkt.w1;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.smartdigimkt.sdk.basead.ui.component.RoundImageView;
import com.smartdigimkt.sdk.basead.ui.component.emdcardimprove.RedPacketPage;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements com.smartdigimkt.i3.l {
    public final /* synthetic */ String a;
    public final /* synthetic */ RedPacketPage b;

    public n(RedPacketPage redPacketPage, String str) {
        this.b = redPacketPage;
        this.a = str;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        if (TextUtils.equals(str, this.a)) {
            RoundImageView roundImageView = this.b.c;
            if (roundImageView != null) {
                roundImageView.setImageBitmap(bitmap);
            }
            RoundImageView roundImageView2 = this.b.d;
            if (roundImageView2 != null) {
                roundImageView2.setImageBitmap(bitmap);
            }
        }
    }
}
