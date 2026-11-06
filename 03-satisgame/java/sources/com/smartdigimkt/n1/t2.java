package com.smartdigimkt.n1;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.smartdigimkt.sdk.basead.ui.EndCardView;

/* JADX INFO: loaded from: classes3.dex */
public final class t2 implements com.smartdigimkt.i3.l {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ EndCardView c;

    public t2(EndCardView endCardView, String str, int i) {
        this.c = endCardView;
        this.a = str;
        this.b = i;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        if (TextUtils.equals(str, this.a)) {
            float width = (bitmap.getWidth() * 1.0f) / bitmap.getHeight();
            int i = this.b;
            ViewGroup.LayoutParams layoutParams = this.c.h.getLayoutParams();
            layoutParams.width = (int) (i * width);
            layoutParams.height = i;
            this.c.h.setLayoutParams(layoutParams);
            this.c.h.setScaleType(ImageView.ScaleType.FIT_XY);
            this.c.h.setImageBitmap(bitmap);
        }
    }
}
