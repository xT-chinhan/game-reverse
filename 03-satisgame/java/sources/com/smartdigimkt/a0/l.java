package com.smartdigimkt.a0;

import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements Runnable {
    public final /* synthetic */ m a;

    public l(m mVar) {
        this.a = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String scheme;
        com.smartdigimkt.h0.a aVar;
        m mVar;
        com.smartdigimkt.b3.c cVar;
        com.smartdigimkt.b3.e eVar;
        r rVar;
        boolean z = com.smartdigimkt.x.j.a().h;
        this.a.e.add(Boolean.valueOf(z));
        if (this.a.e.size() == 3 && (cVar = (mVar = this.a).a) != null && (eVar = cVar.w) != null && eVar.F1 == 1 && !z && (rVar = mVar.f) != null) {
            rVar.b();
        }
        if (this.a.e.size() < 5) {
            m mVar2 = this.a;
            mVar2.getClass();
            com.smartdigimkt.q3.f.a().a(new l(mVar2), 1000L, 2);
            return;
        }
        m mVar3 = this.a;
        if (TextUtils.isEmpty(mVar3.c)) {
            scheme = "";
        } else {
            try {
                scheme = Uri.parse(mVar3.c).getScheme();
            } catch (Throwable unused) {
                scheme = "";
            }
        }
        com.smartdigimkt.h0.m mVar4 = mVar3.d;
        int i = (mVar4 == null || (aVar = mVar4.g) == null) ? -1 : aVar.s;
        com.smartdigimkt.b3.c cVar2 = mVar3.a;
        com.smartdigimkt.a3.a aVar2 = mVar3.b;
        String str = mVar3.c;
        ArrayList arrayList = mVar3.e;
        boolean z2 = com.smartdigimkt.x.j.a().p;
        if (cVar2 == null || aVar2 == null) {
            return;
        }
        com.smartdigimkt.f3.c cVar3 = new com.smartdigimkt.f3.c(String.valueOf(aVar2.c), String.valueOf(aVar2.k));
        cVar3.a = "1004756";
        cVar3.a(aVar2);
        cVar3.l = cVar2.a;
        if (cVar2 instanceof com.smartdigimkt.b3.b) {
            cVar3.m = ((com.smartdigimkt.b3.b) cVar2).c0;
        }
        cVar3.n = str;
        cVar3.o = scheme;
        cVar3.p = String.valueOf(aVar2.c);
        cVar3.r = String.valueOf(i);
        if (arrayList != null && arrayList.size() == 5) {
            Boolean bool = (Boolean) arrayList.get(0);
            Boolean bool2 = (Boolean) arrayList.get(1);
            Boolean bool3 = (Boolean) arrayList.get(2);
            Boolean bool4 = (Boolean) arrayList.get(3);
            Boolean bool5 = (Boolean) arrayList.get(4);
            if (bool != null) {
                cVar3.s = bool.booleanValue() ? "1" : "2";
            }
            if (bool2 != null) {
                cVar3.t = bool2.booleanValue() ? "1" : "2";
            }
            if (bool3 != null) {
                cVar3.u = bool3.booleanValue() ? "1" : "2";
            }
            if (bool4 != null) {
                cVar3.v = bool4.booleanValue() ? "1" : "2";
            }
            if (bool5 != null) {
                cVar3.w = bool5.booleanValue() ? "1" : "2";
            }
        }
        cVar3.x = z2 ? "1" : "2";
        com.smartdigimkt.b3.e eVar2 = cVar2.w;
        cVar3.y = String.valueOf(eVar2 != null ? eVar2.H1 : 2);
        if (cVar2.o == 3 && TextUtils.isEmpty(cVar2.m) && !TextUtils.isEmpty(scheme)) {
            cVar3.z = com.smartdigimkt.p.a.a(scheme, "://");
        }
        com.smartdigimkt.b3.e eVar3 = aVar2.s;
        if (eVar3 != null) {
            cVar3.A = String.valueOf(eVar3.M);
        }
        com.smartdigimkt.n3.k.a(cVar3);
    }
}
