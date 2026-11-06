package com.smartdigimkt.w1;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.smartdigimkt.sdk.basead.ui.component.RoundImageView;
import com.smartdigimkt.sdk.basead.ui.component.emdcardimprove.SecondEndCardView;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements com.smartdigimkt.i3.l {
    public final /* synthetic */ String a;
    public final /* synthetic */ SecondEndCardView b;

    public s(SecondEndCardView secondEndCardView, String str) {
        this.b = secondEndCardView;
        this.a = str;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        RoundImageView roundImageView;
        if (!TextUtils.equals(str, this.a) || (roundImageView = this.b.b) == null) {
            return;
        }
        roundImageView.setImageBitmap(bitmap);
    }
}
