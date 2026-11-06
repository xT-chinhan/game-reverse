package com.smartdigimkt.s1;

import android.graphics.Bitmap;
import com.smartdigimkt.sdk.basead.ui.animplayerview.scale.AlbumScaleMainView;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.smartdigimkt.s4.c {
    public final /* synthetic */ AlbumScaleMainView a;

    public b(AlbumScaleMainView albumScaleMainView) {
        this.a = albumScaleMainView;
    }

    @Override // com.smartdigimkt.s4.c
    public final void a() {
    }

    @Override // com.smartdigimkt.s4.c
    public final void a(Bitmap bitmap) {
        this.a.a.setImageBitmap(bitmap);
    }
}
