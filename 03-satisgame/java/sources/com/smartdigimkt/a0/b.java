package com.smartdigimkt.a0;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.sdk.api.IOfferClickHandler;
import com.smartdigimkt.z.b0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public final String a = "k";
    public final Context b;
    public final com.smartdigimkt.b3.c c;
    public final com.smartdigimkt.a3.a d;
    public final r e;
    public final e f;
    public final IOfferClickHandler g;

    public b(a aVar) {
        this.b = aVar.a;
        this.c = aVar.b;
        this.d = aVar.c;
        this.e = aVar.d;
        this.f = aVar.e;
        this.g = aVar.f;
    }

    public final com.smartdigimkt.h0.f a() {
        if (this.c == null) {
            return null;
        }
        return (com.smartdigimkt.h0.f) b0.a().a.get(this.c.e() + this.c.a);
    }

    public final s a(com.smartdigimkt.h0.m mVar) {
        com.smartdigimkt.b3.c cVar = this.c;
        if (cVar != null && !TextUtils.isEmpty(cVar.m)) {
            boolean zA = com.smartdigimkt.c0.h.a(this.b, this.c.m);
            if (mVar != null) {
                mVar.i = new com.smartdigimkt.h0.b();
                com.smartdigimkt.h0.f fVarA = a();
                mVar.i.a = fVarA != null ? fVarA.b : "";
                com.smartdigimkt.h0.a aVar = mVar.g;
                if (aVar != null) {
                    aVar.j = zA ? 5 : aVar.j;
                }
            }
            if (zA) {
                r rVar = this.e;
                if (rVar != null) {
                    rVar.a();
                }
                com.smartdigimkt.z.s.a(25, this.c, mVar);
                e eVar = this.f;
                if (eVar != null) {
                    eVar.b();
                    this.f.a();
                    this.f.a(true);
                    this.f.c();
                }
                return new s(true);
            }
            com.smartdigimkt.z.s.a(26, this.c, mVar);
        }
        return null;
    }
}
