package com.smartdigimkt.i;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.smartdigimkt.sdk.basead.ui.component.RoundImageView;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements com.smartdigimkt.i3.l {
    public final /* synthetic */ String a;
    public final /* synthetic */ RoundImageView b;

    public g(String str, RoundImageView roundImageView) {
        this.a = str;
        this.b = roundImageView;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        if (TextUtils.equals(str, this.a)) {
            this.b.setImageBitmap(bitmap);
        }
    }
}
