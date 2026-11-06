package com.smartdigimkt.u1;

import android.text.TextUtils;
import com.smartdigimkt.n3.k;
import com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView;
import com.smartdigimkt.t2.v;
import com.smartdigimkt.t2.z;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ d b;

    public b(d dVar, int i) {
        this.b = dVar;
        this.a = i;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003c  */
    @Override // java.lang.Runnable
    public final void run() {
        long j;
        long jA = this.b.a();
        BasePlayerView basePlayerView = this.b.h;
        long j2 = 0;
        long videoLength = basePlayerView != null ? basePlayerView.getVideoLength() : 0L;
        if (this.b.d != null) {
            z zVarA = z.a();
            String str = this.b.d.i;
            zVarA.getClass();
            v vVarA = TextUtils.isEmpty(str) ? null : zVarA.b.a(str);
            if (vVarA != null) {
                j2 = vVarA.e;
                j = vVarA.d;
            } else {
                j = 0;
            }
        } else {
            j = 0;
        }
        d dVar = this.b;
        com.smartdigimkt.a3.a aVar = dVar.c;
        com.smartdigimkt.b3.c cVar = dVar.d;
        int i = this.a;
        com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(String.valueOf(aVar.c), String.valueOf(aVar.k));
        cVar2.a = "1004707";
        cVar2.a(aVar);
        cVar2.l = String.valueOf(aVar.k);
        cVar2.m = aVar.f;
        cVar2.n = String.valueOf(aVar.c);
        if (cVar instanceof com.smartdigimkt.b3.b) {
            com.smartdigimkt.b3.b bVar = (com.smartdigimkt.b3.b) cVar;
            cVar2.o = bVar.c0;
            cVar2.p = bVar.a;
        }
        cVar2.q = String.valueOf(i);
        cVar2.r = String.valueOf(jA);
        cVar2.s = String.format("%.2f", Double.valueOf((j2 / 1024.0d) / 1024.0d));
        cVar2.t = String.valueOf(videoLength);
        cVar2.u = String.format("%.2f", Double.valueOf((j / 1024.0d) / 1024.0d));
        k.a(cVar2);
    }
}
