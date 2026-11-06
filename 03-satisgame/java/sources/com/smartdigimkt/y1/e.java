package com.smartdigimkt.y1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.ChopOnceG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ ChopOnceG2CV2View a;

    public e(ChopOnceG2CV2View chopOnceG2CV2View) {
        this.a = chopOnceG2CV2View;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.removeAllViews();
        this.a.b();
    }
}
