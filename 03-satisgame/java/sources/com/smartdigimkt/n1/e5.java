package com.smartdigimkt.n1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.SimplePlayerMediaView;

/* JADX INFO: loaded from: classes3.dex */
public final class e5 implements View.OnClickListener {
    public final /* synthetic */ SimplePlayerMediaView a;

    public e5(SimplePlayerMediaView simplePlayerMediaView) {
        this.a = simplePlayerMediaView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SimplePlayerMediaView simplePlayerMediaView = this.a;
        simplePlayerMediaView.o = false;
        simplePlayerMediaView.i.setVisibility(8);
        com.smartdigimkt.u1.d dVar = this.a.b;
        if (dVar != null) {
            dVar.d();
        }
    }
}
