package com.byazt.ki;

import com.byazt.uv.w;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 715, 5})
public class q extends com.byazt.pb.qg {
    public final WeakReference<w> n;

    public q(w wVar) {
        this.n = new WeakReference<>(wVar);
    }

    @Override // com.byazt.ew.n
    public void n() {
        if (this.n.get() != null) {
            this.n.get().n(0);
        }
    }

    @Override // com.byazt.ew.n
    public void n(int i, String str) {
        WeakReference<w> weakReference = this.n;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.n.get();
    }
}
