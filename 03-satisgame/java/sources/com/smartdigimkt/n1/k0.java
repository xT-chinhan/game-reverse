package com.smartdigimkt.n1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.BaseATView;
import com.smartdigimkt.sdk.basead.ui.ScanningAnimButton;

/* JADX INFO: loaded from: classes3.dex */
public final class k0 implements Runnable {
    public final /* synthetic */ com.smartdigimkt.b3.c a;
    public final /* synthetic */ BaseATView b;

    public k0(BaseATView baseATView, com.smartdigimkt.b3.c cVar) {
        this.b = baseATView;
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.smartdigimkt.b3.e eVar;
        View view = this.b.m;
        if (!(view instanceof ScanningAnimButton) || (eVar = this.a.w) == null) {
            return;
        }
        ((ScanningAnimButton) view).startAnimation(eVar.z0);
    }
}
