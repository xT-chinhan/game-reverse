package com.smartdigimkt.a0;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends b {
    public p(a aVar) {
        super(aVar);
    }

    public final s b() {
        s sVarA;
        com.smartdigimkt.b3.c cVar = this.c;
        String str = cVar != null ? cVar.N : "";
        if (TextUtils.isEmpty(str)) {
            return new s(false);
        }
        com.smartdigimkt.h0.m mVar = this.e.b;
        if (mVar == null) {
            return new s(false);
        }
        e eVar = this.f;
        if (eVar != null) {
            eVar.b();
            this.f.a();
        }
        if (!TextUtils.isEmpty(this.c.m) && (sVarA = a(mVar)) != null) {
            return sVarA;
        }
        com.smartdigimkt.z.j jVarA = com.smartdigimkt.c0.h.a(this.b, this.d, this.c, str);
        int i = jVarA.a;
        boolean z = i == 5;
        if (i != 0 && !z) {
            com.smartdigimkt.n3.k.a(this.d, this.c, str, "0", 2, 0, jVarA.b);
            return new s(false);
        }
        com.smartdigimkt.z.s.a(this.b, this.c);
        r rVar = this.e;
        if (rVar != null) {
            rVar.a();
        }
        e eVar2 = this.f;
        if (eVar2 != null) {
            eVar2.c();
        }
        com.smartdigimkt.n3.k.a(this.d, this.c, str, "1", 2, 0, jVarA.b);
        return new s(true);
    }
}
