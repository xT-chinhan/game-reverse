package com.smartdigimkt.q1;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.smartdigimkt.sdk.basead.ui.WrapRoundImageView;
import com.smartdigimkt.sdk.basead.ui.animplayerview.AlbumScaleAnimPlayerView;
import com.smartdigimkt.sdk.basead.ui.animplayerview.scale.AlbumScaleAnimatorView;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.smartdigimkt.i3.l {
    public final /* synthetic */ AlbumScaleAnimPlayerView a;

    public a(AlbumScaleAnimPlayerView albumScaleAnimPlayerView) {
        this.a = albumScaleAnimPlayerView;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        if (TextUtils.equals(str, this.a.w)) {
            AlbumScaleAnimPlayerView albumScaleAnimPlayerView = this.a;
            if (albumScaleAnimPlayerView.C == null) {
                albumScaleAnimPlayerView.C = new AlbumScaleAnimatorView(this.a.getContext().getApplicationContext());
                AlbumScaleAnimPlayerView albumScaleAnimPlayerView2 = this.a;
                albumScaleAnimPlayerView2.C.setBitmapResources(albumScaleAnimPlayerView2.E);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(13);
                AlbumScaleAnimPlayerView albumScaleAnimPlayerView3 = this.a;
                albumScaleAnimPlayerView3.addView((View) albumScaleAnimPlayerView3.C, layoutParams);
                this.a.C.addMainView(bitmap, new WrapRoundImageView[0]);
            }
            AlbumScaleAnimPlayerView albumScaleAnimPlayerView4 = this.a;
            if (albumScaleAnimPlayerView4.D) {
                albumScaleAnimPlayerView4.D = false;
                m mVar = albumScaleAnimPlayerView4.C;
                if (mVar != null) {
                    mVar.start();
                }
            }
        }
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
        this.a.a(new com.smartdigimkt.h0.g(com.anythink.core.common.inner.b.b.l, com.anythink.core.common.inner.b.b.T));
    }
}
