package com.smartdigimkt.q1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ BaseAnimPlayerView a;

    public b(BaseAnimPlayerView baseAnimPlayerView) {
        this.a = baseAnimPlayerView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        k kVar = this.a.o;
        if (kVar != null) {
            kVar.g();
        }
    }
}
