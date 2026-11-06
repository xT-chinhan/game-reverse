package com.smartdigimkt.n1;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.smartdigimkt.sdk.basead.ui.SinglePictureBottomSlideSplashATView;
import com.smartdigimkt.sdk.basead.ui.WrapRoundImageView;
import com.smartdigimkt.sdk.basead.ui.component.RoundImageView;

/* JADX INFO: loaded from: classes3.dex */
public final class s5 implements com.smartdigimkt.i3.l {
    public final /* synthetic */ SinglePictureBottomSlideSplashATView a;

    public s5(SinglePictureBottomSlideSplashATView singlePictureBottomSlideSplashATView) {
        this.a = singlePictureBottomSlideSplashATView;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        if (TextUtils.equals(str, this.a.c.f)) {
            SinglePictureBottomSlideSplashATView singlePictureBottomSlideSplashATView = this.a;
            WrapRoundImageView wrapRoundImageView = (WrapRoundImageView) singlePictureBottomSlideSplashATView.findViewById(com.smartdigimkt.r4.k.a(singlePictureBottomSlideSplashATView.getContext(), "myoffer_splash_ad_content_image_area", "id"));
            SinglePictureBottomSlideSplashATView singlePictureBottomSlideSplashATView2 = this.a;
            RoundImageView roundImageView = (RoundImageView) singlePictureBottomSlideSplashATView2.findViewById(com.smartdigimkt.r4.k.a(singlePictureBottomSlideSplashATView2.getContext(), "myoffer_splash_bg", "id"));
            wrapRoundImageView.setVisibility(0);
            if (this.a.b.s.A == 2) {
                wrapRoundImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                wrapRoundImageView.setImageBitmap(bitmap);
            } else {
                wrapRoundImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                wrapRoundImageView.post(new q5(this, wrapRoundImageView, bitmap));
            }
            if (roundImageView != null) {
                com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.s4.b(this.a.getContext(), bitmap, new r5(roundImageView)));
            }
        }
    }
}
