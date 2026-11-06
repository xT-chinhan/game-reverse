package com.smartdigimkt.t1;

import com.smartdigimkt.sdk.basead.ui.animplayerview.viewpager.VpMainImgAnimatorView;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {
    public final /* synthetic */ VpMainImgAnimatorView a;

    public b(VpMainImgAnimatorView vpMainImgAnimatorView) {
        this.a = vpMainImgAnimatorView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VpMainImgAnimatorView vpMainImgAnimatorView = this.a;
        int i = VpMainImgAnimatorView.l;
        vpMainImgAnimatorView.a();
    }
}
