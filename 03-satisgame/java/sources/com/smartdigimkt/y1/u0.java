package com.smartdigimkt.y1;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.PuzzleV2G2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class u0 implements com.smartdigimkt.i3.l {
    public final /* synthetic */ PuzzleV2G2CV2View a;

    public u0(PuzzleV2G2CV2View puzzleV2G2CV2View) {
        this.a = puzzleV2G2CV2View;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        ImageView imageView = this.a.j;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
