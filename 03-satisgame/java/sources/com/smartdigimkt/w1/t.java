package com.smartdigimkt.w1;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.smartdigimkt.sdk.basead.ui.component.emdcardimprove.SecondEndCardView;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements com.smartdigimkt.i3.l {
    public final /* synthetic */ String a;
    public final /* synthetic */ SecondEndCardView b;

    public t(SecondEndCardView secondEndCardView, String str) {
        this.b = secondEndCardView;
        this.a = str;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        ImageView imageView;
        if (!TextUtils.equals(str, this.a) || (imageView = this.b.c) == null) {
            return;
        }
        imageView.setImageBitmap(bitmap);
    }
}
