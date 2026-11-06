package com.smartdigimkt.e;

import android.graphics.Bitmap;
import com.smartdigimkt.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements Runnable {
    public final /* synthetic */ Bitmap a;
    public final /* synthetic */ k b;

    public j(k kVar, Bitmap bitmap) {
        this.b = kVar;
        this.a = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object tag = this.b.f.a.getTag(R.id.sdm_bubble_delay_runnable_tag);
        l lVar = this.b.f;
        if (tag != lVar.b[0]) {
            q.a(this.a);
            return;
        }
        if (q.a(lVar.a)) {
            k kVar = this.b;
            l lVar2 = kVar.f;
            q.a(lVar2.a, this.a, kVar.c, kVar.d, lVar2.b[0]);
        } else {
            q.a(this.a);
            l lVar3 = this.b.f;
            q.b(lVar3.a, lVar3.b[0]);
        }
    }
}
