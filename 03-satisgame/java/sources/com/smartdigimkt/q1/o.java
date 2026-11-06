package com.smartdigimkt.q1;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.smartdigimkt.sdk.basead.ui.WrapRoundImageView;
import com.smartdigimkt.sdk.basead.ui.animplayerview.ViewPagerAnimPlayerView;
import com.smartdigimkt.sdk.basead.ui.animplayerview.viewpager.VpMainImgAnimatorView;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements com.smartdigimkt.i3.l {
    public final /* synthetic */ WrapRoundImageView a;
    public final /* synthetic */ WrapRoundImageView b;
    public final /* synthetic */ ViewPagerAnimPlayerView c;

    public o(ViewPagerAnimPlayerView viewPagerAnimPlayerView, WrapRoundImageView wrapRoundImageView, WrapRoundImageView wrapRoundImageView2) {
        this.c = viewPagerAnimPlayerView;
        this.a = wrapRoundImageView;
        this.b = wrapRoundImageView2;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        if (TextUtils.equals(str, this.c.w)) {
            ViewPagerAnimPlayerView viewPagerAnimPlayerView = this.c;
            if (viewPagerAnimPlayerView.C != null && bitmap != null) {
                com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.s4.b(viewPagerAnimPlayerView.getContext(), bitmap, new n(this)));
            }
            ViewPagerAnimPlayerView viewPagerAnimPlayerView2 = this.c;
            if (viewPagerAnimPlayerView2.D == null) {
                viewPagerAnimPlayerView2.D = new VpMainImgAnimatorView(this.c.getContext().getApplicationContext());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(13);
                ((View) this.c.D).setLayoutParams(layoutParams);
                ViewPagerAnimPlayerView viewPagerAnimPlayerView3 = this.c;
                viewPagerAnimPlayerView3.addView((View) viewPagerAnimPlayerView3.D);
                this.c.D.addMainView(bitmap, this.a, this.b);
            }
            ViewPagerAnimPlayerView viewPagerAnimPlayerView4 = this.c;
            if (viewPagerAnimPlayerView4.E) {
                viewPagerAnimPlayerView4.E = false;
                m mVar = viewPagerAnimPlayerView4.D;
                if (mVar != null) {
                    mVar.start();
                }
            }
        }
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
        this.c.a(new com.smartdigimkt.h0.g(com.anythink.core.common.inner.b.b.l, com.anythink.core.common.inner.b.b.T));
    }
}
