package com.smartdigimkt.y1;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.PicVerifyG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class q0 implements com.smartdigimkt.i3.l {
    public final /* synthetic */ int a;
    public final /* synthetic */ PicVerifyG2CV2View b;

    public q0(PicVerifyG2CV2View picVerifyG2CV2View, int i) {
        this.b = picVerifyG2CV2View;
        this.a = i;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        if (TextUtils.equals(str, this.b.j)) {
            DisplayMetrics displayMetrics = this.b.getContext().getResources().getDisplayMetrics();
            int[] iArrA = com.smartdigimkt.o3.d.a(displayMetrics.widthPixels, displayMetrics.heightPixels, bitmap.getWidth() / bitmap.getHeight());
            int i = this.a * 2;
            if (bitmap.getWidth() < i || bitmap.getHeight() < i) {
                b bVar = this.b.b;
                if (bVar != null) {
                    ((n) bVar).a.c();
                    return;
                }
                return;
            }
            int iA = com.smartdigimkt.r4.k.a(this.b.getContext(), 180.0f);
            if (iArrA[0] < iA || iArrA[1] < iA) {
                b bVar2 = this.b.b;
                if (bVar2 != null) {
                    ((n) bVar2).a.c();
                    return;
                }
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.b.h.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = iArrA[0];
                layoutParams.height = iArrA[1];
                this.b.h.setLayoutParams(layoutParams);
            }
            this.b.h.setImageBitmap(bitmap);
            this.b.post(new p0(this));
        }
    }
}
