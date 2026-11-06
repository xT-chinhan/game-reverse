package com.smartdigimkt.f1;

import android.text.TextUtils;
import com.smartdigimkt.d0.p;
import com.smartdigimkt.h0.g;
import com.smartdigimkt.h0.m;
import com.smartdigimkt.j1.f;
import com.smartdigimkt.z.c0;
import com.smartdigimkt.z.s;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements p {
    public final /* synthetic */ com.smartdigimkt.a3.a a;
    public final /* synthetic */ com.smartdigimkt.e1.c b;
    public final /* synthetic */ com.smartdigimkt.b3.b c;
    public final /* synthetic */ d d;

    public c(d dVar, com.smartdigimkt.a3.a aVar, com.smartdigimkt.e1.c cVar, com.smartdigimkt.b3.b bVar) {
        this.d = dVar;
        this.a = aVar;
        this.b = cVar;
        this.c = bVar;
    }

    @Override // com.smartdigimkt.d0.p
    public final void a() {
        this.d.b(this.a);
        com.smartdigimkt.e1.c cVar = this.b;
        if (cVar != null) {
            com.smartdigimkt.b3.b bVar = this.c;
            com.smartdigimkt.e1.d dVar = cVar.c;
            dVar.e = bVar;
            com.smartdigimkt.a3.a aVar = dVar.c;
            dVar.i = new com.smartdigimkt.g1.c(bVar, aVar);
            String str = "";
            s.a(33, bVar, new m(aVar, ""));
            com.smartdigimkt.n3.b.a().a(cVar.a).b = System.currentTimeMillis();
            int iA = c0.a(bVar, cVar.c.c);
            if ((iA < 0 || iA > 4) && iA != 7 && iA != 8) {
                iA = -1;
            }
            int i = iA;
            if (TextUtils.equals(String.valueOf(cVar.c.c.c), "0")) {
                str = !cVar.c.c.w ? "0" : "1";
            }
            com.smartdigimkt.e1.d.a(cVar.c, cVar.a, bVar, str, true, i);
            cVar.c.g = true;
            f fVar = cVar.b;
            if (fVar != null) {
                fVar.b();
            }
        }
    }

    @Override // com.smartdigimkt.d0.p
    public final void a(g gVar) {
        this.d.b(this.a);
        com.smartdigimkt.e1.c cVar = this.b;
        if (cVar != null) {
            cVar.a(this.c, gVar);
        }
    }
}
