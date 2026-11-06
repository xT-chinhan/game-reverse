package com.smartdigimkt.d0;

import android.text.TextUtils;
import com.smartdigimkt.sdk.basead.webtemplet.WTWebView;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements com.smartdigimkt.k2.x {
    public final /* synthetic */ long a;
    public final /* synthetic */ m b;

    public l(m mVar, long j) {
        this.b = mVar;
        this.a = j;
    }

    @Override // com.smartdigimkt.k2.x
    public final void a() {
        q qVar = this.b.e.d;
        long j = this.a;
        if (!TextUtils.isEmpty(qVar.y)) {
            com.smartdigimkt.n3.b.a().a(System.currentTimeMillis() - j, qVar.y, "wbv");
        }
        m mVar = this.b;
        n nVar = mVar.e;
        String str = mVar.b;
        long j2 = mVar.d;
        String str2 = mVar.a;
        if (nVar.a && !TextUtils.isEmpty(str)) {
            com.smartdigimkt.q3.f.a().a(new r((WTWebView) s.b.remove(str)));
        }
        nVar.a(0, j2, "", str2, true);
    }

    @Override // com.smartdigimkt.k2.x
    public final void a(com.smartdigimkt.h0.g gVar) {
        n nVar = this.b.e;
        int i = TextUtils.equals(gVar.a, com.anythink.core.common.inner.b.b.u) ? 5 : 4;
        String strA = gVar.a();
        m mVar = this.b;
        nVar.a(i, mVar.d, strA, mVar.a, false);
    }
}
