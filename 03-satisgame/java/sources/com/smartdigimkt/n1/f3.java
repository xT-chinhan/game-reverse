package com.smartdigimkt.n1;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.smartdigimkt.sdk.basead.ui.GuideToClickView;

/* JADX INFO: loaded from: classes3.dex */
public final class f3 implements com.smartdigimkt.i3.l {
    public final /* synthetic */ GuideToClickView a;

    public f3(GuideToClickView guideToClickView) {
        this.a = guideToClickView;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        ImageView imageView = this.a.c;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
