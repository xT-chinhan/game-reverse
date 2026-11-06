package com.smartdigimkt.n1;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.smartdigimkt.sdk.basead.ui.SinglePictureSplashATView;
import com.smartdigimkt.sdk.basead.ui.WrapRoundImageView;
import com.smartdigimkt.sdk.basead.ui.component.RoundImageView;

/* JADX INFO: loaded from: classes3.dex */
public final class x5 implements com.smartdigimkt.i3.l {
    public final /* synthetic */ SinglePictureSplashATView a;

    public x5(SinglePictureSplashATView singlePictureSplashATView) {
        this.a = singlePictureSplashATView;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        if (TextUtils.equals(str, this.a.c.f)) {
            SinglePictureSplashATView singlePictureSplashATView = this.a;
            WrapRoundImageView wrapRoundImageView = (WrapRoundImageView) singlePictureSplashATView.findViewById(com.smartdigimkt.r4.k.a(singlePictureSplashATView.getContext(), "myoffer_splash_ad_content_image_area", "id"));
            if (wrapRoundImageView == null) {
                String str2 = this.a.a;
                return;
            }
            SinglePictureSplashATView singlePictureSplashATView2 = this.a;
            RoundImageView roundImageView = (RoundImageView) singlePictureSplashATView2.findViewById(com.smartdigimkt.r4.k.a(singlePictureSplashATView2.getContext(), "myoffer_splash_bg", "id"));
            wrapRoundImageView.setVisibility(0);
            if (this.a.b.s.A == 2) {
                wrapRoundImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                wrapRoundImageView.setImageBitmap(bitmap);
            } else {
                wrapRoundImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                wrapRoundImageView.post(new v5(this, wrapRoundImageView, bitmap));
            }
            if (roundImageView != null) {
                com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.s4.b(this.a.getContext(), bitmap, new w5(roundImageView)));
            }
        }
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
        String str = this.a.a;
    }
}
