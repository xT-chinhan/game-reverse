package com.smartdigimkt.q;

import com.smartdigimkt.odopt.api.ATOaidBindHandler;
import com.smartdigimkt.t.f;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements a {
    public final /* synthetic */ c a;

    public b(c cVar) {
        this.a = cVar;
    }

    @Override // com.smartdigimkt.q.a
    public final void a(String str, boolean z) {
        a aVar = this.a.a;
        if (aVar != null) {
            aVar.a(str, z);
        }
    }

    @Override // com.smartdigimkt.q.a
    public final void a(String str) {
        f.a(5, str);
        c cVar = this.a;
        ATOaidBindHandler.handleInitOaidBind(cVar.b, cVar.a);
    }
}
