package com.mcto.sspsdk.internal;

import com.mcto.sspsdk.component.button.DownloadButtonView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements b1 {
    public final WeakReference a;

    public g(h hVar) {
        this.a = new WeakReference(hVar);
    }

    @Override // com.mcto.sspsdk.internal.b1
    public final void a(s0 s0Var) {
        h hVar = (h) this.a.get();
        if (hVar != null) {
            f fVar = new f(hVar, s0Var);
            DownloadButtonView downloadButtonView = hVar.a;
            if (downloadButtonView != null) {
                downloadButtonView.post(fVar);
            }
        }
    }
}
