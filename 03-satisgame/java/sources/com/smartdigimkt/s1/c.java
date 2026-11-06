package com.smartdigimkt.s1;

import android.graphics.Bitmap;
import com.smartdigimkt.sdk.basead.ui.animplayerview.scale.AlbumScaleMainView;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {
    public final /* synthetic */ Bitmap a;
    public final /* synthetic */ AlbumScaleMainView b;

    public c(AlbumScaleMainView albumScaleMainView, Bitmap bitmap) {
        this.b = albumScaleMainView;
        this.a = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AlbumScaleMainView albumScaleMainView = this.b;
        albumScaleMainView.b.setBitmapAndResize(this.a, albumScaleMainView.getWidth(), this.b.getHeight());
    }
}
