package com.smartdigimkt.i2;

import android.view.View;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ j a;

    public d(j jVar) {
        this.a = jVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.smartdigimkt.s4.e.a(SDKContext.getInstance().d(), this.a.b.u);
    }
}
