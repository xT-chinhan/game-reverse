package com.smartdigimkt.f;

import android.os.SystemClock;
import com.smartdigimkt.r4.a0;
import com.smartdigimkt.sdk.api.AdError;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends com.smartdigimkt.f4.b {
    public long r;
    public final l s;

    public k(l lVar) {
        super(lVar);
        this.s = lVar;
    }

    @Override // com.smartdigimkt.f4.b
    public final void a(int i, com.smartdigimkt.a4.b bVar) {
        this.r = System.currentTimeMillis();
        SystemClock.elapsedRealtime();
        super.a(0, bVar);
    }

    @Override // com.smartdigimkt.f4.b
    public final void a(AdError adError) {
    }

    @Override // com.smartdigimkt.f4.b
    public final void b(AdError adError) {
        String code = adError.getCode();
        String message = adError.getMessage();
        this.s.getClass();
        com.smartdigimkt.n3.k.a("hf", code, message, a0.a("kwwsv=22gvs0dsl0fq1phwulfvolqnv1frp2dsl2frqyhuvlrq2sj"), "", "", "");
    }

    @Override // com.smartdigimkt.f4.b
    public final Object a(Object obj) {
        com.smartdigimkt.n3.k.a(this.r, System.currentTimeMillis(), "hf", (String) null);
        return obj;
    }
}
