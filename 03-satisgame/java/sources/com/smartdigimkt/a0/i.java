package com.smartdigimkt.a0;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends com.smartdigimkt.p3.a {
    public final /* synthetic */ j b;

    public i(j jVar) {
        this.b = jVar;
    }

    @Override // com.smartdigimkt.p3.a
    public final int a() {
        return 50;
    }

    @Override // com.smartdigimkt.p3.a
    public final void b() {
        g gVar;
        if (!TextUtils.isEmpty(this.b.a)) {
            j jVar = this.b;
            if (!jVar.b.equals(jVar.a)) {
                j jVar2 = this.b;
                int i = jVar2.c;
                if (i != 2 && i != 3) {
                    k kVar = jVar2.d;
                    String str = kVar.a;
                    com.smartdigimkt.n3.k.a(kVar.d, kVar.c, jVar2.b, jVar2.a, 2);
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                j jVar3 = this.b;
                k kVar2 = jVar3.d;
                if (jCurrentTimeMillis - kVar2.i > 5000) {
                    return;
                }
                com.smartdigimkt.n3.k.a(kVar2.d, kVar2.c, jVar3.b, jVar3.a, 0);
                k kVar3 = this.b.d;
                if (kVar3.d.s.e1 == 1 && (gVar = kVar3.k) != null) {
                    this.b.d.k.a(5, gVar.b());
                    return;
                }
                return;
            }
        }
        j jVar4 = this.b;
        k kVar4 = jVar4.d;
        String str2 = kVar4.a;
        com.smartdigimkt.n3.k.a(kVar4.d, kVar4.c, jVar4.b, jVar4.a, 1);
    }
}
