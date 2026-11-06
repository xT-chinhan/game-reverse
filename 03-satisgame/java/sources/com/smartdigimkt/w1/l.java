package com.smartdigimkt.w1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.component.emdcardimprove.RedPacketPage;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ RedPacketPage a;

    public l(RedPacketPage redPacketPage) {
        this.a = redPacketPage;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.smartdigimkt.i2.k kVar = this.a.t;
        if (kVar != null) {
            kVar.a(14, 30);
        }
    }
}
