package com.smartdigimkt.y1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.LuckyBagG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class l0 implements View.OnClickListener {
    public final /* synthetic */ LuckyBagG2CV2View a;

    public l0(LuckyBagG2CV2View luckyBagG2CV2View) {
        this.a = luckyBagG2CV2View;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.removeAllViews();
        this.a.b();
    }
}
