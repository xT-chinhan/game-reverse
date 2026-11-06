package com.smartdigimkt.v1;

import android.view.View;
import com.smartdigimkt.i2.k;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ k a;

    public c(k kVar) {
        this.a = kVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.a(1, 1);
    }
}
