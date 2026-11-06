package com.smartdigimkt.t1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.smartdigimkt.sdk.basead.ui.WrapRoundImageView;
import com.smartdigimkt.sdk.basead.ui.animplayerview.viewpager.VpMainImgAnimatorView;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends Handler {
    public final /* synthetic */ VpMainImgAnimatorView a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(VpMainImgAnimatorView vpMainImgAnimatorView, Looper looper) {
        super(looper);
        this.a = vpMainImgAnimatorView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        VpMainImgAnimatorView vpMainImgAnimatorView;
        WrapRoundImageView wrapRoundImageView;
        if (message.what != 100 || (wrapRoundImageView = (vpMainImgAnimatorView = this.a).a) == null || vpMainImgAnimatorView.b == null) {
            return;
        }
        if (vpMainImgAnimatorView.e == 0) {
            wrapRoundImageView.post(new b(vpMainImgAnimatorView));
        } else {
            vpMainImgAnimatorView.a();
        }
    }
}
