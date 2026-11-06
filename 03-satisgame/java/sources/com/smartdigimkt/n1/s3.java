package com.smartdigimkt.n1;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.smartdigimkt.sdk.basead.ui.MediaATView;

/* JADX INFO: loaded from: classes3.dex */
public final class s3 implements com.smartdigimkt.i3.l {
    public final /* synthetic */ MediaATView a;

    public s3(MediaATView mediaATView) {
        this.a = mediaATView;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        if (TextUtils.equals(this.a.a.e, str)) {
            this.a.p.setImageBitmap(bitmap);
        }
    }
}
