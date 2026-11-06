package com.smartdigimkt.q1;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.smartdigimkt.sdk.basead.ui.WrapRoundImageView;
import com.smartdigimkt.sdk.basead.ui.animplayerview.BaseMainAnimPlayerView;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements com.smartdigimkt.i3.l {
    public final /* synthetic */ WrapRoundImageView a;
    public final /* synthetic */ BaseMainAnimPlayerView b;

    public j(BaseMainAnimPlayerView baseMainAnimPlayerView, WrapRoundImageView wrapRoundImageView) {
        this.b = baseMainAnimPlayerView;
        this.a = wrapRoundImageView;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        if (TextUtils.equals(str, this.b.w)) {
            WrapRoundImageView wrapRoundImageView = this.a;
            if (wrapRoundImageView != null) {
                wrapRoundImageView.post(new h(this, bitmap));
            }
            BaseMainAnimPlayerView baseMainAnimPlayerView = this.b;
            if (baseMainAnimPlayerView.x == null || bitmap == null) {
                return;
            }
            com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.s4.b(baseMainAnimPlayerView.getContext(), bitmap, new i(this)));
        }
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
        this.b.a(new com.smartdigimkt.h0.g(com.anythink.core.common.inner.b.b.l, com.anythink.core.common.inner.b.b.T));
    }
}
