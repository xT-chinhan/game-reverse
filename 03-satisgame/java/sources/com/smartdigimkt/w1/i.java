package com.smartdigimkt.w1;

import android.animation.ValueAnimator;
import android.view.View;
import com.smartdigimkt.sdk.basead.ui.component.emdcardimprove.RedPacketPage;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ RedPacketPage a;

    public i(RedPacketPage redPacketPage) {
        this.a = redPacketPage;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.smartdigimkt.i2.k kVar = this.a.t;
        if (kVar != null) {
            kVar.a(14, 27);
        }
        this.a.stopAnimation();
        RedPacketPage redPacketPage = this.a;
        if (redPacketPage.s == 1) {
            redPacketPage.j.setVisibility(8);
            this.a.m.setVisibility(0);
            RedPacketPage redPacketPage2 = this.a;
            redPacketPage2.p = ValueAnimator.ofInt(0, redPacketPage2.r.size() - 1);
            RedPacketPage redPacketPage3 = this.a;
            redPacketPage3.p.setDuration(redPacketPage3.r.size() * 80);
            this.a.p.setRepeatCount(1);
            this.a.p.addUpdateListener(new e(this));
            this.a.p.addListener(new h(this));
            this.a.p.start();
        }
    }
}
