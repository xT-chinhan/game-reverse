package com.smartdigimkt.n1;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.smartdigimkt.sdk.basead.ui.SimplePlayerMediaView;

/* JADX INFO: loaded from: classes3.dex */
public final class h5 implements com.smartdigimkt.i3.l {
    public final /* synthetic */ com.smartdigimkt.b3.c a;
    public final /* synthetic */ SimplePlayerMediaView b;

    public h5(SimplePlayerMediaView simplePlayerMediaView, com.smartdigimkt.b3.c cVar) {
        this.b = simplePlayerMediaView;
        this.a = cVar;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        if (TextUtils.equals(str, this.a.f)) {
            ImageView imageView = this.b.l;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            this.b.k.setImageBitmap(bitmap);
        }
    }
}
