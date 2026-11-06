package com.smartdigimkt.n1;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.smartdigimkt.sdk.basead.ui.SdkBannerATView;
import com.smartdigimkt.sdk.core.common.res.image.RecycleImageView;

/* JADX INFO: loaded from: classes3.dex */
public final class w4 implements com.smartdigimkt.i3.l {
    public final /* synthetic */ String a;
    public final /* synthetic */ RecycleImageView b;
    public final /* synthetic */ RecycleImageView c;
    public final /* synthetic */ SdkBannerATView d;

    public w4(SdkBannerATView sdkBannerATView, String str, RecycleImageView recycleImageView, RecycleImageView recycleImageView2) {
        this.d = sdkBannerATView;
        this.a = str;
        this.b = recycleImageView;
        this.c = recycleImageView2;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        if (TextUtils.equals(this.a, str)) {
            this.b.setImageBitmap(bitmap);
            com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.s4.b(this.d.getContext(), bitmap, new v4(this)));
        }
    }
}
