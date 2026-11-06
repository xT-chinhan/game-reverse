package com.smartdigimkt.n1;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.smartdigimkt.sdk.basead.ui.SdkBannerATView;
import com.smartdigimkt.sdk.basead.ui.component.RoundImageView;

/* JADX INFO: loaded from: classes3.dex */
public final class s4 implements com.smartdigimkt.i3.l {
    public final /* synthetic */ RoundImageView a;
    public final /* synthetic */ SdkBannerATView b;

    public s4(SdkBannerATView sdkBannerATView, RoundImageView roundImageView) {
        this.b = sdkBannerATView;
        this.a = roundImageView;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        if (TextUtils.equals(this.b.c.e, str)) {
            this.a.setImageBitmap(bitmap);
        }
    }
}
