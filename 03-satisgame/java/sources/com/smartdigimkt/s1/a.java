package com.smartdigimkt.s1;

import com.smartdigimkt.sdk.basead.ui.animplayerview.scale.AlbumScaleAnimatorView;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {
    public final /* synthetic */ AlbumScaleAnimatorView a;

    public a(AlbumScaleAnimatorView albumScaleAnimatorView) {
        this.a = albumScaleAnimatorView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AlbumScaleAnimatorView albumScaleAnimatorView = this.a;
        albumScaleAnimatorView.f = true;
        albumScaleAnimatorView.c.start();
        this.a.d.setStartDelay(200L);
        this.a.d.start();
        this.a.b.setStartDelay(300L);
        this.a.b.start();
        AlbumScaleAnimatorView albumScaleAnimatorView2 = this.a;
        albumScaleAnimatorView2.e.setMainViewScale(albumScaleAnimatorView2.b.getMainViewScale());
        this.a.e.setStartDelay(300L);
        this.a.e.start();
    }
}
