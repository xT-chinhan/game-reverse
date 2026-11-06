package com.smartdigimkt.r1;

import com.smartdigimkt.sdk.basead.ui.animplayerview.redpacket.RedPacketAnimatorView;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {
    public final /* synthetic */ RedPacketAnimatorView a;

    public b(RedPacketAnimatorView redPacketAnimatorView) {
        this.a = redPacketAnimatorView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RedPacketAnimatorView redPacketAnimatorView = this.a;
        int i = RedPacketAnimatorView.h;
        redPacketAnimatorView.a();
    }
}
