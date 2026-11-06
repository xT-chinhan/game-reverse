package com.smartdigimkt.n1;

import android.text.TextUtils;
import com.smartdigimkt.sdk.basead.ui.PlayerView;

/* JADX INFO: loaded from: classes3.dex */
public final class k4 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;
    public final /* synthetic */ PlayerView d;

    public k4(PlayerView playerView, int i, long j, long j2) {
        this.d = playerView;
        this.a = i;
        this.b = j;
        this.c = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j;
        long j2;
        PlayerView playerView = this.d;
        String str = PlayerView.TAG;
        if (playerView.q == null || playerView.p == null) {
            return;
        }
        com.smartdigimkt.t2.z zVarA = com.smartdigimkt.t2.z.a();
        String str2 = this.d.p.i;
        zVarA.getClass();
        com.smartdigimkt.t2.v vVarA = TextUtils.isEmpty(str2) ? null : zVarA.b.a(str2);
        if (vVarA != null) {
            j = vVarA.e;
            j2 = vVarA.d;
        } else {
            j = 0;
            j2 = 0;
        }
        PlayerView playerView2 = this.d;
        com.smartdigimkt.a3.a aVar = playerView2.q;
        com.smartdigimkt.b3.c cVar = playerView2.p;
        int i = this.a;
        long j3 = this.b;
        long j4 = this.c;
        com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(String.valueOf(aVar.c), String.valueOf(aVar.k));
        cVar2.a = "1004708";
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
        cVar2.r = String.valueOf(j3);
        cVar2.s = String.format("%.2f", Double.valueOf((j / 1024.0d) / 1024.0d));
        cVar2.t = String.valueOf(j4);
        cVar2.u = String.format("%.2f", Double.valueOf((j2 / 1024.0d) / 1024.0d));
        com.smartdigimkt.b3.e eVar = aVar.s;
        if (eVar != null) {
            long j5 = eVar.b1;
            if (j5 > 0) {
                cVar2.v = String.valueOf(j5);
            }
        }
        com.smartdigimkt.n3.k.a(cVar2);
    }
}
