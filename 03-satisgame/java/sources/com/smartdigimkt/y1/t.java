package com.smartdigimkt.y1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseLifecycleG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements View.OnClickListener {
    public final /* synthetic */ v a;

    public t(v vVar) {
        this.a = vVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        BaseLifecycleG2CV2View baseLifecycleG2CV2View;
        com.smartdigimkt.b2.e eVar;
        v vVar = this.a;
        if (vVar == null || (eVar = (baseLifecycleG2CV2View = ((c) vVar).a).e) == null) {
            return;
        }
        eVar.a(11, baseLifecycleG2CV2View.getClickArea());
    }
}
