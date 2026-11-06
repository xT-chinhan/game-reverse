package com.smartdigimkt.n1;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.smartdigimkt.sdk.basead.ui.MediaATView;

/* JADX INFO: loaded from: classes3.dex */
public final class v3 implements com.smartdigimkt.i3.l {
    public final /* synthetic */ MediaATView a;

    public v3(MediaATView mediaATView) {
        this.a = mediaATView;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        if (TextUtils.equals(this.a.a.f, str)) {
            this.a.o.setVisibility(0);
            this.a.o.setImageBitmap(bitmap);
            this.a.post(new t3(this, bitmap));
            com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.s4.b(this.a.getContext(), bitmap, new u3(this)));
        }
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
        String str = MediaATView.TAG;
    }
}
