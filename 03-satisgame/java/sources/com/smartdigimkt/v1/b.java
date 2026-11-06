package com.smartdigimkt.v1;

import android.view.View;
import com.smartdigimkt.i2.k;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ k a;

    public b(k kVar) {
        this.a = kVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        k kVar = this.a;
        if (kVar != null) {
            kVar.a(-100, 13);
        }
    }
}
